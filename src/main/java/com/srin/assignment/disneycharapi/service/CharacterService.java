package com.srin.assignment.disneycharapi.service;

import com.srin.assignment.disneycharapi.enums.ResponseEnum;
import com.srin.assignment.disneycharapi.exception.CustomException;
import com.srin.assignment.disneycharapi.repository.CharacterRepository;
import com.srin.assignment.disneycharapi.entity.Character;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public Character addCharacter(Character character){
        var _character = characterRepository.findById(character.getId()).orElse(null);

        if(_character != null){
            String message = String.format(ResponseEnum.CHARACTER_ALREADY_EXIST.getMessage(), character.getId());
            throw new CustomException(ResponseEnum.CHARACTER_ALREADY_EXIST, message);
        }
        return characterRepository.save(character);
    }

    public List<Character> getAllCharacter() {
        var characters = characterRepository.findAll();
        if (characters.isEmpty()){
            throw new CustomException(ResponseEnum.DATA_NOT_EXIST);
        }
        return characters;
    }

    public Character getCharacterById(String id){
        var character = characterRepository.findById(id);
        String message = String.format(ResponseEnum.CHARACTER_NOT_FOUND.getMessage(), id);
        return character.orElseThrow(() ->new CustomException(ResponseEnum.CHARACTER_NOT_FOUND, message));
    }

    public Character updateCharacter(Character character){
        var _character = characterRepository.findById(character.getId()).orElse(null);

        if(_character != null){
            _character.setName(character.getName());
            _character.setKind(character.getKind());
            _character.setFilms(character.getFilms());
            _character.setVoiceActors(character.getVoiceActors());

            return characterRepository.save(_character);
        }
        else {
            String message = String.format(ResponseEnum.CHARACTER_NOT_FOUND.getMessage(), character.getId());
            throw new CustomException(ResponseEnum.CHARACTER_NOT_FOUND, message);
        }
    }

    public Boolean deleteCharacter(String id){
        var character = characterRepository.findById(id).orElse(null);
        if (character == null) {
            String message = String.format(ResponseEnum.CHARACTER_NOT_FOUND.getMessage(), id);
            throw new CustomException(ResponseEnum.CHARACTER_NOT_FOUND, message);
        }
        try{
            characterRepository.deleteById(id);
            return true;
        }
        catch (Exception ex){
            throw new CustomException(ResponseEnum.FAILED_DELETE_DATA);
        }
    }
}

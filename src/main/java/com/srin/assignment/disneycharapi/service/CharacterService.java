package com.srin.assignment.disneycharapi.service;

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
        return characterRepository.save(character);
    }

    public List<Character> getAllCharacter(){
        var a = characterRepository.findAll();
        log.info("get is finish");
        return a;
    }

    public Character getCharacterById(String id){
        var character = characterRepository.findById(id);
        return character.orElse(null);
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
            return null;
        }
    }

    public Boolean deleteCharacter(String id){
        try{
            characterRepository.deleteById(id);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
}

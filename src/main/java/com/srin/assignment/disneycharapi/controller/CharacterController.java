package com.srin.assignment.disneycharapi.controller;

import com.srin.assignment.disneycharapi.service.CharacterService;
import com.srin.assignment.disneycharapi.entity.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacter() {
        log.info("#getAllCharacter()");
        return characterService.getAllCharacter();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable("id") String id){
        log.info("#getCharacterById() with id : {}",id);
        return characterService.getCharacterById(id);
    }

    @PostMapping
    public Character addCharacter(@RequestBody @Valid Character character){
        log.info("#addCharacter() with character : {}",character);
        return characterService.addCharacter(character);
    }

    @PutMapping
    public Character updateCharacter(@RequestBody @Valid Character character){
        log.info("#updateCharacter() with character : {}",character);
        return characterService.updateCharacter(character);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCharacter(@PathVariable("id") String id){
        log.info("#deleteCharacter() with id : {}",id);
        return characterService.deleteCharacter(id);
    }


}

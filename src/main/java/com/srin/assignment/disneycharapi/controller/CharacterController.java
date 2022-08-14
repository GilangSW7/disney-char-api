package com.srin.assignment.disneycharapi.controller;

import com.srin.assignment.disneycharapi.service.CharacterService;
import com.srin.assignment.disneycharapi.entity.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacter(){
        return characterService.getAllCharacter();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable("id") String id){
        return characterService.getCharacterById(id);
    }

    @PostMapping
    public Character addCharacter(@RequestBody Character character){
        return characterService.addCharacter(character);
    }

    @PutMapping
    public Character updateCharacter(@RequestBody Character character){
        return characterService.updateCharacter(character);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCharacter(@PathVariable("id") String id){
        return characterService.deleteCharacter(id);
    }


}

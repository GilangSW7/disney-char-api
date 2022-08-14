package com.srin.assignment.disneycharapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.srin.assignment.disneycharapi.entity.Character;

public interface CharacterRepository extends MongoRepository<Character,String> {
}

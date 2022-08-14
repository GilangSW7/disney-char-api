package com.srin.assignment.disneycharapi.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "characters")
public class Character {

    @Id
    private String id;

    private String name;
    private String kind;

    private List<Film> films;
    private List<VoiceActor> voiceActors;

}

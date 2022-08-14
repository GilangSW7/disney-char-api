package com.srin.assignment.disneycharapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document
public class VoiceActor {
    private String name;
    private String language;
}

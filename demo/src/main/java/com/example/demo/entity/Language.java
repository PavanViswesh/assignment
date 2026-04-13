package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {

    @Id
    private String id;

    private String name;
}
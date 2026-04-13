package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    private String id;

    private String name;
}
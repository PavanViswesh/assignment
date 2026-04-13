package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "states")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    private String id;

    private String name;

    private String countryId;
    private String countryName;
}
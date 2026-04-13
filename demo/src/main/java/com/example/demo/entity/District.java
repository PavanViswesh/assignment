package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "districts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {

    @Id
    private String id;

    private String name;

    private String stateId;
    private String stateName;

    private String countryId;
    private String countryName;
}
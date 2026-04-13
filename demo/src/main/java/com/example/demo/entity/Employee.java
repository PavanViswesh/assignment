package com.example.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private String id;

    private String name;
    private String email;
    private String mobile;

    private String countryId;
    private String countryName;

    private String stateId;
    private String stateName;

    private String districtId;
    private String districtName;

    private String gender;

    private List<String> languageIds;
    private List<String> languageNames;
}
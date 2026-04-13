package com.example.demo.repository;

import com.example.demo.entity.District;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DistrictRepository extends MongoRepository<District, String> {

    List<District> findByStateId(String stateId);
}
package com.example.demo.repository;

import com.example.demo.entity.State;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StateRepository extends MongoRepository<State, String> {

    List<State> findByCountryId(String countryId);
}
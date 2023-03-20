package com.codingdojo.repositories;

import com.codingdojo.models.Bedroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BedroomRepository extends CrudRepository<Bedroom,Long> {
    List<Bedroom> findAll();
}

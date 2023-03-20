package com.codingdojo.acelerati.acelerati.repositories;

import com.codingdojo.acelerati.acelerati.models.Dojo;
import com.codingdojo.acelerati.acelerati.models.Ninja;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja,Long> {

    List<Ninja> findByDojo(Dojo dojo);

}

package com.codingdojo.acelerati.acelerati.services;


import com.codingdojo.acelerati.acelerati.models.Dojo;
import com.codingdojo.acelerati.acelerati.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    public DojoService( DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;

    }

    public Dojo addDojo(Dojo dojo){

        return dojoRepository.save(dojo);
    }

    public Dojo find(Long id){
        return dojoRepository.findById(id).orElse(null);
    }

    public List<Dojo> allDojo() {
        return dojoRepository.findAll();


    }
}

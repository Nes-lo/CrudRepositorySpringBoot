package com.codingdojo.acelerati.acelerati.services;



import com.codingdojo.acelerati.acelerati.models.Dojo;
import com.codingdojo.acelerati.acelerati.models.Ninja;
import com.codingdojo.acelerati.acelerati.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja addNinja(Ninja ninja){

        return ninjaRepository.save(ninja);
    }

    public List<Ninja> findByDojo(Dojo dojo){
        return ninjaRepository.findByDojo(dojo);

    }

}

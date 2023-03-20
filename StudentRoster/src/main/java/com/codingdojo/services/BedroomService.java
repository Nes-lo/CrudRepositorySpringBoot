package com.codingdojo.services;

import com.codingdojo.models.Bedroom;
import com.codingdojo.repositories.BedroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BedroomService {
    public final BedroomRepository bedroomRepository;


    public BedroomService(BedroomRepository bedroomRepository) {
        this.bedroomRepository = bedroomRepository;
    }

    public List<Bedroom> allBedrooms(){
        return bedroomRepository.findAll();
    }
    public Bedroom addBedroom(Bedroom bedroom){
        return bedroomRepository.save(bedroom);
    }

    public Bedroom findBedroomById(Long id){

        return bedroomRepository.findById(id).orElse(null);
    }
}

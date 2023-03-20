package com.codingdojo.controllers;

import com.codingdojo.models.Bedroom;
import com.codingdojo.services.BedroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BedroomController {
    @Autowired
    private BedroomService bedroomService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("bedrooms",bedroomService.allBedrooms());
        return "bedrooms.jsp";
    }
    @GetMapping("/bedrooms/new")
    public String newDorm(@ModelAttribute("bedroom") Bedroom bedroom) {
        return "newBedroom.jsp";
    }
    @PostMapping("/bedrooms/new")
    public String addDorm(@Valid @ModelAttribute("bedroom") Bedroom bedroom, BindingResult result) {

        if(result.hasErrors()) {

            return "newBedroom.jsp";
        }
        bedroomService.addBedroom(bedroom);
        return "redirect:/";
    }

    @GetMapping("/bedrooms/{id}")
    public String viewBedroom(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bedroom", bedroomService.findBedroomById(id));
        model.addAttribute("students",  bedroomService.findBedroomById(id).getStudents());
        return "viewBedroom.jsp";
    }
}

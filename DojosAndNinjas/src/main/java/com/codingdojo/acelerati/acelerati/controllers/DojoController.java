package com.codingdojo.acelerati.acelerati.controllers;

import com.codingdojo.acelerati.acelerati.models.Dojo;
import com.codingdojo.acelerati.acelerati.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DojoController {

    @Autowired
    DojoService dojoService;

    @GetMapping("/newDojo")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo){

   return "newDojo.jsp";
    }

    @PostMapping("/savedDojo")
    public  String savedDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "newDojo.jsp";
        }
        dojoService.addDojo(dojo);
        return "redirect:/";
    }

    @GetMapping("/seeDojos")
    public String seeDojo(Model model){

        model.addAttribute("dojos",dojoService.allDojo());


        return "seeDojos.jsp";
    }

}

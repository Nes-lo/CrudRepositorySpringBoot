package com.codingdojo.acelerati.acelerati.controllers;

import com.codingdojo.acelerati.acelerati.models.Dojo;
import com.codingdojo.acelerati.acelerati.models.Ninja;
import com.codingdojo.acelerati.acelerati.services.DojoService;
import com.codingdojo.acelerati.acelerati.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {


   private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("/newNinja")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){

        model.addAttribute("dojos",dojoService.allDojo());
        return "newNinja.jsp";
    }

    @PostMapping("/ninja/savedNinja")
    public  String savedNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("dojos",dojoService.allDojo());
          //  model.addAttribute("dojo", dojoService.find(id));
           return "newNinja.jsp";
        }
        ninjaService.addNinja(ninja);
        return "redirect:/";
    }

    @GetMapping("/info/{id}")
    public String ninjaInfo(@PathVariable("id") Long id, Model model){

        model.addAttribute("ninjas",ninjaService.findByDojo(dojoService.find(id)));

        return "info.jsp";
    }

}

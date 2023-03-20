package com.codingdojo.acelerati.acelerati.controllers;





import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping({"/index","/home","/"})
    public String index(){

        return "index.jsp";
    }
}

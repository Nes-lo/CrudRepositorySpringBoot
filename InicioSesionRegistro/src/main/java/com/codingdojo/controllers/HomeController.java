package com.codingdojo.controllers;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    // Añadir una vez implementado el servicio:
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if(session.getAttribute("user")==null){
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        return "index.jsp";
    }

    @GetMapping("/register")
    public String register(){

        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session, RedirectAttributes attribute) {
            userService.saveUser(newUser,result);

             if(result.hasErrors()) {
            // Asegúrate de enviar el LoginUser vacío antes
            // de volver a renderizar la página.
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
            }
        attribute.addFlashAttribute("success", "Registro Exitoso");
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(){

        return "redirect:/";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
      User user=userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        user.setPassword("");
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("user",null);
        return "redirect:/";
    }

}
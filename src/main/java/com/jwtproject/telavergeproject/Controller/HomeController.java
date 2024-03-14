package com.jwtproject.telavergeproject.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {


//    https://localhost:9090/adimin/user
    @GetMapping("/user")
    public String home(){



        return "Ye Lo user ka data";
    }




}

package com.example.controller;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	
    @GetMapping("/")
    public String showhome(Model model, Authentication authentication) {
        boolean isLoggedIn = (authentication != null && authentication.isAuthenticated());
        model.addAttribute("isLoggedIn", isLoggedIn);
        
        if (isLoggedIn) {
            model.addAttribute("username", authentication.getName());
            var roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());
            
            model.addAttribute("isAdmin", roles.contains("ROLE_ADMIN"));
            model.addAttribute("isMod", roles.contains("ROLE_MODERATOR"));    
        } else {
            model.addAttribute("isAdmin", false);
            model.addAttribute("isMod", false);
        }
        
        
    
        
        
        
        
        return "home"; 
    }

    // ADD THIS: To prevent the 404 on /login
    @GetMapping("/login")
    public String login() {
        return "login"; // You need to create a login.html in templates
    }
    
    @GetMapping("/data")
    public String currencyConvertor(Model model) {
    //  ------------------------------------------------------
        // Task 5 Data: Create a BigDecimal price
           BigDecimal itemPrice = new BigDecimal("1250.75");
           
           // Add it to the model so #format can access it
           model.addAttribute("price", itemPrice);
           
           return "data";
    }
    
  
}
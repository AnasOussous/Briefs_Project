package com.brief11.gestion.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brief11.gestion.model.Admin;
import com.brief11.gestion.service.LoginService;
 

@Controller
public class LoginController {
@Autowired
    private LoginService userService;
 
                                  
    @GetMapping("/")
          
    public ModelAndView Admin() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Admin());
        return mav;
    }
 
    @PostMapping("/")
    public String login(@ModelAttribute("user") Admin user ) {
    
     Admin oauthUser = userService.login(user.getUsername(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/list";
    
    
     } else {
     return "redirect:/";
    
    
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/";
    }
 
}

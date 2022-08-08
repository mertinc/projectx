package com.minc.projectx.controllers;

import com.minc.projectx.entities.user.Role;
import com.minc.projectx.entities.user.User;
import com.minc.projectx.repositories.user.RoleRepository;
import com.minc.projectx.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @GetMapping(value="home")
    public String home(){
        return "Home page";
    }

    @GetMapping(value="admin")
    public String admiin(){
        return "Admin page";
    }

    @PostMapping(value = "addrole")
    public Role addRole(@RequestBody Role role){
       return roleRepository.save(role);
    }

    @PostMapping(value = "adduser")
    public User addRole(@RequestBody User user){
        return userService.addUser(user);

    }


}



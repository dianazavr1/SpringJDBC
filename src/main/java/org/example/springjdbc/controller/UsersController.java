package org.example.springjdbc.controller;

import org.example.springjdbc.model.Users;
import org.example.springjdbc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users>getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping("/add")
    public void addUsers(@RequestBody Users users){
        usersService.addUsers(users);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        usersService.deleteById(id);
    }
}

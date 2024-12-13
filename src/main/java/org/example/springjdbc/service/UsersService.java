package org.example.springjdbc.service;

import org.example.springjdbc.model.Users;
import org.example.springjdbc.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public List<Users>getAllUsers(){
        return usersRepository.getAllUsers();
    }

    public void addUsers (Users users){
        usersRepository.addUsers(users);
    }
    public void deleteById(Long id){
        usersRepository.deleteById(id);
    }

}

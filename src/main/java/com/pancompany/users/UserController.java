package com.pancompany.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Terence on 12/02/2018.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long userId){
        userRepository.delete(userId);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userRepository.save(user);
    }
}

package com.example.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping(value = "/users")
public class UserService {

    protected Logger logger = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

}


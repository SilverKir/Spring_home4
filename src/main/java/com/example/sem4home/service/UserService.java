package com.example.sem4home.service;

import com.example.sem4home.model.User;
import com.example.sem4home.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
private UserRepository repository;

    public User getUserById(int id) {
        return repository.findUserById(id);
    }

    public List<User> findALL() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void updateUser(User user) {
        repository.update(user);
    }
}

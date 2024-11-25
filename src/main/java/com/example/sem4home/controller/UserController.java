package com.example.sem4home.controller;

import com.example.sem4home.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.sem4home.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {
        private UserService userService;

        @GetMapping
        public String index(){
            return "home.html";
        }


        @GetMapping("/users")
        public String findAll(Model model) {
            List<User> users = userService.findALL();
            model.addAttribute("users", users);
            return "user-list";
        }

        @GetMapping("/user-create")
        public String createUserForm(User user) {
            return "user-create";
        }

        @PostMapping("/user-create")
        public String createUser(User user) {
            userService.saveUser(user);
            return "redirect:/users";
        }

        @GetMapping("user-delete/{id}")
        public String deleteUser(@PathVariable("id") int id) {
            userService.deleteById(id);
            return "redirect:/users";
        }

        @GetMapping("user-update/{id}")
        public String updateUser(@PathVariable("id") int id, Model model) {
            User user = userService.getUserById(id);
            model.addAttribute("user", user);
            return "user-update";
        }

        @PostMapping("/user-update/{id}")
        public String updateUser( User user) {
            userService.updateUser(user);
            return "redirect:/users";
        }

    }

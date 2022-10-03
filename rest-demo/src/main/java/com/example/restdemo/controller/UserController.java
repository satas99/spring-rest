package com.example.restdemo.controller;

import com.example.restdemo.entity.User;
import com.example.restdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //a Spring annotation that is used to build REST API in a declarative way.
@RequestMapping("/users") //used to map web requests onto specific handler classes and/or handler methods.
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<User>> update(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }
}

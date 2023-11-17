package com.aicap.springbootwebapi.controller;

import com.aicap.springbootwebapi.entity.Event;
import com.aicap.springbootwebapi.entity.User;
import com.aicap.springbootwebapi.entity.dto.UserDto;
import com.aicap.springbootwebapi.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    UserService userService;

//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUser(id).getEmail(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PostMapping
//    public ResponseEntity<User> saveUser(@RequestBody UserDto user) {
//        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
//    }

    @GetMapping
    public ResponseEntity<List<User>> retriveAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/events")
    public ResponseEntity<List<Event>> getEnrolledEvents(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getEnrolledEvents(id), HttpStatus.OK);
    }
}

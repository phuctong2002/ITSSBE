package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO){
        UserDTO confirmUserDTO = userService.getUserDTO( userDTO);
        if (confirmUserDTO == null) return null;
        return new ResponseEntity<>(confirmUserDTO, HttpStatus.OK);
    }
}

package com.example.ITSSBE.controller;

import com.example.ITSSBE.dto.RegisterDTO;
import com.example.ITSSBE.service.RegisterService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @GetMapping("/")
    public ResponseEntity<Object> getRegisters(){
        return new ResponseEntity<>(registerService.getRegisters(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Object> addRegister(@RequestBody RegisterDTO registerDTO){
        return new ResponseEntity<>( registerService.addRegister( registerDTO), HttpStatus.CREATED);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Object> editRegister(@RequestBody RegisterDTO registerDTO, @PathVariable int id){
        return new ResponseEntity<>(registerService.changeRegister( registerDTO, id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRegister(@PathVariable int id){
        return new ResponseEntity<>(registerService.getRegister(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRegister( @PathVariable int id){
        registerService.deleteRegister(id);
        return null;
    }

}

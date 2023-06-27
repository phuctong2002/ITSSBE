package com.example.ITSSBE.service;

import com.example.ITSSBE.converter.UserConverter;
import com.example.ITSSBE.dto.UserDTO;
import com.example.ITSSBE.entity.User;
import com.example.ITSSBE.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private UserConverter userConverter;

    public UserDTO getUserDTO(UserDTO userDTO) {
        User user = userRepo.findByGmailAndPassword( userDTO.getGmail(), userDTO.getPassword());
        if( user == null) return null;
        return userConverter.toDTO(user);
    }
}

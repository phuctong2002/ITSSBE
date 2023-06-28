package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepo extends JpaRepository<Register, Integer> {

    Register findFirstById(int id);


}

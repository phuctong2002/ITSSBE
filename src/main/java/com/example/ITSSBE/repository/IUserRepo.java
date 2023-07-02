package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
    User findByGmailAndPassword(String gmail, String password);

    User findFirstById(int id);
    @Query( value = "select * from user where role != 2", nativeQuery = true)
    List<User> findByRole();
    @Query( value = "select * from user where role = 2", nativeQuery = true)
    List<User> findCustomers();
}

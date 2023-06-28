package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
//    @Query( value = "SELECT * FROM user where gmail = :gmail AND password = :password LIMIT 1")
//    User findByGmailAndPassword(@Param("gmail") String gmail, @Param("password") String password);
    User findByGmailAndPassword(String gmail, String password);

    User findFirstById(int id);
}

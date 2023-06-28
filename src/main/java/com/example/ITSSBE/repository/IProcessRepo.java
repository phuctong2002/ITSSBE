package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Process;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessRepo extends JpaRepository<Process, Integer> {
    @Modifying
    @Query( value = "DELETE FROM process where register = :id", nativeQuery = true)
    @Transactional
    void deleteByRegister(@Param("id")int id);
}

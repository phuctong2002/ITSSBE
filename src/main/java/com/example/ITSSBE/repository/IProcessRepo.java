package com.example.ITSSBE.repository;

import com.example.ITSSBE.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcessRepo extends JpaRepository<Process, Integer> {
}

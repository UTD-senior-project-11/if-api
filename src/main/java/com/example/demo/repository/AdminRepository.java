package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, String> {

}
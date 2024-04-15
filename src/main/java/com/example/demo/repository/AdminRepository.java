package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, String> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Administrator (adminID, adminUser, adminPass) VALUES (?1, ?2, ?3)", nativeQuery = true)
    public void saveAdministrator(int adminID, String adminUser, String adminPass);

    @Query(value = "SELECT COUNT(*) FROM Administrator", nativeQuery = true)
    public int getLastRow();
}
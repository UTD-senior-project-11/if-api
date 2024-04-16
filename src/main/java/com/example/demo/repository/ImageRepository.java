package com.example.demo.repository;

import java.sql.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Image (imageID, imageData, imageSizeKB, bannedStatus) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    public void saveImage(int imageID, Blob imageData, int imageSize, Boolean bannedStatus);
}
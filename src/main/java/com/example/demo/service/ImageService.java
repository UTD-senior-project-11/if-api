package com.example.demo.service;

import com.example.demo.model.Image;
import java.util.*;
import java.sql.*;

//Needs more (to link with AI)
public interface ImageService {
    public void saveImage(Image image);

    public int getIndex();

    public int checkDuplicate(Image image);

    public List<Blob> getAllImages();
}
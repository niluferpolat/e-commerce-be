package com.ecommercebe.project.Dto;

import com.ecommercebe.project.Entity.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class ProductRequest {
    private String name;
    private String explanation;
    private double price;
    private MultipartFile base64Image;
    private Category category;
}

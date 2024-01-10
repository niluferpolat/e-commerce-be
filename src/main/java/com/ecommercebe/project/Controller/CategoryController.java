package com.ecommercebe.project.Controller;

import com.ecommercebe.project.Entity.Category;
import com.ecommercebe.project.Service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "e-commerce")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getCategories")
    public List<Category> getCategories(){
        return categoryService.getAllCategories();
    }
}

package com.ecommercebe.project.Controller;

import com.ecommercebe.project.Dto.ProductRequest;
import com.ecommercebe.project.Entity.Product;
import com.ecommercebe.project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getProductDetails")
    public Product getProductDetails(@RequestParam Long id){
        return productService.getProductById(id);
    }
    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductRequest productRequest) throws IOException {
        productService.addProduct(productRequest);
    }

}

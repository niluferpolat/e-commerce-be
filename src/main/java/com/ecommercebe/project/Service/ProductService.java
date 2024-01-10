package com.ecommercebe.project.Service;

import com.ecommercebe.project.Dto.ProductRequest;
import com.ecommercebe.project.Entity.Product;
import com.ecommercebe.project.Entity.Request.ProductSearchQuery;
import com.ecommercebe.project.Repository.ProductRepository;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

    public void addProduct(ProductRequest productRequest) throws IOException {
        Product product = new Product();
        String fileName = StringUtils.cleanPath(productRequest.getBase64Image().getOriginalFilename());
        if(fileName.contains("..")){
            throw new IOException("Not a valid file");
        }
        try{
            product.setBase64Image(Base64.getEncoder().encodeToString(productRequest.getBase64Image().getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
        product.setName(productRequest.getName());
        product.setCategory(productRequest.getCategory());
        product.setPrice(productRequest.getPrice());
        product.setExplanation(productRequest.getExplanation());
        productRepository.save(product);
    }
    public List<Product> searchProduct(ProductSearchQuery productSearchQuery){
        return productRepository.findByNameStartsWithIgnoreCaseOrCategoryIdIn(productSearchQuery.getValue(),productSearchQuery.getIdList());
    }
}

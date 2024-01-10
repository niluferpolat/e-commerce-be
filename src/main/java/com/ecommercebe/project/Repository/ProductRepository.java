package com.ecommercebe.project.Repository;

import com.ecommercebe.project.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameStartsWithIgnoreCaseOrCategoryIdIn(String value,List<Long> idList);
}

package com.ecommercebe.project.Repository;

import com.ecommercebe.project.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}

package com.ecommercebe.project.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product",schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String explanation;
    private double price;
    private String base64Image;

    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;
}

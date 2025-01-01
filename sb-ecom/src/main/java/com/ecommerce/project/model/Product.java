package com.ecommerce.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO )
 private Long productId ;
 private String productName ;
 private String image ;
 private String Description ;
 private Integer quantity ;
 private double Price ;
 private double specialPrice ;
 private double discount ;

 @ManyToOne
 @JoinColumn(name = "category_id")
 private Category category ;
}

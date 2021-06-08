package com.example.miniprojet.Views;

import com.example.miniprojet.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductView extends JpaRepository<Product, Long>{
}

package com.example.miniprojet.Views;

import com.example.miniprojet.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryView extends JpaRepository<Category ,Long>{
}

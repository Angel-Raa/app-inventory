package com.company.araa.Inventory.service;

import com.company.araa.Inventory.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    ResponseEntity<List<Category>> findAllCategory();
    ResponseEntity<Optional<Category>> findByIdCategory(Long id);
    ResponseEntity<Category> saveCategory(Category category);
    ResponseEntity<Category> updateCategory(Long id, Category category);
    ResponseEntity<?> deleteCategory(Long id);
}

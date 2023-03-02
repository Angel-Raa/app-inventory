package com.company.araa.Inventory.controller;

import com.company.araa.Inventory.models.Category;
import com.company.araa.Inventory.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> listCategory() {
        return service.findAllCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> category(@PathVariable Long id) {
        return service.findByIdCategory(id);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody @Valid Category category) {
        return service.saveCategory(category);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody @Valid Category category) {
        return ResponseEntity.ok(service.updateCategory(id, category));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        return service.deleteCategory(id);
    }


}

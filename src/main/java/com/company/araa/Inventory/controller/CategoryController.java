package com.company.araa.Inventory.controller;

import com.company.araa.Inventory.models.Category;
import com.company.araa.Inventory.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody @Valid Category category) {
        return service.saveCategory(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody @Valid Category category, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put("Error " + err.getField(), "Campo incorrect"));
            return ResponseEntity.badRequest().body(errores);
        }
        return  ResponseEntity.ok(service.updateCategory(id, category));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        return service.deleteCategory(id);
    }


}

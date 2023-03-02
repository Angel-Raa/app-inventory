package com.company.araa.Inventory.service.Impl;

import com.company.araa.Inventory.exception.ResourceNotFondException;
import com.company.araa.Inventory.models.Category;
import com.company.araa.Inventory.repository.CategoryRepository;
import com.company.araa.Inventory.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Category>> findAllCategory() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Optional<Category>> findByIdCategory(Long id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()) {
            return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
        } else {
            throw new ResourceNotFondException("Could not find", id.toString());
        }

    }

    @Override
    @Transactional
    public ResponseEntity<Category> saveCategory(Category category) {
        return new ResponseEntity<>(repository.save(category), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<Category> updateCategory(Long id, Category category) {
        Category updateToCategory = repository.findById(id).orElseThrow(() -> new ResourceNotFondException("could not find category", id));
        BeanUtils.copyProperties(category, updateToCategory, "id", "createAt");
        Category update = repository.save(updateToCategory);
        return  ResponseEntity.ok(update);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteCategory(Long id) {
        Optional<Category> categoryId = repository.findById(id);
        if (categoryId.isPresent()) {
            repository.deleteById(id);
        }
        return categoryId.isPresent() ? ResponseEntity.notFound().build() : ResponseEntity.noContent().build();

    }
}

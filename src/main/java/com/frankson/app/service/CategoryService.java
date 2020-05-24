package com.frankson.app.service;

import com.frankson.app.exception.ObjectNotFoundException;
import com.frankson.app.model.Category;
import com.frankson.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findCategory(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return  category.orElseThrow(() -> new ObjectNotFoundException(String.format("Object not found! id: %s, type: %s", id, Category.class.getName())));
    }
}

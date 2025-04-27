package com.nygma.tournamaster.service;

import com.nygma.tournamaster.model.Category;
import com.nygma.tournamaster.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.orElse(null);
    }
}

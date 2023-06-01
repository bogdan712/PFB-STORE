package com.kreitek.demo.application.service;

import com.kreitek.demo.application.dto.CategoryDTO;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> getCategoryById(Long categoryId);

    CategoryDTO saveCategory(CategoryDTO category);

    void deleteCategory(Long categoryId);
}

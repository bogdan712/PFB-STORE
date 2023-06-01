package com.kreitek.demo.domain.persistence;

import com.kreitek.demo.domain.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {
    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long categoryId);

    Category saveCategory(Category category);

    void deleteCategory(Long categoryId);
}

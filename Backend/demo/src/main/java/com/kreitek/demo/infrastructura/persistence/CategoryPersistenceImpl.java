package com.kreitek.demo.infrastructura.persistence;

import com.kreitek.demo.domain.entity.Category;
import com.kreitek.demo.domain.persistence.CategoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoryPersistenceImpl implements CategoryPersistence {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryPersistenceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long categoryId) {
        return this.categoryRepository.findById(categoryId);
    }

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryRepository.deleteById(categoryId);

    }
}

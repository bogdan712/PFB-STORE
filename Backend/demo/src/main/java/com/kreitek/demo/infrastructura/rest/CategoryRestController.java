package com.kreitek.demo.infrastructura.rest;

import com.kreitek.demo.application.dto.CategoryDTO;
import com.kreitek.demo.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryRestController {
    private CategoryService categoryService;
    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @CrossOrigin
    @GetMapping(value = "/categories", produces = "application/json")
    ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categories = this.categoryService.getAllCategories();
        return  new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping (value = "/categories", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO categoryDTO){
        categoryDTO = this.categoryService.saveCategory(categoryDTO);
        return  new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping(value = "/categories/{id}", produces = "application/json")
    ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

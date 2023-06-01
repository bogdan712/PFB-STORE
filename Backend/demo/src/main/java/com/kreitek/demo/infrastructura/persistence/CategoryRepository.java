package com.kreitek.demo.infrastructura.persistence;

import com.kreitek.demo.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category,Long> {
}

package com.kreitek.demo.infrastructura.persistence;

import com.kreitek.demo.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>,
        JpaSpecificationExecutor<Item> {
    List<Item> findAllByCategoryId(Long id);
}
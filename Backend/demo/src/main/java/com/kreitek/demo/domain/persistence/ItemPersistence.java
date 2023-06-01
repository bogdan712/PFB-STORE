package com.kreitek.demo.domain.persistence;

import com.kreitek.demo.domain.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface ItemPersistence {
    List<Item> getAllItems();
    List<Item> getAllItemsByCategory(Long categoryId);
    Optional<Item> getItemById(Long itemId);
    Item saveItem(Item item);
    void deleteItem(Long itemId);
    Page<Item> findAll(Pageable pageable, String filter);


}

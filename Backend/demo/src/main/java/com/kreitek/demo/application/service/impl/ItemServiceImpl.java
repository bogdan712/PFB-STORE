package com.kreitek.demo.application.service.impl;

import com.kreitek.demo.application.dto.ItemDTO;
import com.kreitek.demo.application.mapper.ItemMapper;
import com.kreitek.demo.application.service.ItemService;
import com.kreitek.demo.domain.entity.Item;
import com.kreitek.demo.domain.persistence.ItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemPersistence persistence;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImpl(ItemPersistence persistence, ItemMapper mapper) {
        this.persistence = persistence;
        this.mapper = mapper;
    }

    @Override
    public Page<ItemDTO> getItemByCriterialStringPaged (Pageable pageable, String filter) {
        Page<Item> itemPage = this.persistence.findAll(pageable, filter);
        return itemPage.map(mapper::toDto);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = this.persistence.getAllItems();
        return mapper.toDto(items);
    }

    @Override
    public List<ItemDTO> getAllItemsByCategory(Long categoryId) {
        List<Item> items = this.persistence.getAllItemsByCategory(categoryId);
        return mapper.toDto(items);
    }

    @Override
    public Optional<ItemDTO> getItemById(Long itemId) {
        return this.persistence.getItemById(itemId).map(mapper::toDto);
    }

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        Item item = this.persistence.saveItem(this.mapper.toEntity(itemDTO));
        return this.mapper.toDto(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.persistence.deleteItem(itemId);
    }
}

package com.kreitek.demo.application.mapper;

import com.kreitek.demo.application.dto.ItemDTO;
import com.kreitek.demo.domain.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
    @Override
    @Mapping(source = "categoryId", target = "category")
    Item toEntity(ItemDTO dto);

    @Override
    @Mapping(source = "category.id",target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    ItemDTO toDto(Item entity);
}



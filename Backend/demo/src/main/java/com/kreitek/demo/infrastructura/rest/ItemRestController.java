package com.kreitek.demo.infrastructura.rest;

import com.kreitek.demo.application.dto.ItemDTO;
import com.kreitek.demo.application.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController

public class ItemRestController {

    public final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping(value = "/items", produces = "application/json")
    public ResponseEntity<Page<ItemDTO>> getItemByCriterialPaged(@RequestParam(value = "filter", required = false)String filter, org.springframework.data.domain.Pageable pageable) {

        Page<ItemDTO> items = this.itemService.getItemByCriterialStringPaged(pageable, filter);
        return new ResponseEntity<Page<ItemDTO>>(items, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/categories/{idCategory}/items", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getAllItemsFromCategory(@PathVariable Long idCategory) {
        List<ItemDTO> items = this.itemService.getAllItemsByCategory(idCategory);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/items/all", produces = "application/json")
    ResponseEntity<List<ItemDTO>> getAllItems(){
        List<ItemDTO> items = this.itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value = "/items", produces = "application/json", consumes = "application/json")
    ResponseEntity<ItemDTO> insertItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO itemSaved = this.itemService.saveItem(itemDTO);
        return new ResponseEntity<>(itemSaved, HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping(value = "/items/{itemId}", produces = "application/json")
    ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        this.itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}








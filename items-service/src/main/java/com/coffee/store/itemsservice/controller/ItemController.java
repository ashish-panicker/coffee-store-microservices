package com.coffee.store.itemsservice.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coffee.store.itemsservice.model.Item;
import com.coffee.store.itemsservice.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired private ItemRepository itemRepository;
    

    @GetMapping({ "/", "" })
    public ResponseEntity<Map<Object, Object>> getAllItems() {
        var items = itemRepository.findAll();
        var response = new HashMap<Object, Object>();

        if (items.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "Items found");
        response.put("items", items);
        response.put("status", HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemRepository.findById(id).orElseThrow());
    }

    @PostMapping({ "/", "" })
    public ResponseEntity<Map<Object, Object>> createItem(@RequestBody Item item) {
        // return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(item));
        Map<Object, Object> response = new HashMap<>();
        var it = itemRepository.save(item);

        response.put("status", HttpStatus.CREATED);
        response.put("item", itemRepository.save(item));
        response.put("message", "Item created successfully");
        response.put("location", "/store/items/" + it.getId());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("/list")
    public ResponseEntity<Map<Object, Object>> createItems(@RequestBody List<Integer> ids) {
        Map<Object, Object> response = new HashMap<>();
        
        List<Item> items =  (List<Item>) itemRepository.findAllById(ids);
        if(items.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("status", HttpStatus.OK);
        response.put("items", items);
        
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

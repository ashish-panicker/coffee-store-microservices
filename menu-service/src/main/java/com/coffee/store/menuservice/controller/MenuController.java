package com.coffee.store.menuservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import com.coffee.store.menuservice.model.Menu;
import com.coffee.store.menuservice.repository.MenuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired RestTemplate restTemplate;

    @Autowired MenuRepository menuRepository;

    @PostMapping(value="")
    public ResponseEntity<Menu> createMenu(@RequestBody MenuDTO menuDto) {


        ItemDTO itemDTO =  restTemplate.postForObject("http://localhost:5000/store/items/list", 
            menuDto.getItems(), 
            ItemDTO.class);
        Menu entity = new Menu();
        entity.setMenuDate(menuDto.getMenuDate());
        entity.setItems(itemDTO.getItems());
        entity.setUpdatedDate(LocalDate.now());
        Menu menu = menuRepository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(menu);
    }
    
    
}

package com.coffee.store.itemsservice.repository;

import com.coffee.store.itemsservice.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item, Integer> {

    
    
}

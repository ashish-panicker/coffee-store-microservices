package com.coffee.store.menuservice.controller;

import java.util.List;

import com.coffee.store.menuservice.model.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ItemDTO {
    
    private List<Item> items;
}

package com.coffee.store.menuservice.controller;

import java.time.LocalDate;
import java.util.List;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MenuDTO {


    private LocalDate menuDate;

    private List<Integer> items;

}

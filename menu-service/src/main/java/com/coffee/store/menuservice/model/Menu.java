package com.coffee.store.menuservice.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "menus")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate menuDate;

    @OneToMany(mappedBy = "menu", 
        cascade =  CascadeType.ALL, 
        fetch = FetchType.EAGER)
    private List<Item> items;

    @Column(name = "updated_on", nullable = false)
    private LocalDate updatedDate;
    
}

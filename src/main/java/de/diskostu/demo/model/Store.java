package de.diskostu.demo.model;


import lombok.Getter;

@Getter
public class Store {

    private Item item;


    public Store(Item item) {
        this.item = item;
    }
}

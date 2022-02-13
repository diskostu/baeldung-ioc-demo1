package de.diskostu.demo.baeldungicodemo1;


import lombok.Getter;

@Getter
public class Store {

    private Item item;


    public Store(Item item) {
        this.item = item;
    }
}

package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.items.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Integer> inventory = new LinkedHashMap<String, Integer>();

    private boolean isAlreadyInInventory(Item item) {
        return inventory.containsKey(item.getItemName());
    }

    public void addItem(Item item) {

        if (isAlreadyInInventory(item)) {
            inventory.put(item.getItemName(), inventory.get(item.getItemName()) + 1);

        } else {
            inventory.put(item.getClass().getName(), 1);

        }
        System.out.println("inventory bitch");
        System.out.println(inventory.toString());
    }

    public void useItem(Item item) {

        if (isAlreadyInInventory(item)) {
            inventory.put(item.getItemName(), inventory.get(item.getItemName()) - 1);
        }
    }
}

package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.items.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Integer> playerInventory = new LinkedHashMap<>();

    public void addItem(Item item) {

        if (isItemInInventory(item.getItemName())) {
            playerInventory.put(item.getItemName(), playerInventory.get(item.getItemName()) + 1);

        } else {
            playerInventory.put(item.getItemName(), 1);
        }
    }

    public boolean isItemInInventory(String itemName){
        return playerInventory.containsKey(itemName);
    }

    public Map<String, Integer> getPlayerInventory() {
        return playerInventory;
    }
}

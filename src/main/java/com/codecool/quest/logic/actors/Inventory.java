package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.items.Item;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Inventory {

    private Map<String, Integer> playerInventory = new LinkedHashMap<String, Integer>();

    private boolean isAlreadyInInventory(Item item) {
        return playerInventory.containsKey(item.getItemName());
    }

    public void addItem(Item item) {

        if (isAlreadyInInventory(item)) {
            playerInventory.put(item.getItemName(), playerInventory.get(item.getItemName()) + 1);

        } else {
            playerInventory.put(item.getItemName(), 1);

            System.out.println(playerInventory.toString());

        }
    }

    public void useItem(Item item) {

        if (isAlreadyInInventory(item)) {
            playerInventory.put(item.getItemName(), playerInventory.get(item.getItemName()) - 1);
        }
    }

    public Map getPlayerInventory() {
        return playerInventory;
    }
}

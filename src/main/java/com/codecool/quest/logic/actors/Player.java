package com.codecool.quest.logic.actors;

import java.util.LinkedHashMap;
import java.util.Map;
import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.items.Item;


public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public void acquireItem(Item item) {
        this.inventory.addItem(item);
        this.cell.setItem(null);
    }

    public String getTileName() {
        return "player";
    }
}

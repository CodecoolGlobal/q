package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Key extends Item {
    public Key(Cell cell) { super(cell); }

    @Override
    public String getTileName() {
        return "key";
    }
}
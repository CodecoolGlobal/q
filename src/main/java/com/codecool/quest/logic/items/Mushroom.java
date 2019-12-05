package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Mushroom extends Item {
    public Mushroom(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "mushroom";
    }


}

package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class Mushroom extends Item {
    public Mushroom(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "mushroom";
    }


}

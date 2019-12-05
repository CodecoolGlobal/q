package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class Gate extends Item{

    public Gate(Cell cell) { super(cell); }

    public String getTileName() {
        return "gate";
    }
}

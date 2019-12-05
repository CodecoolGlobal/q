package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;

public class AntiShroomPotion extends Item {
    public AntiShroomPotion(Cell cell) { super(cell); }

    public String getTileName() {
        return "antiShroomPotion";
    }
}

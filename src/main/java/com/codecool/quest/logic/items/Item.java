package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.Cell;

public abstract class Item implements Drawable {
    private Cell cell;

    public Item(Cell cell) {
        this.cell = cell;
        this.cell.setItem(this);
    }

    public String getItemName() {
        return this.getClass().getSimpleName();
    }

}
package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Mushroom extends Item {
    public Mushroom(Cell cell) {
        super(cell);
    }
    private boolean mushrooming = false;

    @Override
    public String getTileName() {
        if (this.mushrooming) {
            return "shroomed";
        }
        return "doomed";
    }

    public void setMushrooming(){
        this.mushrooming = true;
    }

}

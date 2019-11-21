package com.codecool.quest.logic.items;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Door extends Item {
    public Door(Cell cell) { super(cell); }
    private boolean isOpen = false;

    @Override
    public String getTileName() {
        if (this.isOpen){
            return "openDoor";
        }

        return "closedDoor";
    }

    public boolean getDoorStatus(){
        return isOpen;
    }

    public void setDoorStatus(){
        this.isOpen = true;
    }
}
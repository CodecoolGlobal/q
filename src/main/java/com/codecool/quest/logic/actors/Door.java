package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Door extends Actor {
    public Door(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "door";
    }
}
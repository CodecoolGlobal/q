package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Mushroom extends Actor {
    public Mushroom(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "mushroom";
    }
}
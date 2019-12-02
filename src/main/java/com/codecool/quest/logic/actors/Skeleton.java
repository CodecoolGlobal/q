package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Skeleton extends Actor {
    String tileName = "skeleton";

    public Skeleton(Cell cell) {
        super(cell);
        this.health = 6;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }


    @Override
    public void attack(Actor target) {

    }


    @Override
    public void defend(Actor attacker) {
        if (this.health < 1) {
            this.setTileName("grave");
            this.health = 0;
        } else {
            attacker.health = attacker.health - 2;
        }
    }
}

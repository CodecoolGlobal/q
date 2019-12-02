package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
        this.health = 6;
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }


    @Override
    public void attack(Actor target) {

    }


    @Override
    public void defend(Actor attacker) {
        attacker.health = attacker.health - 2;
    }
}

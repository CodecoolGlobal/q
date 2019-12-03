package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

public class DeadlyDuck extends Actor {
    String tileName = "deadlyDuck";

    public DeadlyDuck(Cell cell) {
        super(cell);
        this.health = 9;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }


    @Override
    public void attack(Actor target, Cell cell) {

    }


    @Override
    public void defend(Actor attacker, Cell cell) {
        if (this.health < 1) {
            this.health = 0;
            cell.setActor(null);
        } else {
            attacker.health = attacker.health - 2;
        }
    }

    @Override
    protected void setDefaultEnemyHealth(Cell nextCell) {

    }
    public void generateMove(){}
}
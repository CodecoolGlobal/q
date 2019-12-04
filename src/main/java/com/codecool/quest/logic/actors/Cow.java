package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Cow extends Enemy {
    String tileName = "cow";

    public Cow(Cell cell) {
        super(cell);
        this.health = 13;
    }


    public String getTileName() {
        return tileName;
    }

    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }


    public void defend(Actor attacker, Cell cell) {
        if (this.health < 1) {
            this.health = 0;
            cell.setActor(null);
        } else {
            attacker.health = attacker.health - 2;
        }
    }

    public void move(int dx, int dy) {
    }

    public void setDefaultEnemyHealth(Cell nextCell) {
    }


    protected int setDefaultTurnsToMove() {
        return 0;
    }

}
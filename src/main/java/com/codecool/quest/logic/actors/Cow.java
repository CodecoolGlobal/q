package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Cow extends Enemy {
    String tileName = "cow";

    public Cow(Cell cell) {
        super(cell);
        this.health = 13;
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
    public void move(int dx, int dy) {
    }

    public void setDefaultEnemyHealth(Cell nextCell){}

    @Override
    protected int setDefaultTurnsToMove() {
        return 0;
    }

}
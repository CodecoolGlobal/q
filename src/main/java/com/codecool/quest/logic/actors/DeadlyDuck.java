package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class DeadlyDuck extends Enemy {
    String tileName = "deadlyDuck";
    private static final int DEFAULT_TURNS_TO_MOVE = 30;

    public DeadlyDuck(Cell cell) {
        super(cell);
        this.health = 9;
        this.turnsToMove = DEFAULT_TURNS_TO_MOVE;
        this.maxDistance = 2;
        this.damage = 5;
        this.defenseDamage = 3;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }


    protected void setDefaultEnemyHealth(Cell nextCell) {

    }

    protected int setDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }


}
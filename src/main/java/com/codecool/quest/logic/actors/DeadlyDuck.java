package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class DeadlyDuck extends Enemy {
    private static final int DEFAULT_TURNS_TO_MOVE = 30;

    public DeadlyDuck(Cell cell) {
        super(cell);
        this.health = 9;
        this.tileName = "deadlyDuck";
        this.turnsToMove = DEFAULT_TURNS_TO_MOVE;
        this.maxDistance = 2;
        this.damage = 5;
        this.defenseDamage = 3;
    }

    public String getTileName() {
        return tileName;
    }

    protected int getDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }
}
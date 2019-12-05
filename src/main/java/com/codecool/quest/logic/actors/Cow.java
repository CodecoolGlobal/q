package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Cow extends Enemy {
    private static final int DEFAULT_TURNS_TO_MOVE = 900000000;

    public Cow(Cell cell) {
        super(cell);
        this.health = 15;
        this.tileName = "cow";
        this.turnsToMove = DEFAULT_TURNS_TO_MOVE;
        this.maxDistance = 1;
        this.damage = 8;
        this.defenseDamage = 5;

    }

    @Override
    public void generateMove(){}

    public String getTileName() {
        return tileName;
    }

    protected int getDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }


}
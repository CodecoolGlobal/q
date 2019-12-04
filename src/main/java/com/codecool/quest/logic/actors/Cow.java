package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

public class Cow extends Enemy {
    String tileName = "cow";
    private static final int DEFAULT_TURNS_TO_MOVE = 60;


    public Cow(Cell cell) {
        super(cell);
        this.health = 15;
        this.turnsToMove = DEFAULT_TURNS_TO_MOVE;
        this.maxDistance = 0;
        this.damage = 8;
        this.defenseDamage = 5;

    }


    public String getTileName() {
        return tileName;
    }


    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }


    public void move(int dx, int dy) {
    }


    protected int getDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }


}
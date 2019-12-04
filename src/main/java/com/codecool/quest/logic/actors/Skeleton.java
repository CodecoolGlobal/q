package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

import java.util.Random;

public class Skeleton extends Enemy {
    String tileName = "skeleton";
    private static final Random RANDOM_DIRECTION = new Random();
    private static final int DEFAULT_TURNS_TO_MOVE = 60;

    public Skeleton(Cell cell) {
        super(cell);
        this.health = 6;
        this.turnsToMove = DEFAULT_TURNS_TO_MOVE;
        this.maxDistance = 2;
        this.damage = 3;
        this.defenseDamage = 2;
    }

    @Override
    public String getTileName() {
        return tileName;
    }

    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }

    public void setDefaultEnemyHealth(Cell nextCell){}

    protected int getDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }


}

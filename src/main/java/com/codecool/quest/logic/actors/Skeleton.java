package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

import java.util.Random;

public class Skeleton extends Enemy {
    private static final Random RANDOM_DIRECTION = new Random();
    private static final int DEFAULT_TURNS_TO_MOVE = 60;

    public Skeleton(Cell cell) {
        super(cell);
        this.health = 6;
        this.tileName = "skeleton";
        this.turnsToMove = DEFAULT_TURNS_TO_MOVE;
        this.maxDistance = 2;
        this.damage = 3;
        this.defenseDamage = 2;
    }

    public String getTileName() {
        return tileName;
    }

    protected int getDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }
}

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
        this.turnsToMove = 60;
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

    @Override
    public void attack(Actor target, Cell cell) {
        if (target instanceof Player) {
            target.health = target.health - damage;
        }
    }

    @Override
    public void defend(Actor attacker, Cell cell) {
        if (this.health < 1) {
            this.health = 0;
            cell.setActor(null);
        } else {
            attacker.health = attacker.health - defenseDamage;
        }
    }

    public void setDefaultEnemyHealth(Cell nextCell){}

    protected int setDefaultTurnsToMove() {
        return DEFAULT_TURNS_TO_MOVE;
    }


}

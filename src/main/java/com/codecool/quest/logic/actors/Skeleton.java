package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

import java.util.List;
import java.util.Random;

public class Skeleton extends Actor {
    String tileName = "skeleton";
    private int turnsToMove = 60;
    public static final Random RANDOM_DIRECTION = new Random();

    public Skeleton(Cell cell) {
        super(cell);
        this.health = 6;
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
    public void setDefaultEnemyHealth(Cell nextCell){}

    public void generateMove(){
        if (turnsToMove>0) {
            turnsToMove -= 1;
            return;
        }
        turnsToMove = 60;
        int axleXY = RANDOM_DIRECTION.nextInt(2);
        int direction = RANDOM_DIRECTION.nextInt(2);
        direction = (direction == 0) ? -1 : 1;

        System.out.println(this.cell.getX());
        System.out.println(this.cell.getY());

        if (axleXY == 0){
            this.move(direction,0);
        } else {
            this.move(0,direction);
        }
    }
}

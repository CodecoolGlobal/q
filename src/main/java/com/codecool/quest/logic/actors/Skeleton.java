package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.actors.Actor;

import java.util.List;
import java.util.Random;

public class Skeleton extends Actor {
    String tileName = "skeleton";
    private int turnsToMove = 60;

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
        Random random = new Random();
        int axleXY = random.nextInt(1);
        int direction = random.nextInt(1);
        direction = (direction == 0) ? -1 : 1;
        if (axleXY == 0){
            this.move(this.cell.getX()+direction,this.cell.getY());
        } else {
            this.move(this.cell.getX(),this.cell.getY()+direction);
        }
    }
}

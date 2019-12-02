package com.codecool.quest.logic.actors;

import java.util.LinkedHashMap;
import java.util.Map;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.items.Door;
import com.codecool.quest.logic.items.Item;


public class Player extends Actor {
    private int enemyHealth = 0;
    String tileName = "player";

    public Player(Cell cell) {
        super(cell);
    }


    public void acquireItem(Item item) {
        if(item.getItemName().equals("Sword")){
            this.setTileName("playerWithSword");
        }
        this.inventory.addItem(item);
        this.cell.setItem(null);

    }

    public String getTileName() {
        return tileName;
    }

    public void setTileName(String newTileName) {
        this.tileName = newTileName;
    }


    @Override
    public void attack(Actor target, Cell cell) {
        if(inventory.isItemInInventor("Sword")){
            target.health = target.health - 8;
        } else {
            target.health = target.health - 5;
        }

        target.defend(this, cell);
        this.enemyHealth = target.getHealth();
    }

    @Override
    public void defend(Actor attacker,Cell cell) {
    }

    public int getEnemyHealth() {
        return this.enemyHealth;
    }

    public void setDefaultEnemyHealth(Cell neighbour) {
        if (neighbour.getActor() != null) {
            this.enemyHealth = neighbour.getActor().health;
        } else {
            this.enemyHealth = 0;
        }


    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getItem() instanceof Door && this.gotKey()) {
            this.setDefaultEnemyHealth(nextCell);
            makeMove(nextCell);
            ((Door) nextCell.getItem()).setDoorStatus();
        } else if ((nextCell.getActor() instanceof Skeleton)) {
            this.attack(nextCell.getActor(), nextCell);
        } else if (nextCell.getActor() == null && !(nextCell.getItem() instanceof Door)) {
            if (!nextCell.getType().equals(CellType.WALL)) {
                this.setDefaultEnemyHealth(nextCell);
                makeMove(nextCell);
                cell = nextCell;
            }
        } else if (!(nextCell.getActor() instanceof Skeleton || nextCell.getItem() instanceof Door)) {
            this.setDefaultEnemyHealth(nextCell);
            makeMove(nextCell);
        }
    }
}

package com.codecool.quest.logic.actors;

import java.util.LinkedHashMap;
import java.util.Map;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.actors.Actor;
import com.codecool.quest.logic.items.Door;
import com.codecool.quest.logic.items.Item;
import javafx.scene.input.KeyCode;


public class Player extends Actor {
    private int enemyHealth = 0;
    String tileName = "player";
    private KeyCode code;


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

    public void generateMove(){
        switch (code) {
            case W:
                this.move(0, -1);
                break;
            case S:
                this.move(0, 1);
                break;
            case A:
                this.move(-1, 0);
                break;
            case D:
                this.move(1, 0);
                break;
            case P:
                //this.acquireItem(getCurrentItem()); todo
                break;
        }
    }

    public void setlastKeyPressed(KeyCode code) {
        this.code = code;
    }
}

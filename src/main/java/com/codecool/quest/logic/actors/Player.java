package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.items.Door;
import com.codecool.quest.logic.items.Item;
import com.codecool.quest.logic.items.Milka;

import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.List;


public class Player extends Actor {
    private int enemyHealth = 0;
    private String tileName = "player";
    private KeyCode keyCode;
    private String name;
    private static final List<String> DEVELOPER_NAMES = new ArrayList<>() {
        {
            add("Peti");
            add("Miki");
            add("Avril");
        }
    };

    public Player(Cell cell) {
        super(cell);
        this.maxDistance = 1;
        this.damage = 5;
        this.name = "Axolotl";
    }

    public void acquireItem(Item item) {
        if (item.getItemName().equals("Sword")) {
            this.setTileName("playerWithSword");
        }
        if (item instanceof Milka) {
            this.health += 4;

        } else {
            this.inventory.addItem(item);
        }
        this.cell.setItem(null);
    }

    private void attack(Actor target, Cell cell) {
        if (inventory.isItemInInventory("Sword")) {
            damage += 3;
        }
        target.health = target.health - damage;
        ((Enemy) target).defend(this, cell);
        this.enemyHealth = target.getHealth();
    }

    public void generateMove() {
        int newMaxDistance;
        if (gotAntiShroomPotion()) {
            getSober();
        }
        if (isShroomed()) {
            this.setTileName("shroomedPlayer");
            newMaxDistance = -(maxDistance);
        } else {
            newMaxDistance = maxDistance;
        }
        if (keyCode == null) {
            return;
        }
        switch (keyCode) {
            case W:
                this.move(0, -newMaxDistance);
                break;
            case S:
                this.move(0, newMaxDistance);
                break;
            case A:
                this.move(-newMaxDistance, 0);
                break;
            case D:
                this.move(newMaxDistance, 0);
                break;
            case P:
                //this.acquireItem(getCurrentItem()); todo
                break;
        }
        keyCode = null;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (canOpenDoor(nextCell)) {

            this.setDefaultEnemyHealth(nextCell);
            makeMove(nextCell);
            ((Door) nextCell.getItem()).setDoorStatus();

        } else if (isEnemy(nextCell)) {
            this.attack(nextCell.getActor(), nextCell);

        } else if (emptyCell(nextCell)) {

            if (notWall(nextCell) || hasCheatCode()) {
                this.setDefaultEnemyHealth(nextCell);
                makeMove(nextCell);
                cell = nextCell;
            }
        } else if (!(isEnemy(nextCell)) && notDoor(nextCell)) {
            this.setDefaultEnemyHealth(nextCell);
            makeMove(nextCell);
        }
    }


    private boolean isShroomed() {
        return this.inventory.getPlayerInventory().containsKey("Mushroom");
    }

    private boolean gotKey() {
        return this.inventory.getPlayerInventory().containsKey("Key");

    }

    private boolean gotAntiShroomPotion() {
        return this.inventory.getPlayerInventory().containsKey("AntiShroomPotion");
    }

    private void getSober() {
        this.setTileName("player");
        this.inventory.getPlayerInventory().remove("Mushroom");

    }

    private boolean hasCheatCode() {
        return DEVELOPER_NAMES.contains(this.name);
    }

    private boolean canOpenDoor(Cell nextCell) {
        return nextCell.getItem() instanceof Door && this.gotKey();
    }


    public String getName() {
        return name;
    }

    public String getTileName() {
        return tileName;
    }

    public int getEnemyHealth() {
        return this.enemyHealth;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setTileName(String newTileName) {
        this.tileName = newTileName;
    }

    public void setDefaultEnemyHealth(Cell neighbour) {
        if (neighbour.getActor() != null) {
            this.enemyHealth = neighbour.getActor().health;
        } else {
            this.enemyHealth = 0;
        }
    }

    public void setLastKeyPressed(KeyCode code) {
        this.keyCode = code;
    }
}

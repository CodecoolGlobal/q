package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.items.Door;
import com.codecool.quest.logic.items.Item;

public abstract class Actor implements Drawable {
    protected Cell cell;
    protected int health = 10;
    protected Inventory inventory = new Inventory();

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }


    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public String getActorName() {
        return this.getClass().getName();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean gotKey() {
        return this.inventory.getPlayerInventory().containsKey("Key");

    }

    public void makeMove(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    public abstract void attack(Actor target, Cell cell);

    public abstract void defend(Actor attacker, Cell cell);

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

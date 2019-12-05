package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.items.Door;

public abstract class Actor implements Drawable {
    protected Cell cell;
    protected int health = 10;
    protected Inventory inventory = new Inventory();
    protected int maxDistance;
    protected int damage;

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


    public void makeMove(Cell nextCell) {
        cell.setActor(null);
        nextCell.setActor(this);
        cell = nextCell;
    }

    public abstract void attack(Actor target, Cell cell);

    public abstract void move(int dx, int dy);

    protected boolean isEnemy(Cell nextCell) {
        return (nextCell.getActor() instanceof Enemy);
    }

    protected boolean isPlayer(Cell nextCell) {
        return (nextCell.getActor() instanceof Player);
    }

    protected boolean emptyCell(Cell nextCell) {
        return nextCell.getActor() == null && nextCell.getItem() == null;
    }

    protected boolean notWall(Cell nextCell) {
        return !nextCell.getType().equals(CellType.WALL);
    }

    protected boolean notDoor(Cell nextCell) {
        return !(nextCell.getItem() instanceof Door);
    }


    protected abstract void setDefaultEnemyHealth(Cell nextCell);

    public abstract void generateMove();


}

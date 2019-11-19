package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;
import com.codecool.quest.logic.CellType;
import com.codecool.quest.logic.Drawable;
import com.codecool.quest.logic.items.Door;
import com.codecool.quest.logic.items.Item;

public abstract class Actor implements Drawable {
    protected Cell cell;
    private int health = 10;
    protected Inventory inventory = new Inventory();

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (nextCell.getActor() == null) {
            if (!nextCell.getType().equals(CellType.WALL)) {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        } else if (!(nextCell.getActor() instanceof Skeleton || nextCell.getItem() instanceof Door)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
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


}

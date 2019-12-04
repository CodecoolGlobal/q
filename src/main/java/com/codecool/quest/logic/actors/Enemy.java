package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Enemy extends Actor {
    private static final Random RANDOM_DIRECTION = new Random();
    protected int turnsToMove;
    protected int defenseDamage;
    protected static List<Enemy> enemies = new ArrayList<Enemy>();

    public Enemy(Cell cell) {
        super(cell);
        enemies.add(this);
    }

    public static List<Enemy> getEnemies() {
        return enemies;
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);

        if (emptyCell(nextCell)) {
            if (notWall(nextCell)) {

                this.setDefaultEnemyHealth(nextCell);
                makeMove(nextCell);
                cell = nextCell;
            }

        } else if (isPlayer(nextCell)) {
            this.attack(nextCell.getActor(), nextCell);

        } else if (!(isEnemy(nextCell))) {

            this.setDefaultEnemyHealth(nextCell);
            makeMove(nextCell);
        }
    }

    public boolean isEnemyDead() {
        return this.health < 1;
    }

    @Override
    protected void setDefaultEnemyHealth(Cell nextCell) {

    }

    public void generateMove() {
        if (turnsToMove > 0) {
            turnsToMove -= 1;
            return;
        }
        turnsToMove = getDefaultTurnsToMove();

        int stepDirection = RANDOM_DIRECTION.nextInt(2);
        int stepSize = RANDOM_DIRECTION.nextInt(maxDistance);

        int newStepSize = (stepSize == 0) ? -1 : stepSize;

        if (stepDirection == 0) {
            this.move(newStepSize, 0);
        } else {
            this.move(0, newStepSize);
        };
    }

    public void attack(Actor target, Cell cell) {
        if (target instanceof Player) {
            target.health = target.health - this.damage;
        }
    }

    public void defend(Actor attacker, Cell cell) {
        if (this.isEnemyDead()) {
            this.health = 0;
            cell.setActor(null);
            enemies.remove(this);
        } else {
            attacker.health = attacker.health - this.defenseDamage;
        }
    }

    protected abstract int getDefaultTurnsToMove();

    @Override
    public String getTileName() {
        return null;
    }
}

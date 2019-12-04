package com.codecool.quest.logic.actors;

import com.codecool.quest.logic.Cell;

import java.util.Random;

public abstract class Enemy extends Actor {
    private static final Random RANDOM_DIRECTION = new Random();
    protected int turnsToMove;

    public Enemy(Cell cell) {
        super(cell);
    }

    @Override
    public void attack(Actor target, Cell cell) {

    }

    @Override
    public void defend(Actor attacker, Cell cell) {

    }

    @Override
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

    @Override
    protected void setDefaultEnemyHealth(Cell nextCell) {

    }

    public void generateMove() {
        if (turnsToMove > 0) {
            turnsToMove -= 1;
            return;
        }
        turnsToMove = setDefaultTurnsToMove();

        int stepDirection = RANDOM_DIRECTION.nextInt(2);
        int stepSize = RANDOM_DIRECTION.nextInt(maxDistance);

        int newStepSize = (stepSize == 0) ? -1 : stepSize;

        if (stepDirection == 0) {
            this.move(newStepSize, 0);
        } else {
            this.move(0, newStepSize);
        };
    }

    protected abstract int setDefaultTurnsToMove();

    @Override
    public String getTileName() {
        return null;
    }
}

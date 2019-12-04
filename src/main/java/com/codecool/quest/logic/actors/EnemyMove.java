package com.codecool.quest.logic.actors;

import java.util.List;
import java.util.TimerTask;

public class EnemyMove extends TimerTask {

    private final Runnable refresh;
    private List<Enemy> enemies;
    public EnemyMove(List<Enemy> enemies, Runnable refresh) {
        this.enemies = enemies;
        this.refresh = refresh;

    }

    public void run() {
        for (Enemy enemy : enemies){
            enemy.generateMove();
        }
        refresh.run();
    }
}
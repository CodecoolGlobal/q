package com.codecool.quest.logic.actors;

import java.util.List;
import java.util.TimerTask;

public class EnemyMove extends TimerTask {

    private final Runnable refresh;
    private List<Actor> enemies;
    public EnemyMove(List<Actor> enemies, Runnable refresh) {
        this.enemies = enemies;
        this.refresh = refresh;

    }

    public void run() {
        for (Actor enemy : enemies){
            enemy.generateMove();
        }
        refresh.run();
    }

    public void generateMove(){}
}
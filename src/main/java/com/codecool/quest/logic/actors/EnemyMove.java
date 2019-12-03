package com.codecool.quest.logic.actors;

import com.codecool.quest.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.function.Function;

public class EnemyMove extends TimerTask {

    private final Runnable refresh;
    private List<Actor> enemys;
    public EnemyMove(List<Actor> enemys, Runnable refresh) {
        this.enemys = enemys;
        this.refresh = refresh;

    }

    public void run() {
        for (Actor enemy : enemys){
            enemy.generateMove();
        }
        refresh.run();
    }

    public void generateMove(){}
}
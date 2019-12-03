package com.codecool.quest.logic.actors;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.function.Function;

public class EnemyMove extends TimerTask {
    private List<Actor> enemys;
    public EnemyMove(List<Actor> enemys) {
        this.enemys = enemys;


    }

    public void run() {
        for (Actor enemy : enemys){
            enemy.generateMove();
        }
    }

    public void generateMove(){}
}
package com.codecool.quest;

import com.codecool.quest.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();

    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(20, 8));
        tileMap.put("playerWithSword", new Tile(18, 3));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("mushroom", new Tile(7, 2));
        tileMap.put("key", new Tile(17, 23));
        tileMap.put("closedDoor", new Tile(0, 10));
        tileMap.put("openDoor", new Tile(0, 11));
        tileMap.put("skullAndBones", new Tile(0, 15));
        tileMap.put("bullSkull", new Tile(1, 15));
        tileMap.put("campFire", new Tile(14, 10));
        tileMap.put("loath", new Tile(6, 2));
        tileMap.put("hellGate", new Tile(21, 11));
        tileMap.put("grave", new Tile(1, 14));
        tileMap.put("sword", new Tile(0, 30));
    }
    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}

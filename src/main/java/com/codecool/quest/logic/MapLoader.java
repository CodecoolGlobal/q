package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.*;
import com.codecool.quest.logic.items.Door;
import com.codecool.quest.logic.items.Key;
import com.codecool.quest.logic.items.Mushroom;
import com.codecool.quest.logic.items.Sword;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/map.txt");
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 'a':
                            cell.setType(CellType.SKULLANDBONES);
                            break;
                        case 'b':
                            cell.setType(CellType.BULLSKULL);
                            break;
                        case 'c':
                            cell.setType(CellType.CAMPFIRE);
                            break;
                        case 'l':
                            cell.setType(CellType.LOATH);
                            break;
                        case 'h':
                            cell.setType(CellType.HELLGATE);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            new Mushroom(cell);
                            break;
                        case 'w':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;

                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            new Door(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}

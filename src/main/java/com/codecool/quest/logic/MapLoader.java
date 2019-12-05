package com.codecool.quest.logic;

import com.codecool.quest.logic.actors.*;
import com.codecool.quest.logic.items.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapLoader {
    private static final List<String> LEVELS = new ArrayList<String>() {
        {
            add("/map1.txt");
            add("/map2.txt");
        }
    };

    public static GameMap loadMap( int level) {
        InputStream is = MapLoader.class.getResourceAsStream(LEVELS.get(level));
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
                        case 'g':
                            cell.setType(CellType.FLOOR);
                            new Gate(cell);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case 'u':
                            cell.setType(CellType.FLOOR);
                            new DeadlyDuck(cell);
                            break;
                        case 'f':
                            cell.setType(CellType.FLOOR);
                            new Cow(cell);
                            break;
                        case '+':
                            cell.setType(CellType.FLOOR);
                            new Milka(cell);
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
                        case 'm':
                            cell.setType(CellType.FLOOR);
                            new Mushroom(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.FLOOR);
                            new AntiShroomPotion(cell);
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

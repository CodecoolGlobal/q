package com.codecool.quest.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    SKULLANDBONES("skullAndBones"),
    BULLSKULL("bullSkull"),
    CAMPFIRE("campFire"),
    LOATH("loath"),
    GRAVE("grave");
    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}

package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon {
    private int damage;
    private Sprite sprite;
    private int isShortRange;
    private int isLongRange;
    private String name;
    public Weapon(Sprite sprite, String name){
        this.sprite = sprite;
        this.name = name;
    }
}

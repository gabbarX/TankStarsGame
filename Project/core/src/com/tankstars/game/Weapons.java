package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapons {
    private int damage;
    private Sprite weaponSprite;
    private int isShortRange;
    private int isLongRange;
    private String name;
    public Weapons(Sprite weaponSprite, String name){
        this.weaponSprite = weaponSprite;
        this.name = name;
    }
}

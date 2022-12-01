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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setIsShortRange(int isShortRange) {
        this.isShortRange = isShortRange;
    }

    public int getIsLongRange() {
        return isLongRange;
    }

    public void setIsLongRange(int isLongRange) {
        this.isLongRange = isLongRange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

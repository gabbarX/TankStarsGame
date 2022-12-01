package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TankFrost {
    private int hitPoints;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    private Sprite tankSprite;
    private Weapon FrostBlast;
    private Weapon FrostBite;
    private Weapon FrostBlizzard;
    private Weapon FrostAssaultDrones;
    private Weapon FrostHighPressure;
    private Weapon FrostIceSplitter;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public TankFrost(boolean isPlayer1, boolean isPlayer2){
        tankAtlas = new TextureAtlas("Tank/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankFrost"));
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = isPlayer2;
        FrostBlast = new Weapon(new Sprite(tankAtlas.findRegion("FrostBlast")), "Blast");
        FrostBite = new Weapon(new Sprite(tankAtlas.findRegion("FrostBite")), "Bite");
        FrostBlizzard = new Weapon(new Sprite(tankAtlas.findRegion("FrostBlizzard")), "Blizzard");
        FrostAssaultDrones = new Weapon(new Sprite(tankAtlas.findRegion("FrostAssaultDrones")), "AssaultDrones");
        FrostHighPressure = new Weapon(new Sprite(tankAtlas.findRegion("FrostHighPressure")), "HighPressure");
        FrostIceSplitter = new Weapon(new Sprite(tankAtlas.findRegion("FrostIceSplitter")), "IceSplitter");
    }

}

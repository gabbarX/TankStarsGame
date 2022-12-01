package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TankBuratino {
    private int hitPoints;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    private Sprite tankSprite;
    private Weapons BuratinoHoming;
    private Weapons BuratinoMIRV;
    private Weapons BuratinoShredder;
    private Weapons BuratinoAreaStrike;
    private Weapons BuratinnoRapidFire;
    private Weapons BuratinoHounds;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public TankBuratino(boolean isPlayer1, boolean isPlayer2){
        tankAtlas = new TextureAtlas("Tank/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankBuratino"));
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = isPlayer2;
        BuratinoHoming = new Weapons(new Sprite(tankAtlas.findRegion("BuratinoHoming")), "Homing");
        BuratinoMIRV = new Weapons(new Sprite(tankAtlas.findRegion("BuratinoMIRV")), "MIRV");
        BuratinoShredder = new Weapons(new Sprite(tankAtlas.findRegion("BuratinoShredder")), "Shredder");
        BuratinoAreaStrike = new Weapons(new Sprite(tankAtlas.findRegion("BuratinoAreaStrike")), "AreaStrike");
        BuratinnoRapidFire = new Weapons(new Sprite(tankAtlas.findRegion("BuratinnoRapidFire")), "RapidFire");
        BuratinoHounds = new Weapons(new Sprite(tankAtlas.findRegion("BuratinoHounds")), "Hounds");
    }

}

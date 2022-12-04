package com.tankstars.game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
public class TankBuratino {
    private int hitPoints;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    private Sprite tankSprite;
    private com.tankstars.game.Weapons BuratinoHoming;
    private com.tankstars.game.Weapons BuratinoMIRV;
    private com.tankstars.game.Weapons BuratinoShredder;
    private com.tankstars.game.Weapons BuratinoAreaStrike;
    private com.tankstars.game.Weapons BuratinnoRapidFire;
    private com.tankstars.game.Weapons BuratinoHounds;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public TankBuratino(boolean isPlayer1, boolean isPlayer2){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankBuratino"));
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = isPlayer2;
        BuratinoHoming = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("Homing")), "Homing");
        BuratinoMIRV = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("MIRV")), "MIRV");
        BuratinoShredder = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("Shredder")), "Shredder");
        BuratinoAreaStrike = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("AreaStrike")), "AreaStrike");
        BuratinnoRapidFire = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("RapidFire")), "RapidFire");
        BuratinoHounds = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("Hounds")), "Hounds");
    }

}

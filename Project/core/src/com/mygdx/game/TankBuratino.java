package com.tankstars.game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
public class TankBuratino extends com.tankstars.game.Tank {
    private int hitPoints;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    private Sprite tankSprite;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public TankBuratino(boolean isPlayer1, boolean isPlayer2){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankBuratino"));
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = isPlayer2;
        CurrentWeapon = BuratinoHoming;
    }
}

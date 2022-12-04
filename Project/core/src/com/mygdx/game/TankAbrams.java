package com.tankstars.game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TankAbrams {
    private int hitPoints;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    private Sprite tankSprite;
    private com.tankstars.game.Weapons AbramsSplitterChain;
    private com.tankstars.game.Weapons AbramsBigOne;
    private com.tankstars.game.Weapons AbramsAirStrike;
    private com.tankstars.game.Weapons AbramsShotgun;
    private com.tankstars.game.Weapons AbramsVolley;
    private com.tankstars.game.Weapons AbramsMIRV;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public TankAbrams(boolean isPlayer1, boolean isPlayer2){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankAbrams"));
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = isPlayer2;
        AbramsSplitterChain = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("AbramsSplitterChain")), "SplitterChain");
        AbramsBigOne = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("AbramsBigOne")), "BigOne");
        AbramsAirStrike = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("AbramsAirStrike")), "AirStrike");
        AbramsShotgun = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("AbramsShotgun")), "Shotgun");
        AbramsVolley = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("AbramsVolley")), "Volley");
        AbramsMIRV = new com.tankstars.game.Weapons(new Sprite(tankAtlas.findRegion("MIRV")), "MIRV");
    }
}
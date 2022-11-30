package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class TankAbrams {
    private int hitPoints;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    private Sprite tankSprite;
    private Weapons AbramsSplitterChain;
    private Weapons AbramsBigOne;
    private Weapons AbramsAirStrike;
    private Weapons AbramsShotgun;
    private Weapons AbramsVolley;
    private Weapons AbramsMIRV;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public TankAbrams(boolean isPlayer1, boolean isPlayer2){
        tankAtlas = new TextureAtlas("Tank/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankAbrams"));
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = isPlayer2;
        AbramsSplitterChain = new Weapons(new Sprite(tankAtlas.findRegion("AbramsSplitterChain")), "SplitterChain");
        AbramsBigOne = new Weapons(new Sprite(tankAtlas.findRegion("AbramsBigOne")), "BigOne");
        AbramsAirStrike = new Weapons(new Sprite(tankAtlas.findRegion("AbramsAirStrike")), "AirStrike");
        AbramsShotgun = new Weapons(new Sprite(tankAtlas.findRegion("AbramsShotgun")), "Shotgun");
        AbramsVolley = new Weapons(new Sprite(tankAtlas.findRegion("AbramsVolley")), "Volley");
        AbramsMIRV = new Weapons(new Sprite(tankAtlas.findRegion("MIRV")), "MIRV");
    }
}

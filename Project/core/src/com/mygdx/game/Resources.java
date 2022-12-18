package com.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.awt.*;

public class Resources {
    protected SpriteBatch batch;
    protected Sprite sprite;
    public Texture mainScreenBackground;
    public Sprite mainScreenBackgroundSprite;
    public Texture mainMenuBackground;
    public Sprite mainMenuBackgroundSprite;
    private Skin tankSkin;
    private TextureAtlas tankAtlas;
    public Sprite AbramsSprite, BuratinoSprite, FrostSprite;
    public com.badlogic.gdx.scenes.scene2d.ui.Image AbramsSplitterChain,AbramsBigOne,AbramsAirStrike,AbramsShotgun,AbramsVolley,AbramsMIRV;
    public com.badlogic.gdx.scenes.scene2d.ui.Image FrostBlast,FrostBite,FrostBlizzard,FrostAssaultDrones,FrostHighPressure,FrostIceSplitter;
    public com.badlogic.gdx.scenes.scene2d.ui.Image BuratinoHoming, BuratinoMIRV, BuratinoShredder, BuratinoAreaStrike, BuratinnoRapidFire, BuratinoHounds;
    public Resources(){
        batch = new SpriteBatch();
        mainScreenBackground = new Texture("mainMenu/loadingScreen.jpg");
        mainScreenBackgroundSprite = new Sprite(mainScreenBackground);
        mainMenuBackground = new Texture("mainMenu/loadingScreen.jpg");
        mainMenuBackgroundSprite = new Sprite(mainMenuBackground);
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        AbramsSprite = new Sprite(tankAtlas.findRegion("TankAbrams"));
        BuratinoSprite = new Sprite(tankAtlas.findRegion("TankBuratino"));
        FrostSprite = new Sprite(tankAtlas.findRegion("TankFrost"));
        AbramsSplitterChain = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AbramsSplitterChain"));
        AbramsBigOne = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AbramsBigOne"));
        AbramsAirStrike = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AbramsAirStrike"));
        AbramsShotgun = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AbramsShotgun"));
        AbramsVolley = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AbramsVolley"));
        AbramsMIRV = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("MIRV"));
        BuratinoHoming = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("Homing"));
        BuratinoMIRV = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("MIRV"));
        BuratinoShredder = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("Shredder"));
        BuratinoAreaStrike = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AreaStrike"));
        BuratinnoRapidFire = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("RapidFire"));
        BuratinoHounds = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("Hounds"));
        FrostBlast = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("FrostBlast"));
        FrostBite = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("FrostBite"));
        FrostBlizzard = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("Blizzard"));
        FrostAssaultDrones = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("AssaultDrones"));
        FrostHighPressure = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("HighPressure"));
        FrostIceSplitter = new com.badlogic.gdx.scenes.scene2d.ui.Image(tankAtlas.findRegion("IceSplitter"));
    }
    public void dispose(){
        batch.dispose();
        mainScreenBackground.dispose();
    }
}

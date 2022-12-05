package com.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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
    public Sprite AbramsSplitterChain,AbramsBigOne,AbramsAirStrike,AbramsShotgun,AbramsVolley,AbramsMIRV;
    public Sprite FrostBlast,FrostBite,FrostBlizzard,FrostAssaultDrones,FrostHighPressure,FrostIceSplitter;
    public Sprite BuratinoHoming, BuratinoMIRV, BuratinoShredder, BuratinoAreaStrike, BuratinnoRapidFire, BuratinoHounds;
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
        AbramsSplitterChain = new Sprite(tankAtlas.findRegion("AbramsSplitterChain"));
        AbramsBigOne = new Sprite(tankAtlas.findRegion("AbramsBigOne"));
        AbramsAirStrike = new Sprite(tankAtlas.findRegion("AbramsAirStrike"));
        AbramsShotgun = new Sprite(tankAtlas.findRegion("AbramsShotgun"));
        AbramsVolley = new Sprite(tankAtlas.findRegion("AbramsVolley"));
        AbramsMIRV = new Sprite(tankAtlas.findRegion("MIRV"));
        BuratinoHoming = new Sprite(tankAtlas.findRegion("Homing"));
        BuratinoMIRV = new Sprite(tankAtlas.findRegion("MIRV"));
        BuratinoShredder = new Sprite(tankAtlas.findRegion("Shredder"));
        BuratinoAreaStrike = new Sprite(tankAtlas.findRegion("AreaStrike"));
        BuratinnoRapidFire = new Sprite(tankAtlas.findRegion("RapidFire"));
        BuratinoHounds = new Sprite(tankAtlas.findRegion("Hounds"));
        FrostBlast = new Sprite(tankAtlas.findRegion("FrostBlast"));
        FrostBite = new Sprite(tankAtlas.findRegion("FrostBite"));
        FrostBlizzard = new Sprite(tankAtlas.findRegion("Blizzard"));
        FrostAssaultDrones = new Sprite(tankAtlas.findRegion("AssaultDrones"));
        FrostHighPressure = new Sprite(tankAtlas.findRegion("HighPressure"));
        FrostIceSplitter = new Sprite(tankAtlas.findRegion("IceSplitter"));
    }
    public void dispose(){
        batch.dispose();
        mainScreenBackground.dispose();
    }
}

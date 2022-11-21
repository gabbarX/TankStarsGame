package com.tankstars.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sun.java.swing.action.AlignCenterAction;
import com.tankstars.game.TankStars;


import com.badlogic.gdx.Screen;

import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class GameScreen extends DefaultScreen {
    public GameScreen(TankStars game, int player1){
        super(game);
        this.player1 = player1;
        this.player2 = (int) (Math.random() * 3);
    }
    public GameScreen(TankStars game, int player1, int player2) {
        super(game);
        this.player1 = player1;
        this.player2 = player2;
    }
    private Stage stage;
    private Image background, dirtTerrain, healthBarP1, healthbarP2, badgeP1, badgeP2, vslogo;
    private int player1, player2;
    com.badlogic.gdx.scenes.scene2d.ui.Image AbramsSplitterChain, AbramsBigOne, AbramsAirStrike, AbramsShotgun, AbramsVolley, AbramsVerticalSlam;
    com.badlogic.gdx.scenes.scene2d.ui.Image FrostFrostBlast, FrostFrostBite, FrostAssaultDrones, FrostBlizzard, FrostHighPressure, FrostIceSplitter;
    com.badlogic.gdx.scenes.scene2d.ui.Image BuratinoHoming, BuratinoMIRV,BuratinoShredder, BuratinoAreaStrike, BuratinoRapidFire, BuratinoHounds;
    Sprite AbramsTank, FrostTank, BuratinoTank, AbramsTankReverse, FrostTankReverse, BuratinoTankReverse;
    Sprite player1Tank, player2Tank;
    ArrayList<Sprite> Tanks = new ArrayList<Sprite>();
    ArrayList<Sprite> TanksReverse = new ArrayList<Sprite>();
    ArrayList<Image> AbramsWeapons = new ArrayList<Image>();
    ArrayList<Image> FrostWeapons = new ArrayList<Image>();
    ArrayList<Image> BuratinoWeapons = new ArrayList<Image>();
    private TextureAtlas atlas;
    private TextureAtlas tankAtlas;
    private Skin TankSkin;
    @Override
    public void show() {
        batch.begin();
        stage = new Stage();
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        TankSkin = new Skin(tankAtlas);
        background = new Image(new Texture(Gdx.files.internal("Game Screen/main_game_bg.png")));
        dirtTerrain = new Image(new Texture(Gdx.files.internal("Game Screen/dirt_terrain.png")));
        dirtTerrain.setHeight(Gdx.graphics.getHeight()/4);
        dirtTerrain.setWidth(Gdx.graphics.getWidth());
        dirtTerrain.setPosition(0,0);
//         Tank A details
//         Take Tank A from the atlas as a sprite
        AbramsTank = new Sprite(tankAtlas.findRegion("TankAbrams"));
        AbramsTankReverse = new Sprite(tankAtlas.findRegion("TankAbramsReverse"));
        Tanks.add(AbramsTank);
        TanksReverse.add(AbramsTankReverse);
        AbramsTank.setSize(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/4);
        AbramsTank.setPosition(Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/4);
        AbramsVerticalSlam = new Image(TankSkin, "MIRV");
        AbramsSplitterChain = new Image(TankSkin, "AbramsSplitterChain");
        AbramsBigOne = new Image(TankSkin, "AbramsBigOne");
        AbramsAirStrike = new Image(TankSkin, "AbramsAirStrike");
        AbramsShotgun = new Image(TankSkin, "AbramsShotgun");
        AbramsVolley = new Image(TankSkin, "AbramsVolley");
        AbramsWeapons.add(AbramsVerticalSlam);
        AbramsWeapons.add(AbramsSplitterChain);
        AbramsWeapons.add(AbramsBigOne);
        AbramsWeapons.add(AbramsAirStrike);
        AbramsWeapons.add(AbramsShotgun);
        AbramsWeapons.add(AbramsVolley);
//        Tank B details
        FrostTank = new Sprite(tankAtlas.findRegion("TankFrost"));
        FrostTankReverse = new Sprite(tankAtlas.findRegion("TankFrostReverse"));
        Tanks.add(FrostTank);
        TanksReverse.add(FrostTankReverse);
        FrostFrostBlast = new Image(TankSkin, "FrostBlast");
        FrostFrostBite = new Image(TankSkin, "FrostBite");
        FrostAssaultDrones = new Image(TankSkin, "AssaultDrones");
        FrostBlizzard = new Image(TankSkin, "Blizzard");
        FrostHighPressure = new Image(TankSkin, "HighPressure");
        FrostIceSplitter = new Image(TankSkin, "IceSplitter");
        FrostWeapons.add(FrostFrostBlast);
        FrostWeapons.add(FrostFrostBite);
        FrostWeapons.add(FrostAssaultDrones);
        FrostWeapons.add(FrostBlizzard);
        FrostWeapons.add(FrostHighPressure);
        FrostWeapons.add(FrostIceSplitter);
//        Tank C details
        BuratinoTank = new Sprite(tankAtlas.findRegion("TankBuratino"));
        BuratinoTankReverse = new Sprite(tankAtlas.findRegion("TankBuratinoReverse"));
        Tanks.add(BuratinoTank);
        TanksReverse.add(BuratinoTankReverse);
        TanksReverse.add(BuratinoTankReverse);
        BuratinoHoming = new Image(TankSkin, "Homing");
        BuratinoMIRV = new Image(TankSkin, "MIRV");
        BuratinoShredder = new Image(TankSkin, "Shredder");
        BuratinoAreaStrike = new Image(TankSkin, "AreaStrike");
        BuratinoRapidFire = new Image(TankSkin, "RapidFire");
        BuratinoHounds = new Image(TankSkin, "Hounds");
        BuratinoWeapons.add(BuratinoHoming);
        BuratinoWeapons.add(BuratinoMIRV);
        BuratinoWeapons.add(BuratinoShredder);
        BuratinoWeapons.add(BuratinoAreaStrike);
        BuratinoWeapons.add(BuratinoRapidFire);
        BuratinoWeapons.add(BuratinoHounds);
        player1Tank = Tanks.get(player1);
        player2Tank = TanksReverse.get(player2);
        player1Tank.setSize(100,60);
        player2Tank.setSize(100,60);
        // rotate the tank image for player2Tank
        player1Tank.setPosition(Gdx.graphics.getWidth()/8, Gdx.graphics.getHeight()/4);
        player2Tank.setPosition(Gdx.graphics.getWidth()/4*3, Gdx.graphics.getHeight()/4);
//         take abrams image from skin
//        TankAbrams = new java.awt.Image(TankSkin, "TankAbrams");
        healthBarP1 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        healthbarP2 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        badgeP1 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        badgeP2 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        vslogo = new Image(new Texture(Gdx.files.internal("Game Screen/vslogo.png")));


        healthBarP1.setPosition(230,600);
        badgeP1.setSize(60,60);
        badgeP1.setPosition(190,600);
        healthbarP2.setPosition(670,600);
        badgeP2.setPosition(930,600);
        badgeP2.setSize(60,60);
        vslogo.setPosition(546,590);
        stage.addActor(background);
        stage.addActor(dirtTerrain);
        stage.addActor(healthBarP1);
        stage.addActor(healthbarP2);
        stage.addActor(badgeP1);
        stage.addActor(badgeP2);
        stage.addActor(vslogo);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        stage.setDebugAll(true);
        stage.act(delta);
        stage.draw();
        batch = new SpriteBatch();
        batch.begin();
        player1Tank.draw(batch);
        player2Tank.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

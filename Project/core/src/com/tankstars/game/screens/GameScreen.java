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
import com.tankstars.game.Player;
import com.tankstars.game.TankStars;


import com.badlogic.gdx.Screen;

import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class GameScreen extends DefaultScreen {
    public GameScreen(TankStars game, int player1){
        super(game);
        this.isPlayer1 = player1;
        this.isPlayer2 = (int) (Math.random() * 3);
    }
    public GameScreen(TankStars game, int player1, int player2) {
        super(game);
        this.isPlayer1 = player1;
        this.isPlayer2 = player2;
    }
    private Stage stage;
    private Image background, dirtTerrain, healthBarP1, healthbarP2, badgeP1, badgeP2, vslogo;
    Player player1, player2;
    int isPlayer1, isPlayer2;
    private TextureAtlas tankAtlas;
    @Override
    public void show() {
        switch(isPlayer1) {
            case 0:
                player1 = new Player("Abrams", true);
                break;
            case 1:
                player1 = new Player("Frost", true);
                break;
            case 2:
                player1 = new Player("Buratino", true);
                break;
        }
        switch(isPlayer2) {
            case 0:
                player2 = new Player("Abrams", false);
                break;
            case 1:
                player2 = new Player("Frost",  false);
                break;
            case 2:
                player2 = new Player("Buratino", false);
                break;
        }
        stage = new Stage();
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        background = new Image(new Texture(Gdx.files.internal("Game Screen/main_game_bg.png")));
        dirtTerrain = new Image(new Texture(Gdx.files.internal("Game Screen/dirt_terrain.png")));
        dirtTerrain.setHeight(Gdx.graphics.getHeight()/4);
        dirtTerrain.setWidth(Gdx.graphics.getWidth());
        dirtTerrain.setPosition(0,0);
        healthBarP1 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        healthbarP2 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        badgeP1 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        badgeP2 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        vslogo = new Image(new Texture(Gdx.files.internal("Game Screen/vslogo.png")));
        player1.tank.tankSprite.setPosition(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/4);
        player2.tank.tankSprite.setPosition(Gdx.graphics.getWidth()*4/5, Gdx.graphics.getHeight()/4);
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
        player1.tank.tankSprite.draw(batch);
        player2.tank.tankSprite.draw(batch);
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

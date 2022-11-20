package com.tankstars.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.sun.java.swing.action.AlignCenterAction;
import com.tankstars.game.TankStars;


import com.badlogic.gdx.Screen;

public class GameScreen extends DefaultScreen {
    public GameScreen(TankStars game) {
        super(game);
    }
    private Stage stage;
    private Image background, dirtTerrain, healthBarP1, healthbarP2, badgeP1, badgeP2, vslogo;
    private TextureAtlas atlas;


    @Override
    public void show() {
        stage = new Stage();
        background = new Image(new Texture(Gdx.files.internal("Game Screen/main_game_bg.png")));
        dirtTerrain = new Image(new Texture(Gdx.files.internal("Game Screen/dirt_terrain.png")));
        dirtTerrain.setHeight(200);
        dirtTerrain.setWidth(2200);
        dirtTerrain.setPosition(0,0);

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

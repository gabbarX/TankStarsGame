package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Select;
import com.tankstars.game.TankStars;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class SelectTankScreen extends DefaultScreen{
    private Stage stage;
    com.badlogic.gdx.scenes.scene2d.ui.Image tankstars, background, tank, tankStarsLogo;
    private TextButton exitButton, settingsButton, vsComputerButton, vsPlayerButton;
    private Label heading, heading1;
    private Skin skin, skin1;
    private BitmapFont white,black;
    private TextureAtlas atlas, atlas1;
    public SelectTankScreen(TankStars game) {
        super(game);
    }
    public void setup(){
        stage = new Stage();
        background = new com.badlogic.gdx.scenes.scene2d.ui.Image(new Texture(Gdx.files.internal("selectTankMenu/background1.jpeg")));

    }
    @Override
    public void show(){

    }
}
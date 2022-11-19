package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Select;
import com.tankstars.game.TankStars;
import org.w3c.dom.Text;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class SelectTankScreen extends DefaultScreen{
    private Stage stage;
    com.badlogic.gdx.scenes.scene2d.ui.Image background, TankAbrams, TankBuratino, TankFrost, TankNameBar, TankAbramsSmall, TankBuratinoSmall, TankFrostSmall;
    private String tankName;
    private ImageButton rightButton, leftButton, backButton;
    private TextButton playButton, TankAbramsButton, TankBuratinoButton, TankFrostButton, chooseTank;
    private Label heading, heading1;
    private Skin skin, skin1;
    private BitmapFont white,black;
    private TextureAtlas atlas, atlas1;
    public SelectTankScreen(TankStars game) {
        super(game);
    }
    @Override
    public void show(){
        stage = new Stage();
        background = new Image(new Texture(Gdx.files.internal("selectTankMenu/background.jpeg")));
        atlas = new TextureAtlas("selectTankMenu/items/items.pack");
        skin = new Skin(atlas);
        Gdx.input.setInputProcessor(stage);
        // take image from atlas
        TankAbrams = new Image(skin, "TankAbrams");
        TankBuratino = new Image(skin, "TankBuratino");
        TankFrost = new Image(skin, "TankFrost");
        TankNameBar = new Image(skin, "TankNameBar");
        TankAbramsSmall = new Image(skin, "TankAbrams");
        TankBuratinoSmall = new Image(skin, "TankBuratino");
        TankFrostSmall = new Image(skin, "TankFrost");
        // set position and size for images
        TankAbrams.setSize(400,240);
        TankAbrams.setPosition(Gdx.graphics.getWidth()*3/20, Gdx.graphics.getHeight()/4);
        TankBuratino.setSize(400,240);
        TankBuratino.setPosition(Gdx.graphics.getWidth()*3/20, Gdx.graphics.getHeight()/4);
        TankFrost.setSize(400,240);
        TankFrost.setPosition(Gdx.graphics.getWidth()*3/20, Gdx.graphics.getHeight()/4);
        TankAbramsSmall.setSize(100,60);
        TankAbramsSmall.setPosition(Gdx.graphics.getWidth()*77/100, Gdx.graphics.getHeight()*53/100);
        TankBuratinoSmall.setSize(100,60);
        TankBuratinoSmall.setPosition(Gdx.graphics.getWidth()*77/100, Gdx.graphics.getHeight()*53/100);
        TankFrostSmall.setSize(100,60);
        TankFrostSmall.setPosition(Gdx.graphics.getWidth()*77/100, Gdx.graphics.getHeight()*53/100);
        TankNameBar.setSize(400,240);
        tankName = "Abrams";
        // setting up fonts
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;
        // setting up info bars
        TextButton.TextButtonStyle textButtonStyle1 = new TextButton.TextButtonStyle();
        textButtonStyle1.up = skin.getDrawable("TankNameBar");
        textButtonStyle1.down = skin.getDrawable("TankNameBar");
        textButtonStyle1.pressedOffsetX = -1;
        textButtonStyle1.pressedOffsetY = 1;
        textButtonStyle1.font = black;
        TextButton.TextButtonStyle textButtonStyle2 = new TextButton.TextButtonStyle();
        textButtonStyle2.up = skin.getDrawable("chooseTank");
        textButtonStyle2.down = skin.getDrawable("chooseTank");
        textButtonStyle2.pressedOffsetX = -1;
        textButtonStyle2.pressedOffsetY = 1;
        textButtonStyle2.font = white;
        textButtonStyle2.font.getData().setScale(0.75f);
        // making info buttons of the tanks
        TankAbramsButton = new TextButton("Abrams", textButtonStyle1);
        TankAbramsButton.setPosition(Gdx.graphics.getWidth()*3/20, Gdx.graphics.getHeight()*3/4);
        TankAbramsButton.setSize(300,80);
        TankBuratinoButton = new TextButton("Buratino", textButtonStyle1);
        TankBuratinoButton.setPosition(Gdx.graphics.getWidth()*3/20, Gdx.graphics.getHeight()*3/4);
        TankBuratinoButton.setSize(300,80);
        TankFrostButton = new TextButton("Frost", textButtonStyle1);
        TankFrostButton.setPosition(Gdx.graphics.getWidth()*3/20, Gdx.graphics.getHeight()*3/4);
        TankFrostButton.setSize(300,80);
        chooseTank = new TextButton("Choose tank", textButtonStyle2);
        chooseTank.setPosition(Gdx.graphics.getWidth()*75/100, Gdx.graphics.getHeight()*3/4);
        chooseTank.setSize(150,40);
        // make a button play
        playButton = new TextButton("PLAY", textButtonStyle);
        playButton.setPosition(Gdx.graphics.getWidth()*7/10, Gdx.graphics.getHeight()/4);
        playButton.pad(20);
        // making left and right buttons
        leftButton = new ImageButton(skin.getDrawable("arrow_left"));
        leftButton.setSize(100,100);
        leftButton.setPosition(Gdx.graphics.getWidth()*65/100, Gdx.graphics.getHeight()/2);
        rightButton = new ImageButton(skin.getDrawable("arrow_right"));
        rightButton.setSize(100,100);
        rightButton.setPosition(Gdx.graphics.getWidth()*88/100, Gdx.graphics.getHeight()/2);

        // make a button back
        backButton = new ImageButton(skin.getDrawable("cross"));
        backButton.setSize(100,100);
        backButton.setPosition(Gdx.graphics.getWidth()*1/100, Gdx.graphics.getHeight()*85/100);
        // setting up stage
        stage.addActor(background);
        stage.addActor(TankAbrams);
        stage.addActor(TankAbramsSmall);
        stage.addActor(playButton);
        stage.addActor(leftButton);
        stage.addActor(rightButton);
        stage.addActor(backButton);
        stage.addActor(TankAbramsButton);
        stage.addActor(chooseTank);
        // left button clicked
        leftButton.addListener(new ClickListener(){
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                stage.clear();
                stage.addActor(background);
                stage.addActor(leftButton);
                stage.addActor(rightButton);
                stage.addActor(playButton);
                stage.addActor(backButton);
                stage.addActor(chooseTank);
                if (tankName.equals("Abrams")) {
                    stage.addActor(TankBuratino);
                    stage.addActor(TankBuratinoSmall);
                    stage.addActor(TankBuratinoButton);
                    tankName = "Buratino";
                }
                else if (tankName.equals("Buratino")) {
                    stage.addActor(TankFrost);
                    stage.addActor(TankFrostSmall);
                    stage.addActor(TankFrostButton);
                    tankName = "Frost";
                }
                else {
                    stage.addActor(TankAbrams);
                    stage.addActor(TankAbramsSmall);
                    stage.addActor(TankAbramsButton);
                    tankName = "Abrams";
                }
            }
        });
        // right button clicked
        rightButton.addListener(new ClickListener(){
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                stage.clear();
                stage.addActor(background);
                stage.addActor(leftButton);
                stage.addActor(rightButton);
                stage.addActor(playButton);
                stage.addActor(backButton);
                stage.addActor(chooseTank);
                if (tankName.equals("Abrams")) {
                    stage.addActor(TankFrost);
                    stage.addActor(TankFrostSmall);
                    stage.addActor(TankFrostButton);
                    tankName = "Frost";
                }
                else if (tankName.equals("Buratino")) {
                    stage.addActor(TankAbrams);
                    stage.addActor(TankAbramsSmall);
                    stage.addActor(TankAbramsButton);
                    tankName = "Abrams";
                }
                else {
                    stage.addActor(TankBuratino);
                    stage.addActor(TankBuratinoSmall);
                    stage.addActor(TankBuratinoButton);
                    tankName = "Buratino";
                }
            }
        });
        // back button clicked
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new MainScreen(game));
            }
        });
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        // showing the debug lines
//        stage.setDebugAll(true);
    }
    @Override
    public void dispose(){
        stage.dispose();
        skin.dispose();
        atlas.dispose();
        white.dispose();
        black.dispose();
    }
}
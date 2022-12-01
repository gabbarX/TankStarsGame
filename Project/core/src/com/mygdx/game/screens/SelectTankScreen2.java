package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.tankstars.game.TankStars;

public class SelectTankScreen2 extends SelectTankScreen {
    private Stage stage;
    com.badlogic.gdx.scenes.scene2d.ui.Image background, TankAbrams, TankBuratino, TankFrost, TankNameBar, TankAbramsSmall, TankBuratinoSmall, TankFrostSmall, player1, player2;
    private String tankName, player1Tank, player2Tank;
    private ImageButton rightButton, leftButton, backButton;
    private TextButton playButton, TankAbramsButton, TankBuratinoButton, TankFrostButton, chooseTank;
    private boolean isPlayer1, isPlayer2;
    private Label heading, heading1;
    private Skin skin, skin1;
    private BitmapFont white,black;
    private TextureAtlas atlas, atlas1;
    public SelectTankScreen2(TankStars game) {
        super(game);
    }
    @Override
    public void show() {
        stage = new Stage();
        background = new Image(new Texture(Gdx.files.internal("selectTankMenu/background.jpeg")));
        atlas = new TextureAtlas("selectTankMenu2/items/items.pack");
        skin = new Skin(atlas);
        Gdx.input.setInputProcessor(stage);
        // take image from atlas
        // take image from atlas
        TankAbrams = new Image(skin, "TankAbrams");
        TankBuratino = new Image(skin, "TankBuratino");
        TankFrost = new Image(skin, "TankFrost");
        TankNameBar = new Image(skin, "TankNameBar");
        TankAbramsSmall = new Image(skin, "TankAbrams");
        TankBuratinoSmall = new Image(skin, "TankBuratino");
        TankFrostSmall = new Image(skin, "TankFrost");
        player1 = new Image(skin, "Player1Chosen");
        player2 = new Image(skin, "Player2Chosen");
        // set position and size for images
        TankAbrams.setSize(400, 240);
        TankAbrams.setPosition(Gdx.graphics.getWidth() * 3 / 20, Gdx.graphics.getHeight() / 4);
        TankBuratino.setSize(400, 240);
        TankBuratino.setPosition(Gdx.graphics.getWidth() * 3 / 20, Gdx.graphics.getHeight() / 4);
        TankFrost.setSize(400, 240);
        TankFrost.setPosition(Gdx.graphics.getWidth() * 3 / 20, Gdx.graphics.getHeight() / 4);
        TankAbramsSmall.setSize(100, 60);
        TankAbramsSmall.setPosition(Gdx.graphics.getWidth() * 77 / 100, Gdx.graphics.getHeight() * 53 / 100);
        TankBuratinoSmall.setSize(100, 60);
        TankBuratinoSmall.setPosition(Gdx.graphics.getWidth() * 77 / 100, Gdx.graphics.getHeight() * 53 / 100);
        TankFrostSmall.setSize(100, 60);
        TankFrostSmall.setPosition(Gdx.graphics.getWidth() * 77 / 100, Gdx.graphics.getHeight() * 53 / 100);
        TankNameBar.setSize(400, 240);
        player1.setPosition(Gdx.graphics.getWidth() * 151 / 200, Gdx.graphics.getHeight() * 49 / 100);
        player2.setPosition(Gdx.graphics.getWidth() * 147 / 200, Gdx.graphics.getHeight() * 93 / 200);
        player1.setSize(160, 125);
        player2.setSize(162, 127);
        tankName = "Abrams";
        // setting up fonts and buttons
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
        TankAbramsButton.setPosition(Gdx.graphics.getWidth() * 3 / 20, Gdx.graphics.getHeight() * 3 / 4);
        TankAbramsButton.setSize(300, 80);
        TankBuratinoButton = new TextButton("Buratino", textButtonStyle1);
        TankBuratinoButton.setPosition(Gdx.graphics.getWidth() * 3 / 20, Gdx.graphics.getHeight() * 3 / 4);
        TankBuratinoButton.setSize(300, 80);
        TankFrostButton = new TextButton("Frost", textButtonStyle1);
        TankFrostButton.setPosition(Gdx.graphics.getWidth() * 3 / 20, Gdx.graphics.getHeight() * 3 / 4);
        TankFrostButton.setSize(300, 80);
        chooseTank = new TextButton("Choose tank", textButtonStyle2);
        chooseTank.setPosition(Gdx.graphics.getWidth() * 75 / 100, Gdx.graphics.getHeight() * 3 / 4);
        chooseTank.setSize(150, 40);
        // make a button play
        playButton = new TextButton("PLAY", textButtonStyle);
        playButton.setPosition(Gdx.graphics.getWidth() * 7 / 10, Gdx.graphics.getHeight() / 4);
        playButton.pad(20);
        // make a choose tank button
        chooseTank = new TextButton("CHOOSE", textButtonStyle);
        chooseTank.setPosition(Gdx.graphics.getWidth() * 7 / 10, Gdx.graphics.getHeight() / 4);
        chooseTank.pad(20);
        // making left and right buttons
        leftButton = new ImageButton(skin.getDrawable("arrow_left"));
        leftButton.setSize(100, 100);
        leftButton.setPosition(Gdx.graphics.getWidth() * 65 / 100, Gdx.graphics.getHeight() / 2);
        rightButton = new ImageButton(skin.getDrawable("arrow_right"));
        rightButton.setSize(100, 100);
        rightButton.setPosition(Gdx.graphics.getWidth() * 88 / 100, Gdx.graphics.getHeight() / 2);
        isPlayer1 = false;
        isPlayer2 = false;
        // make a button back
        backButton = new ImageButton(skin.getDrawable("cross"));
        backButton.setSize(100, 100);
        backButton.setPosition(Gdx.graphics.getWidth() * 1 / 100, Gdx.graphics.getHeight() * 85 / 100);
        // setting up stage
        stage.addActor(background);
        stage.addActor(chooseTank);
        stage.addActor(player1);
        stage.addActor(TankAbrams);
        stage.addActor(TankAbramsSmall);
        stage.addActor(chooseTank);
        stage.addActor(leftButton);
        stage.addActor(rightButton);
        stage.addActor(backButton);
        stage.addActor(TankAbramsButton);
        stage.addActor(chooseTank);
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainScreen(game));
            }
        });
        chooseTank.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.clear();
                stage.addActor(background);
                stage.addActor(chooseTank);
                stage.addActor(playButton);
                stage.addActor(leftButton);
                stage.addActor(rightButton);
                stage.addActor(backButton);
                stage.addActor(player1);
                stage.addActor(player2);
                switch (tankName) {
                    case "Abrams":
                        player1Tank = "Abrams";
                        isPlayer1 = true;
                        stage.addActor(TankAbrams);
                        stage.addActor(TankAbramsSmall);
                        stage.addActor(TankAbramsButton);
                        break;
                    case "Buratino":
                        player1Tank = "Buratino";
                        isPlayer1 = true;
                        stage.addActor(TankBuratino);
                        stage.addActor(TankBuratinoSmall);
                        stage.addActor(TankBuratinoButton);
                        break;
                    case "Frost":
                        player1Tank = "Frost";
                        isPlayer1 = true;
                        stage.addActor(TankFrost);
                        stage.addActor(TankFrostSmall);
                        stage.addActor(TankFrostButton);
                        break;
                    default:
                        isPlayer1 = false;
                        break;
                }
            }
        });
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                int tank1 = 0;
                int tank2 = 0;
                switch(player1Tank) {
                    case "Abrams":
                        tank1 = 0;
                        break;
                    case "Buratino":
                        tank1 = 2;
                        break;
                    case "Frost":
                        tank1 = 1;
                        break;
                }
                switch (tankName) {
                    case "Abrams":
                        player2Tank = "Abrams";
                        tank2 = 0;
                        isPlayer2 = true;
                        break;
                    case "Buratino":
                        player2Tank = "Buratino";
                        tank2 = 2;
                        isPlayer2 = true;
                        break;
                    case "Frost":
                        tank2 = 1;
                        player2Tank = "Frost";
                        isPlayer2 = true;
                        break;
                    default:
                        isPlayer2 = false;
                        break;
                }
                game.setScreen(new GameScreen(game, tank1, tank2));
            }
        });
        leftButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                if (!isPlayer1) {
                    stage.clear();
                    stage.addActor(background);
                    stage.addActor(chooseTank);
                    stage.addActor(chooseTank);
                    stage.addActor(leftButton);
                    stage.addActor(rightButton);
                    stage.addActor(backButton);
                    stage.addActor(player1);
                    if (tankName.equals("Abrams")) {
                        tankName = "Buratino";
                        stage.addActor(TankBuratino);
                        stage.addActor(TankBuratinoSmall);
                        stage.addActor(TankBuratinoButton);
                    } else if (tankName.equals("Buratino")) {
                        tankName = "Frost";
                        stage.addActor(TankFrost);
                        stage.addActor(TankFrostSmall);
                        stage.addActor(TankFrostButton);
                    } else {
                        tankName = "Abrams";
                        stage.addActor(TankAbrams);
                        stage.addActor(TankAbramsSmall);
                        stage.addActor(TankAbramsButton);
                    }
                } else {
                    stage.clear();
                    stage.addActor(background);
                    stage.addActor(chooseTank);
                    stage.addActor(playButton);
                    stage.addActor(leftButton);
                    stage.addActor(rightButton);
                    stage.addActor(backButton);
                    switch (tankName) {
                        case "Buratino":
                            tankName = "Frost";
                            if (player1Tank.equals("Frost")) {
                                stage.addActor(player1);
                            }
                            stage.addActor(player2);
                            stage.addActor(TankFrost);
                            stage.addActor(TankFrostSmall);
                            stage.addActor(TankFrostButton);
                            break;
                        case "Frost":
                            tankName = "Abrams";
                            if (player1Tank.equals("Abrams")) {
                                stage.addActor(player1);
                            }
                            stage.addActor(player2);
                            stage.addActor(TankAbrams);
                            stage.addActor(TankAbramsSmall);
                            stage.addActor(TankAbramsButton);
                            break;
                        case "Abrams":
                            tankName = "Buratino";
                            if (player1Tank.equals("Buratino")) {
                                stage.addActor(player1);
                            }
                            stage.addActor(player2);
                            stage.addActor(TankBuratino);
                            stage.addActor(TankBuratinoSmall);
                            stage.addActor(TankBuratinoButton);
                            break;
                    }
                }
            }
        });
        rightButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                if (!isPlayer1) {
                    stage.clear();
                    stage.addActor(background);
                    stage.addActor(chooseTank);
                    stage.addActor(chooseTank);
                    stage.addActor(leftButton);
                    stage.addActor(rightButton);
                    stage.addActor(backButton);
                    stage.addActor(player1);
                    switch (tankName) {
                        case "Abrams":
                            tankName = "Frost";
                            stage.addActor(TankFrost);
                            stage.addActor(TankFrostSmall);
                            stage.addActor(TankFrostButton);
                            break;
                        case "Frost":
                            tankName = "Buratino";
                            stage.addActor(TankBuratino);
                            stage.addActor(TankBuratinoSmall);
                            stage.addActor(TankBuratinoButton);
                            break;
                        default:
                            tankName = "Abrams";
                            stage.addActor(TankAbrams);
                            stage.addActor(TankAbramsSmall);
                            stage.addActor(TankAbramsButton);
                            break;
                    }
                } else {
                    stage.clear();
                    stage.addActor(background);
                    stage.addActor(chooseTank);
                    stage.addActor(playButton);
                    stage.addActor(leftButton);
                    stage.addActor(rightButton);
                    stage.addActor(backButton);
                    switch (tankName) {
                        case "Abrams":
                            tankName = "Frost";
                            if (player1Tank.equals("Frost")) {
                                stage.addActor(player1);
                            }
                            stage.addActor(player2);
                            stage.addActor(TankFrost);
                            stage.addActor(TankFrostSmall);
                            stage.addActor(TankFrostButton);
                            break;
                        case "Frost":
                            tankName = "Buratino";
                            if (player1Tank.equals("Buratino")) {
                                stage.addActor(player1);
                            }
                            stage.addActor(player2);
                            stage.addActor(TankBuratino);
                            stage.addActor(TankBuratinoSmall);
                            stage.addActor(TankBuratinoButton);
                            break;
                        case "Buratino":
                            tankName = "Abrams";
                            if (player1Tank.equals("Abrams")) {
                                stage.addActor(player1);
                            }
                            stage.addActor(player2);
                            stage.addActor(TankAbrams);
                            stage.addActor(TankAbramsSmall);
                            stage.addActor(TankAbramsButton);
                            break;
                    }
                }
            }
        });
    }
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

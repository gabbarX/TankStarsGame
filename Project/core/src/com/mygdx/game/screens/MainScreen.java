package com.tankstars.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.tankstars.game.TankStars;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MainScreen extends com.tankstars.game.screens.DefaultScreen {
    private Stage stage;
    String loadGameName;
    Image tankstars, background, tank, tankStarsLogo, popUp;
    private TextButton exitButton, settingsButton, vsComputerButton, vsPlayerButton, loadGameButton, yesButton, noButton, loadButton, cancelButton;
    private Label heading, heading1;
    private Skin skin, skin1;
    private BitmapFont white,black;
    private TextureAtlas atlas, atlas1;
    private Table table, table1, exitTable, loadGameTable;
    private TextButton.TextButtonStyle textButtonStyle;
    private Texture myTexture;
    private ImageButton pauseButton;
    public com.tankstars.game.Resources resources;
    public void loadGame(String loadGameName) throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader("assets/savedGames/" + loadGameName);
            if (fileReader != null) {
                game.setScreen(new com.tankstars.game.screens.GameScreen(game, loadGameName));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public MainScreen(TankStars game) {
        super(game);
        resources = new com.tankstars.game.Resources();
    }
    @Override
    public void show(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        background = new Image(new Texture(Gdx.files.internal("mainMenu/background.jpeg")));
        tankstars = new Image(new Texture(Gdx.files.internal("mainMenu/tankstars.png")));
        popUp = new Image(new Texture(Gdx.files.internal("mainMenu/popUpBackground.jpg")));
        popUp.setPosition(287.5f, 200);
        popUp.setSize(500, 225);
        atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        atlas1 = new TextureAtlas("mainMenu/items/items.pack");
        skin = new Skin(atlas);
        skin1 = new Skin(atlas1);
        table = new Table(skin);
        table1 = new Table(skin1);
        exitTable = new Table(skin);
        //Image button
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        // making buttons for main menu screen
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;
        yesButton = new TextButton("YES", textButtonStyle);
        yesButton.setTransform(true);
        yesButton.setScale(0.6f);
        yesButton.pad(10);
        noButton = new TextButton("NO", textButtonStyle);
        noButton.setTransform(true);
        noButton.setScale(0.6f);
        noButton.pad(10);
        loadButton = new TextButton("LOAD", textButtonStyle);
        loadButton.setTransform(true);
        loadButton.setScale(0.6f);
        loadButton.pad(10);
        cancelButton = new TextButton("CANCEL", textButtonStyle);
        cancelButton.setTransform(true);
        cancelButton.setScale(0.6f);
        cancelButton.pad(10);
        exitTable.add(yesButton);
        exitTable.add(noButton);
        exitTable.setPosition(600, 300);
        stage.addActor(background);
        table.center().right();
        // create sprites from atlas
        tankStarsLogo = new Image(skin1, "tankstars");
        tank = new Image(skin1, "TankA");
        // keep table1 at the top of the screen in the middle
        table.setPosition(Gdx.graphics.getWidth()*14/15, Gdx.graphics.getHeight()/2);
        table1.setPosition(Gdx.graphics.getWidth()/3,Gdx.graphics.getHeight()*11/20);
        // adding objects in table1

        table1.add(tankStarsLogo).size(350, 175).pad(15).align(1);
        table1.row();
        table1.add(tank).size(450, 250).pad(20).align(1);
        table1.row();
        stage.addActor(table1);
        vsComputerButton = new TextButton("vs COMPUTER",textButtonStyle);
        vsComputerButton.pad(20);
        vsPlayerButton = new TextButton("vs PLAYER",textButtonStyle);
        vsPlayerButton.pad(20);
        loadGameButton = new TextButton("Load Game",textButtonStyle);
        loadGameButton.pad(20);
        settingsButton = new TextButton("SETTINGS",textButtonStyle);
        settingsButton.pad(20);
        exitButton = new TextButton("Exit", textButtonStyle);
        exitButton.pad(20);
        settingsButton = new TextButton("Settings", textButtonStyle);
        settingsButton.pad(20);
        vsComputerButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen((Screen) new com.tankstars.game.screens.SelectTankScreen(game));
            }
        });
        vsPlayerButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen((Screen) new com.tankstars.game.screens.SelectTankScreen2(game));
            }
        });
        loadGameTable = new Table();
        Label loadGameLabel = new Label("Enter the name of game:", new Label.LabelStyle(white, Color.WHITE));
        Skin defaultSkin = new Skin(Gdx.files.internal("data/uiskin.json"));
        TextField loadGameTextField = new TextField("", defaultSkin);
        // store the input in a variable
        loadGameTextField.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char c) {
                loadGameName = textField.getText();
            }
        });

        loadGameTable.add(loadGameLabel).center();
        loadGameTable.row();
        loadGameTable.add(loadGameTextField).center();
        loadGameTable.row();
        loadGameTable.add(loadButton).center();
        loadGameTable.add(cancelButton).center();
        loadGameTable.row();
        loadGameTable.setPosition(600,310);
        loadGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                stage.addActor(popUp);
                stage.addActor(loadGameTable);
            }
        });
        cancelButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // remove the loadGameTable and popup from screen
                loadGameTable.remove();
                popUp.remove();
            }
        });
        settingsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
//           //settings Button functionality
            }
        });
        exitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                stage.addActor(popUp);
                stage.addActor(exitTable);
//                black.draw(stage.getBatch(), "Are you sure you want to exit?", 400, 400);
            }
        });
        yesButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
        noButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                exitTable.remove();
                popUp.remove();
            }
        });
        loadButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                try {
                    game.setScreen((Screen) new com.tankstars.game.screens.GameScreen(game, loadGameName));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        table.add(tankstars);
        table.row();
        table.add(vsComputerButton);
        table.row();
        table.add(vsPlayerButton);
        table.row();
        table.add(loadGameButton);
        table.row();
        table.add(settingsButton);
        table.row();
        table.add(exitButton);
        table.row();
//        table.debug();
        stage.addActor(table);
//        stage.addActor(pauseButton);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        line that brings debug lines on table
        stage.setDebugAll(true);
        stage.act(delta);
        stage.draw();
        batch.end();
    }
    public void dispose(){
        batch.dispose();

    }
}
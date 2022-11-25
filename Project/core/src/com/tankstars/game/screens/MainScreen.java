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
import com.tankstars.game.TankStars;

public class MainScreen extends DefaultScreen{
    private Stage stage;
    Image tankstars, background, tank, tankStarsLogo;
    private TextButton exitButton, settingsButton, vsComputerButton, vsPlayerButton, loadGameButton;
    private Label heading, heading1;
    private Skin skin, skin1;
    private BitmapFont white,black;
    private TextureAtlas atlas, atlas1;
    private Table table, table1;
    private TextButton.TextButtonStyle textButtonStyle;
    public MainScreen(TankStars game) {
        super(game);
    }
    @Override
    public void show(){
        stage = new Stage();
        background = new Image(new Texture(Gdx.files.internal("mainMenu/background.jpeg")));
        tankstars = new Image(new Texture(Gdx.files.internal("mainMenu/tankstars.png")));
        atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        atlas1 = new TextureAtlas("mainMenu/items/items.pack");
        skin = new Skin(atlas);
        skin1 = new Skin(atlas1);
        table = new Table(skin);
        table1 = new Table(skin1);
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        // making buttons for main menu screen
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;
        stage.addActor(background);
        Gdx.input.setInputProcessor(stage);
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
                game.setScreen(new SelectTankScreen(game));
            }
        });
        vsPlayerButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SelectTankScreen2(game));
            }
        });
        loadGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //loadGameScreen
//                System.out.println("Loading game...");
                game.setScreen(new LoadGame(game));
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
                Gdx.app.exit();
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
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        line that brings debug lines on table
        stage.setDebugAll(true);
        stage.act(delta);
        stage.draw();
    }
    public void dispose(){
        batch.dispose();

    }
}
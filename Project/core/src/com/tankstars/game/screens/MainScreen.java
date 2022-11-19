package com.tankstars.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.tankstars.game.TankStars;

public class MainScreen extends DefaultScreen{
    private Stage stage;
    private Table table;
    private TextButton playButton, exitButton, settingsButton;
    private Label heading;
    private Skin skin;
    private BitmapFont white,black;
    private TextureAtlas atlas;
    public MainScreen(TankStars game) {
        super(game);
    }
    @Override
    public void show(){
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        skin = new Skin(atlas);
        table = new Table(skin);
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;

        playButton = new TextButton("PLAY KR VAI",textButtonStyle);
        playButton.pad(20);

        exitButton = new TextButton("Exit", textButtonStyle);
        exitButton.pad(20);

        settingsButton = new TextButton("Settings", textButtonStyle);
        settingsButton.pad(10);

        table.add(playButton);
        table.add(exitButton);
        table.add(settingsButton);
        table.debug();
        stage.addActor(table);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.setDebugAll(true);
        stage.act(delta);
        stage.draw();
//        batch.begin();
//        game.resources.mainMenuBackgroundSprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//        game.resources.mainMenuBackgroundSprite.draw(batch);
//        batch.end();
    }
    public void dispose(){
        batch.dispose();

    }
}
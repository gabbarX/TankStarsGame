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
    private TextButton playButton, exitButton;
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
        atlas = new TextureAtlas("playbutton");
        skin = new Skin(atlas);
        table = new Table(skin);
        table.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("playbutton.png");
        textButtonStyle.down = skin.getDrawable("playbutton.png");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;

        exitButton = new TextButton("EXIT",textButtonStyle);
        exitButton.pad(20);

        table.add(exitButton);
        table.debug();
        stage.addActor(table);
    }
    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        game.resources.mainScreenBackgroundSprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.resources.mainScreenBackgroundSprite.draw(batch);
        batch.end();
    }
    public void dispose(){
        batch.dispose();

    }
}
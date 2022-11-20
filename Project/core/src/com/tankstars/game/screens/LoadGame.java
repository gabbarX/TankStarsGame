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

public class LoadGame extends DefaultScreen
{
    private Stage stage;
    private Image background;
    private Table table;
    private ImageButton backButton;
    private TextButton savegame, savegame1, savegame2, savegame3;
    private TextureAtlas savedGameAtlas;
    private BitmapFont white,black;
    private Skin savedGameskin,skin;
    private TextButton.TextButtonStyle savedGamesStyle, textButtonStyle;
    public LoadGame(TankStars game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage();
        background = new Image(new Texture(Gdx.files.internal("loadGame/bg.png")));
        stage.addActor(background);
        savedGameAtlas = new TextureAtlas("loadGame/pack/savedGames/savedgames.atlas");
        savedGameskin = new Skin(savedGameAtlas);
        table = new Table(savedGameskin);
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);

        skin = new Skin(new TextureAtlas("mainMenu/pack/button.atlas"));
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;

        TextButton.TextButtonStyle savedGamesStyle = new TextButton.TextButtonStyle();
        savedGamesStyle.up = savedGameskin.getDrawable("SavedGames");
        savedGamesStyle.down = savedGameskin.getDrawable("SavedGames");
        savedGamesStyle.pressedOffsetX = 1;
        savedGamesStyle.pressedOffsetY = -1;
        savedGamesStyle.font = black;
        Gdx.input.setInputProcessor(stage);
//        table.center();
//        table.align(0).center();
//        table.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        table.setPosition(Gdx.graphics.getWidth()*8/15 - 50, Gdx.graphics.getHeight() - 100, Align.center);
        savegame = new TextButton("Saved Games",savedGamesStyle);
        table.add(savegame).size(300,70);
        table.row();
        table.center();
        savegame1 = new TextButton("20-11-2022 Ankit vs Prakar", textButtonStyle);
        table.add(savegame1).size(500,70);
        table.row();
        savegame2 = new TextButton("20-11-2022 Kalicharan vs Kirmada", textButtonStyle);
        table.add(savegame1).size(500,70);
        table.row();
        savegame3 = new TextButton("20-11-2022 Raju vs Rancho", textButtonStyle);
        table.add(savegame1).size(500,70);
        table.row();
        savegame1 = new TextButton("20-11-2022 Naruto vs Sasuke", textButtonStyle);
        table.add(savegame1).size(500,70);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.setDebugAll(true);
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

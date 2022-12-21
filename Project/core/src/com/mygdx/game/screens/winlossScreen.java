package com.mygdx.game.screens;

//import com.badlogic.gdx.screens.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.tankstars.game.TankStars;

public class winlossScreen extends com.tankstars.game.screens.DefaultScreen
{

    private Stage stage;
    com.tankstars.game.Tank winner;
    String winnerName;
    Image background;
    public winlossScreen(TankStars game, com.tankstars.game.Tank winner, String name)
    {
        super(game);
        this.winner = winner;
        this.winnerName = name;
    }

    @Override
    public void show()
    {
        stage = new Stage();
//        background = new com.badlogic.gdx.scenes.scene2d.ui.Image(new Texture(Gdx.files.internal("Game Screen/main_game_bg.png")));
        background = new Image(new Texture(Gdx.files.internal("Game Screen/gameScreenBackground.jpg")));

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        game.resources.mainScreenBackgroundSprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//        game.resources.mainScreenBackgroundSprite.draw(batch);
        // if one click is done, switch to MainScreen
        if (Gdx.input.justTouched()) {
            game.setScreen(new com.tankstars.game.screens.MainScreen(game));
        }
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
    public void dispose()
    {
        batch.dispose();
    }
}

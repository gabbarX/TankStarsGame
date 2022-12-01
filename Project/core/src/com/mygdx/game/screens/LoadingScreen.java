package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.tankstars.game.TankStars;

public class LoadingScreen extends DefaultScreen {
    public LoadingScreen(TankStars game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        game.resources.mainScreenBackgroundSprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.resources.mainScreenBackgroundSprite.draw(batch);
        // if one click is done, switch to MainScreen
        if (Gdx.input.justTouched()) {
            game.setScreen(new MainScreen(game));
        }
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }
}

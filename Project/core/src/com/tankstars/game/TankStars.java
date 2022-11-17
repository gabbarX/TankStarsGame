package com.tankstars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankstars.game.screens.MainScreen;
import com.tankstars.game.screens.splash;

public class TankStars extends Game {
	public Resources resources;
	private SpriteBatch batch;
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new splash());
		resources = new Resources();
		setScreen(new MainScreen(this));
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width,height);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose () {
		super.dispose();
	}


}

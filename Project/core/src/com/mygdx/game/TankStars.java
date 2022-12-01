package com.tankstars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankstars.game.screens.LoadingScreen;
import com.tankstars.game.screens.Settings;

public class TankStars extends Game {
	public Resources resources;
	private SpriteBatch batch;
	Settings settings;
	@Override
	public void create () {
		settings = new Settings(this);
		batch = new SpriteBatch();
		setScreen(new LoadingScreen(this));
		resources = new Resources();
		setScreen(new LoadingScreen(this));
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

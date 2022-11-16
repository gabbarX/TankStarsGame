package com.tankstars.game;

import com.badlogic.gdx.Game;
import com.tankstars.game.screens.MainScreen;

public class TankStars extends Game {
	public Resources resources;
	@Override
	public void create () {
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

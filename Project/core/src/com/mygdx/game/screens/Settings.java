package com.tankstars.game.screens;
import com.badlogic.gdx.Screen;
import com.tankstars.game.TankStars;

public class Settings extends DefaultScreen
{
    private boolean musicOn;
    private boolean ingameSounds;

    public Settings(TankStars game) {
        super(game);
        musicOn = true;
        ingameSounds = true;
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public void setMusicOn(boolean musicOn) {
        this.musicOn = musicOn;
    }

    public boolean isIngameSounds() {
        return ingameSounds;
    }

    public void setIngameSounds(boolean ingameSounds) {
        this.ingameSounds = ingameSounds;
    }


    @Override
    public void dispose() {

    }
}

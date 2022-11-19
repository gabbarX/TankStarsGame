package com.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Resources {
    protected SpriteBatch batch;
    protected Sprite sprite;
    public Texture mainScreenBackground;
    public Sprite mainScreenBackgroundSprite;
    public Texture mainMenuBackground;
    public Sprite mainMenuBackgroundSprite;
    public Resources(){
        batch = new SpriteBatch();
        mainScreenBackground = new Texture("mainMenu/loadingScreen.jpg");
        mainScreenBackgroundSprite = new Sprite(mainScreenBackground);
        mainMenuBackground = new Texture("mainMenu/loadingScreen.jpg");
        mainMenuBackgroundSprite = new Sprite(mainMenuBackground);
    }
    public void dispose(){
        batch.dispose();
        mainScreenBackground.dispose();
    }
}

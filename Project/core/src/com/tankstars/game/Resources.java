package com.tankstars.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Resources {
    protected SpriteBatch batch;
    protected Sprite sprite;
    public Texture mainScreenBackground;
    public Sprite mainScreenBackgroundSprite;
    public Resources(){
        batch = new SpriteBatch();
        mainScreenBackground = new Texture("mainScreenBackground.png");
        mainScreenBackgroundSprite = new Sprite(mainScreenBackground);
    }
    public void dispose(){
        batch.dispose();
        mainScreenBackground.dispose();
    }
}

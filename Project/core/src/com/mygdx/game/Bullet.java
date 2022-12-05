package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bullet
{
    private static int SPEED = 200;
    private static int default_y = 40;
    private static Texture texture;
    float x,y;
    public boolean remove = false;

    public Bullet(float x){
        this.x = x;
        this.y = default_y;

        if(texture==null){
            texture = new Texture("MIRV.png");
        }
    }

    public void update(float deltaTime){
        y+= SPEED*deltaTime;
        if(y> Gdx.graphics.getWidth()){
            remove = true;
        }
    }


    public void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }
}

package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet
{
    Rectangle hitbox;
    float a,time;
    int speed;
    Texture text;

    public Bullet(int x, int y, float angle) {
        time = 2;
        speed = 50;
        hitbox = new Rectangle(x,y,10,10);
        text = new Texture("Game Screen/bullet.png");
    }


    public Rectangle getHitbox() {
        return hitbox;
    }

    public void update(float delta){
        hitbox.x += speed*(float)Math.cos(a)*delta;
        hitbox.y += speed*(float)Math.sin(a)*delta;
        time -= delta;

    }

    public boolean isDead(){
        if(time<0) return true;
        else return false;
    }

    public void draw(SpriteBatch batch){
        batch.draw(text,hitbox.x,hitbox.y,10,10);

    }
}



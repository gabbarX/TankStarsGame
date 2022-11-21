package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import java.util.ArrayList;

public class Tank {
    ArrayList<Weapon> weapons;
    Sprite sprite;
    Sprite tankSprite;
    TextureAtlas tankAtlas;
    Skin tankSkin;
    int hitPoints = 800;
    // Abrams tank
    public Tank(int a){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankAbrams"));
        weapons = new ArrayList<Weapon>();
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("VerticalSlam")), "VerticalSlam"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("SplitterChain")), "SplitterChain"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("BigOne")), "BigOne"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("AirStrike")), "AirStrike"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("Shotgun")), "Shotgun"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("Volley")), "Volley"));
    }
    // Frost tank
    public Tank(int a, int b){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankFrost"));
        weapons = new ArrayList<Weapon>();
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("FrostBlast")), "FrostBlast"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("FrostBite")), "FrostBite"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("AssaultDrones")), "AssaultDrones"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("Blizzard")), "Blizzard"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("HighPressure")), "HighPressure"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("IceSplitter")), "IceSplitter"));
    }
    // Buratino tank
    public Tank(int a, int b, int c){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        tankSprite = new Sprite(tankAtlas.findRegion("TankBuratino"));
        weapons = new ArrayList<Weapon>();
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("Homing")), "Homing"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("MIRV")), "MIRV"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("Shredder")), "Shredder"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("AreaStrike")), "AreaStrike"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("RapidFire")), "RapidFire"));
        weapons.add(new Weapon(new Sprite(tankAtlas.findRegion("Hounds")), "Hounds"));
    }

}

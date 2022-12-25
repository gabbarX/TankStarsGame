package com.tankstars.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Tank extends com.tankstars.game.TankStars {
    public Sprite tankSprite;
    public TextureAtlas tankAtlas;
    public Skin tankSkin;
    public com.tankstars.game.Weapons CurrentWeapon;
    public com.tankstars.game.Weapons AbramsSplitterChain, AbramsBigOne, AbramsAirStrike, AbramsShotgun, AbramsVolley, AbramsMIRV;
    public com.tankstars.game.Weapons FrostBlast, FrostBite, FrostBlizzard, FrostAssaultDrones, FrostHighPressure, FrostIceSplitter;
    public com.tankstars.game.Weapons BuratinoHoming, BuratinoMIRV,BuratinoShredder,BuratinoAreaStrike,BuratinoRapidFire, BuratinoHounds;
    public int health = 100;
    public int speed = 0;
    public int fuelLeft = 100;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public Tank(){
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        tankSkin = new Skin(tankAtlas);
        {
            AbramsSplitterChain = new com.tankstars.game.Weapons("SplitterChain");
            AbramsBigOne = new com.tankstars.game.Weapons("BigOne");
            AbramsAirStrike = new com.tankstars.game.Weapons("AirStrike");
            AbramsShotgun = new com.tankstars.game.Weapons("Shotgun");
            AbramsVolley = new com.tankstars.game.Weapons("Volley");
            AbramsMIRV = new com.tankstars.game.Weapons("MIRV");
        }
        {
            BuratinoHoming = new com.tankstars.game.Weapons("Homing");
            BuratinoMIRV = new com.tankstars.game.Weapons("MIRV");
            BuratinoShredder = new com.tankstars.game.Weapons("Shredder");
            BuratinoAreaStrike = new com.tankstars.game.Weapons("AreaStrike");
            BuratinoRapidFire = new com.tankstars.game.Weapons("RapidFire");
            BuratinoHounds = new com.tankstars.game.Weapons("Hounds");
        }
        {
            FrostBlast = new com.tankstars.game.Weapons("Blast");
            FrostBite = new com.tankstars.game.Weapons("Bite");
            FrostBlizzard = new com.tankstars.game.Weapons("Blizzard");
            FrostAssaultDrones = new com.tankstars.game.Weapons("AssaultDrones");
            FrostHighPressure = new com.tankstars.game.Weapons("HighPressure");
            FrostIceSplitter = new com.tankstars.game.Weapons("IceSplitter");
        }
    }
    public void moveLeft(){
        if (isPlayer1){
            speed = -5000;
        }
        else{
            speed = 5000;
        }
    }
    public void moveRight(){
        if (isPlayer1){
            speed = 5000;
        }
        else{
            speed = -5000;
        }
    }
    public void stop(){
        speed = 0;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setFuelLeft(int fuelLeft) {
        this.fuelLeft = fuelLeft;
    }
    public int getHealth() {
        return health;
    }
    public String getCurrentWeapon(){
        return CurrentWeapon.getName();
    }
    public int getFuelLeft() {
        return fuelLeft;
    }

    public int getSpeed() {
        return speed;
    }

    public void setCurrentWeapon(String weaponName) {
        switch(weaponName){
            case "SplitterChain":
                CurrentWeapon = AbramsSplitterChain;
                break;
            case "BigOne":
                CurrentWeapon = AbramsBigOne;
                break;
            case "AirStrike":
                CurrentWeapon = AbramsAirStrike;
                break;
            case "Shotgun":
                CurrentWeapon = AbramsShotgun;
                break;
            case "Volley":
                CurrentWeapon = AbramsVolley;
                break;
            case "MIRV":
                CurrentWeapon = AbramsMIRV;
                break;
            case "Homing":
                CurrentWeapon = BuratinoHoming;
                break;
            case "Shredder":
                CurrentWeapon = BuratinoShredder;
                break;
            case "AreaStrike":
                CurrentWeapon = BuratinoAreaStrike;
                break;
            case "RapidFire":
                CurrentWeapon = BuratinoRapidFire;
                break;
            case "Hounds":
                CurrentWeapon = BuratinoHounds;
                break;
            case "Blast":
                CurrentWeapon = FrostBlast;
                break;
            case "Bite":
                CurrentWeapon = FrostBite;
                break;
            case "Blizzard":
                CurrentWeapon = FrostBlizzard;
                break;
            case "AssaultDrones":
                CurrentWeapon = FrostAssaultDrones;
                break;
            case "HighPressure":
                CurrentWeapon = FrostHighPressure;
                break;
            case "IceSplitter":
                CurrentWeapon = FrostIceSplitter;
                break;
        }
    }
}

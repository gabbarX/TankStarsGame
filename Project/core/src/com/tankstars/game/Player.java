package com.tankstars.game;

import java.util.Objects;

public class Player {
    private int hitPoints = 800;
    public Tank tank;
    private boolean isPlayer1;
    public Player(String tankName, boolean isPlayer1){
        this.isPlayer1 = isPlayer1;
        switch (tankName) {
            case "Abrams":
                tank = new Tank(1);
                break;
            case "Frost":
                tank = new Tank(1, 1);
                break;
            case "Buratino":
                tank = new Tank(1, 1, 1);
                break;
        }
        if (!isPlayer1) {
            assert this.tank != null;
            this.tank.tankSprite.flip(true, false);
        }
    }
}

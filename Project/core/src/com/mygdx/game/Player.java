package com.tankstars.game;

public class Player extends com.tankstars.game.TankStars {
    private int hitPoints = 800;
    private com.tankstars.game.TankAbrams tankAbrams = null;
    private com.tankstars.game.TankBuratino tankBuratino = null;
    private com.tankstars.game.TankFrost tankFrost = null;
    private int tankType;
    private boolean isPlayer1;
    private boolean isPlayer2;
    public Player(String tankName, boolean isPlayer1,int tankType){
        this.isPlayer1 = isPlayer1;
        this.isPlayer2 = !isPlayer1;
        switch(tankType) {
            case 0:
                tankAbrams = new com.tankstars.game.TankAbrams(isPlayer1, isPlayer2);
                tankType = 0;
                break;
            case 1:
                tankFrost = new com.tankstars.game.TankFrost(isPlayer1, isPlayer2);
                tankType = 1;
                break;
            case 2:
                tankBuratino = new com.tankstars.game.TankBuratino(isPlayer1, isPlayer2);
                tankType = 2;
                break;
        }
    }
    public com.tankstars.game.TankBuratino getTankBuratino() {
        return tankBuratino;
    }
    public com.tankstars.game.TankFrost getTankFrost() {
        return tankFrost;
    }
    public com.tankstars.game.TankAbrams getTankAbrams() {
        return tankAbrams;
    }
    public int getTankType() {
        return tankType;
    }
}

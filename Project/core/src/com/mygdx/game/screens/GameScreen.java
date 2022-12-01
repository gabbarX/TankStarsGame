package com.tankstars.game.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.sun.java.swing.action.AlignCenterAction;
import com.tankstars.game.Player;
import com.tankstars.game.TankStars;
import com.badlogic.gdx.physics.box2d.World;


import com.badlogic.gdx.Screen;

import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class GameScreen extends com.tankstars.game.screens.DefaultScreen {
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    public GameScreen(TankStars game, int player1){
        super(game);
        flag = true;
        this.isPlayer1 = player1;
        this.isPlayer2 = (int) (Math.random() * 3);
    }
    public GameScreen(TankStars game, int player1, int player2) {
        super(game);
        flag = false;
        this.isPlayer1 = player1;
        this.isPlayer2 = player2;
    }
    private Stage stage;
    private boolean flag;
    private Image background, dirtTerrain, healthBarP1, healthbarP2, badgeP1, badgeP2, vslogo;
    Player player1, player2;
    int isPlayer1, isPlayer2;
    private TextureAtlas tankAtlas;
    @Override
    public void show() {
        world = new World(new Vector2(0,-9.8f), true);
        debugRenderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        switch(isPlayer1) {
            case 0:
                player1 = new Player("Abrams", true);
                break;
            case 1:
                player1 = new Player("Frost", true);
                break;
            case 2:
                player1 = new Player("Buratino", true);
                break;
        }
        switch(isPlayer2) {
            case 0:
                player2 = new Player("Abrams", false);
                break;
            case 1:
                player2 = new Player("Frost",  false);
                break;
            case 2:
                player2 = new Player("Buratino", false);
                break;
        }
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        background = new Image(new Texture(Gdx.files.internal("Game Screen/main_game_bg.png")));
        dirtTerrain = new Image(new Texture(Gdx.files.internal("Game Screen/dirt_terrain.png")));
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new BitmapFont(Gdx.files.internal("Fonts/black.fnt"));
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Tanks/button_up.png"))));
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Tanks/button_down.png"))));
        TextButton forward1 = new TextButton("Forward", textButtonStyle);
        forward1.setSize(100, 50);
        forward1.setPosition(Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/10);
        forward1.pad(20);
        TextButton backward1 = new TextButton("Backward", textButtonStyle);
        backward1.setSize(125, 50);
        backward1.pad(20);
        backward1.setPosition(Gdx.graphics.getWidth()/10+150, Gdx.graphics.getHeight()/10);
        TextButton forward2 = new TextButton("Forward", textButtonStyle);
        forward2.setSize(100, 50);
        forward2.setPosition(Gdx.graphics.getWidth()/10 * 7, Gdx.graphics.getHeight()/10);
        forward2.pad(20);
        TextButton backward2 = new TextButton("Backward", textButtonStyle);
        backward2.setSize(125, 50);
        backward2.pad(20);
        backward2.setPosition(Gdx.graphics.getWidth()/10 * 7 + 150, Gdx.graphics.getHeight()/10);
        forward1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                player1.tank.setPosition(player1.tank.getPositionX()+10, player1.tank.getPositionY());
            }
        });
        backward1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                player1.tank.setPosition(player1.tank.getPositionX()-10, player1.tank.getPositionY());
            }
        });
        forward2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                player2.tank.setPosition(player2.tank.getPositionX()-10, player2.tank.getPositionY());
            }
        });
        backward2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                player2.tank.setPosition(player2.tank.getPositionX()+10, player2.tank.getPositionY());
            }
        });
        dirtTerrain.setHeight(Gdx.graphics.getHeight()/4);
        dirtTerrain.setWidth(Gdx.graphics.getWidth());
        dirtTerrain.setPosition(0,0);
        healthBarP1 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        healthbarP2 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        badgeP1 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        badgeP2 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
//        vslogo = new Image(new Texture(Gdx.files.internal("Game Screen/vslogo.png")));
//        player1.tank.tankSprite.setPosition(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/4);
//        player2.tank.tankSprite.setPosition(Gdx.graphics.getWidth()*4/5, Gdx.graphics.getHeight()/4);
        player1.tank.setPosition(Gdx.graphics.getWidth()/7, Gdx.graphics.getHeight()/4);
        player2.tank.setPosition(Gdx.graphics.getWidth()*4/5, Gdx.graphics.getHeight()/4);
        player1.tank.setSize(100,60);
        player2.tank.setSize(100,60);
        healthBarP1.setPosition(230,600);
        badgeP1.setSize(60,60);
        badgeP1.setPosition(190,600);
        healthbarP2.setPosition(670,600);
        badgeP2.setPosition(930,600);
        badgeP2.setSize(60,60);
//        vslogo.setPosition(546,590);
        stage.addActor(background);
        stage.addActor(dirtTerrain);
        stage.addActor(healthBarP1);
        stage.addActor(healthbarP2);
        stage.addActor(badgeP1);
        stage.addActor(badgeP2);
//        stage.addActor(vslogo);
        stage.addActor(forward1);
        stage.addActor(backward1);
        if (!flag){
            stage.addActor(forward2);
            stage.addActor(backward2);
        }
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        debugRenderer.render(world, camera.combined);
        // create a body definition for the tank
        BodyDef tankDef = new BodyDef();
        tankDef.type = BodyDef.BodyType.DynamicBody;
        tankDef.position.set(0, 0);
        // create a fixture 
//        stage.setDebugAll(true);
        stage.act(delta);
        stage.draw();
        batch = new SpriteBatch();
        batch.begin();
        player1.tank.tankSprite.draw(batch);
        player2.tank.tankSprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
}

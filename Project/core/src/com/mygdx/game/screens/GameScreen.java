package com.tankstars.game.screens;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.InputController;
import com.sun.java.swing.action.AlignCenterAction;
import com.tankstars.game.Player;
import com.tankstars.game.TankStars;
import com.badlogic.gdx.Screen;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class GameScreen extends com.tankstars.game.screens.DefaultScreen {
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private Stage stage;
    private Image background, healthBarP1, healthbarP2, badgeP1, badgeP2, vslogo;
    Player Player1, Player2;
    int isPlayer1, isPlayer2;
    TextureAtlas atlas;
    BitmapFont white, black;
    TextButton.TextButtonStyle textButtonStyle;
    TextButton fireButton;
    Skin skin;
    Body tankBody, tankBody2;
    private TextureAtlas tankAtlas;
    boolean isPlayer1Turn = true;
    Vector2 tank1Speed = new Vector2(0f, 0f);
    Vector2 tank2Speed = new Vector2(0f, 0f);
    private Texture myTexture;
    private Table pauseTable;
    private TextButton resumeButton, mainMenuButton;

//    private TextureRegion;
//    private TextureRegionDrawable;
    private ImageButton pauseButton;
    Image popUp = new Image(new Texture(Gdx.files.internal("mainMenu/popUpBackground.jpg")));
    public GameScreen(TankStars game, int player1, int player2) {
        super(game);
        // setting up the box2d world, camera and debugrenderer
        {
            world = new World(new Vector2(0, -9.8f), true);
            debugRenderer = new Box2DDebugRenderer();
            camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
        // making player1 and player2 instances of the Player class
        {
            switch (player1) {
                case 0:
                    Player1 = new Player("TankAbrams", true, 0);
                    break;
                case 1:
                    Player1 = new Player("TankFrost", true, 1);
                    break;
                case 2:
                    Player1 = new Player("TankBuratino", true, 2);
            }
            switch (player2) {
                case 0:
                    Player2 = new Player("TankAbrams", false, 0);
                    break;
                case 1:
                    Player2 = new Player("TankFrost", false, 1);
                    break;
                case 2:
                    Player2 = new Player("TankBuratino", false, 2);
            }
        }
        //  ground definition
        {
            BodyDef groundBodyDef = new BodyDef();
            groundBodyDef.position.set(0, 0);
            Body groundBody = world.createBody(groundBodyDef);
            // ground shape
            ChainShape groundShape = new ChainShape();
            groundShape.createChain(new Vector2[]{
                    new Vector2(-600, 337.5f),
                    new Vector2(-600, 65),
                    new Vector2(-565, 65),
                    new Vector2(-515, 10),
                    new Vector2(-460, -55),
                    new Vector2(-325, -55),
                    new Vector2(-270, 10),
                    new Vector2(-245, 37),
                    new Vector2(-180, 37),
                    new Vector2(-155, 10),
                    new Vector2(-92, -64),
                    new Vector2(100, -64),
                    new Vector2(190, 38),
                    new Vector2(350, 38),
                    new Vector2(420, -35),
                    new Vector2(500, -35),
                    new Vector2(560, -110),
                    new Vector2(600, -110),
                    new Vector2(600, 337.5f),
            });
            // ground fixture
            FixtureDef groundFixtureDef = new FixtureDef();
            groundFixtureDef.shape = groundShape;
            groundFixtureDef.density = 100000f;
            groundFixtureDef.friction = 0f;
            groundFixtureDef.restitution = 0f;
            Fixture groundFixture = groundBody.createFixture(groundFixtureDef);
        }
        // Tanks Definition
        {
            BodyDef tankDef = new BodyDef();
            tankDef.type = BodyDef.BodyType.DynamicBody;
            tankDef.position.set(-400, -42);
            tankBody = world.createBody(tankDef);
            PolygonShape tankShape = new PolygonShape();
            tankShape.setAsBox(20, 20);
            // Tank Fixture Definition
            FixtureDef tankFixtureDef = new FixtureDef();
            tankFixtureDef.shape = tankShape;
            tankFixtureDef.density = 10f;
            tankFixtureDef.friction = 0.7f;
            tankFixtureDef.restitution = 0.2f;
            Fixture tankFixture = tankBody.createFixture(tankFixtureDef);
            // Tank 2 Definition
            BodyDef tankDef2 = new BodyDef();
            tankDef2.type = BodyDef.BodyType.DynamicBody;
            tankDef2.position.set(300, 55);
            tankBody2 = world.createBody(tankDef2);
            PolygonShape tankShape2 = new PolygonShape();
            tankShape.setAsBox(20, 20);
            Fixture tankFixture2 = tankBody2.createFixture(tankFixtureDef);
        }
        // Bullet Definition
    }
    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        skin = new Skin(atlas);
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        textButtonStyle = new TextButton.TextButtonStyle();
        // making buttons for main menu screen
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;
        fireButton = new TextButton("FIRE", textButtonStyle);
        fireButton.setTransform(true);
        fireButton.setScale(0.6f);
        fireButton.pad(10);
        fireButton.setPosition(750, 100);
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        background = new Image(new Texture(Gdx.files.internal("Game Screen/gameScreenBackground.jpg")));
        healthBarP1 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        healthbarP2 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        badgeP1 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        badgeP2 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
//        InputController inputController1 = new InputController(){
//            @Override
//            public boolean keyDown(int keycode) {
//                switch(keycode){
//                    case Input.Keys.D:
//                        if (isPlayer1Turn){
//                            tank1Speed.x = 1000;
//                        }
//                        else{
//                            tank2Speed.x = -1000;
//                        }
//                    case Input.Keys.A:
//                        if (isPlayer1Turn){
//                            tank1Speed.x = -1000;
//                        }
//                        else{
//                            tank2Speed.x = 1000;
//                        }
//                }
//            }
//        };
//        InputMultiplexer inputMultiplexer = new InputMultiplexer();
//        inputMultiplexer.addProcessor(inputController1);

//        inputMultiplexer.addProcessor();
//        vslogo = new Image(new Texture(Gdx.files.internal("Game Screen/vslogo.png")));
//        player1.tank.tankSprite.setPosition(Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()/4);
//        player2.tank.tankSprite.setPosition(Gdx.graphics.getWidth()*4/5, Gdx.graphics.getHeight()/4);
//        player1.tank.setPosition(Gdx.graphics.getWidth()/7, Gdx.graphics.getHeight()/4);
//        player2.tank.setPosition(Gdx.graphics.getWidth()*4/5, Gdx.graphics.getHeight()/4);
//        player1.tank.setSize(100,60);
//        player2.tank.setSize(100,60);
////        stage.addActor(vslogo);

        healthBarP1.setPosition(230,600);
        badgeP1.setSize(60,60);
        badgeP1.setPosition(190,600);
        healthbarP2.setPosition(670,600);
        badgeP2.setPosition(930,600);
        badgeP2.setSize(60,60);
//        vslogo.setPosition(546,590);
        stage.addActor(background);
        stage.addActor(healthBarP1);
        stage.addActor(healthbarP2);
        stage.addActor(badgeP1);
        stage.addActor(badgeP2);
        stage.addActor(fireButton);
        fireButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("HERE");
                isPlayer1Turn = !isPlayer1Turn;
            }
        });
//        stage.addActor(vslogo);
        TextureAtlas atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        Skin skin = new Skin(atlas);
        BitmapFont black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        pauseTable = new Table(skin);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        // making buttons for main menu screen
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;

        resumeButton = new TextButton("Resume", textButtonStyle);
        mainMenuButton = new TextButton("MainMenu", textButtonStyle);
//        resumeButton.setSize(100,20);
        resumeButton.setTransform(true);
        resumeButton.setScale(0.8f);
//        resumeButton.pad(10);

        mainMenuButton.setTransform(true);
        mainMenuButton.setScale(0.8f);
//        mainMenuButton.pad(10);


        resumeButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                popUp.remove();
                pauseTable.remove();
            }
        });
        pauseTable.add(resumeButton);
        pauseTable.row();
        pauseTable.add(mainMenuButton);
//        pauseTable.setSize(100,100);
        pauseTable.setPosition(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        myTexture = new Texture(Gdx.files.internal("Game Screen/pause.png"));
        pauseButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(myTexture)));
        pauseButton.setPosition(0,Gdx.graphics.getHeight()-60);
        pauseButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                popUp.setPosition(Gdx.graphics.getWidth()-780,Gdx.graphics.getHeight()-480);
                stage.addActor(popUp);
                stage.addActor(pauseTable);
//                black.draw(stage.getBatch(), "Are you sure you want to exit?", 400, 400);
            }
        });
        stage.addActor(pauseButton);
//        switch(Player1.getTankType()){
//            case 0:
//                stage.addActor(Player1.getTankAbrams().getTankSprite3x());
//                break;
//            case 1:
//                stage.addActor(Player1.getTankFrost().getTankSprite());
//                break;
//            case 2:
//                stage.addActor(Player1.getTankBuratino().getTankSprite());
//        }

    }
    @Override
    public void render(float delta) {
        batch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        stage.setDebugAll(true);
        stage.act(delta);
        stage.draw();
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if (isPlayer1Turn){
                tank1Speed.x = -100000;
            }
            else{
                tank2Speed.x = -100000;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if (isPlayer1Turn){
                tank1Speed.x = 100000;
            }
            else{
                tank2Speed.x = 100000;
            }
        }
        tankBody.applyForceToCenter(tank1Speed,true);
//        tankBody.applyForce();
        tankBody2.applyForceToCenter(tank2Speed,true);
//        player1.tank.tankSprite.draw(batch);
//        player2.tank.tankSprite.draw(batch);
        world.step(1/60f, 6, 2);
        debugRenderer.render(world, camera.combined);
        batch.end();
    }
    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
}

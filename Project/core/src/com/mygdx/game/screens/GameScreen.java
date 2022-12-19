package com.tankstars.game.screens;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.Bullet;
import com.mygdx.game.InputController;
import com.tankstars.game.TankStars;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class GameScreen extends com.tankstars.game.screens.DefaultScreen {
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private Stage stage;
    private Image background, healthBarP1, healthbarP2, badgeP1, badgeP2, vslogo;
    int isPlayer1, isPlayer2;
    TextureAtlas atlas;
    BitmapFont white, black;
    TextButton.TextButtonStyle textButtonStyle;
    TextButton fireButton, exitButton, exitButton1, exitButton2, saveGameButton;
    TextButton AbramsSplitterChain, AbramsBigOne, AbramsAirStrike, AbramsShotgun, AbramsVolley, AbramsMIRV;
    TextButton BuratinoHoming,BuratinoMIRV,BuratinoShredder,BuratinoAreaStrike,BuratinoRapidFire, BuratinoHounds;
    TextButton FrostBlast, FrostBite, FrostBlizzard, FrostAssaultDrones, FrostHighPressure, FrostIceSplitter;
    Skin skin;
    Body tankBody, tankBody2;
    Body bulletBody;
    private TextureAtlas tankAtlas;
    boolean isPlayer1Turn = true;
    Vector2 bulletSpeed = new Vector2(100000, 20000);
    Vector2 tank1Speed = new Vector2(0f, 0f);
    Vector2 tank2Speed = new Vector2(0f, 0f);
    private Texture myTexture;
    private Table pauseTable, AbramsTable, BuratinoTable, FrostTable;
    private TextButton resumeButton, mainMenuButton;
    //    private TextureRegion;
//    private TextureRegionDrawable;
    private ImageButton pauseButton;
    private ImageButton selectWeapon;
    private com.tankstars.game.Tank player1Tank, player2Tank;
    String player1TankType, player2TankType;
    //    private Image bullet;
    Image popUp = new Image(new Texture(Gdx.files.internal("mainMenu/popUpBackground.jpg")));
    Image weaponPopUp = new Image(new Texture(Gdx.files.internal("mainMenu/popUpBackground.jpg")));
    public void saveGame() throws IOException {
        try {
            File myObj = new File("savedGames\\filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("savedGames\\filename.txt");
            myWriter.write(player1TankType);
            myWriter.write("\n");
            myWriter.write(player2TankType);
            myWriter.write("\n");
            myWriter.write(String.valueOf(player1Tank.getHitPoints()));
            myWriter.write("\n");
            myWriter.write(String.valueOf(player2Tank.getHitPoints()));
            myWriter.write("\n");
            myWriter.write(String.valueOf(player1Tank.getFuelLeft()));
            myWriter.write("\n");
            myWriter.write(String.valueOf(player2Tank.getFuelLeft()));
            myWriter.write("\n");
            // write the position of the tank bodies to the file
            myWriter.write(String.valueOf(tankBody.getPosition().x));
            myWriter.write("\n");
            myWriter.write(String.valueOf(tankBody.getPosition().y));
            myWriter.write("\n");
            myWriter.write(String.valueOf(tankBody2.getPosition().x));
            myWriter.write("\n");
            myWriter.write(String.valueOf(tankBody2.getPosition().y));
            myWriter.write("\n");
            // write the current weapon of each tank to the file
            myWriter.write(player1Tank.getCurrentWeapon());
            myWriter.write("\n");
            myWriter.write(player2Tank.getCurrentWeapon());
            myWriter.write("\n");


            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public GameScreen(TankStars game, String filename) throws FileNotFoundException {
        super(game);
        // reading the data from the file
        String fileName = "savedGames\\" + filename + ".txt";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        player1TankType = scanner.nextLine();
        player2TankType = scanner.nextLine();
        int player1HitPoints = Integer.parseInt(scanner.nextLine());
        int player2HitPoints = Integer.parseInt(scanner.nextLine());
        int player1Fuel = Integer.parseInt(scanner.nextLine());
        int player2Fuel = Integer.parseInt(scanner.nextLine());
        float player1X = Float.parseFloat(scanner.nextLine());
        float player1Y = Float.parseFloat(scanner.nextLine());
        float player2X = Float.parseFloat(scanner.nextLine());
        float player2Y = Float.parseFloat(scanner.nextLine());
        String player1CurrentWeapon = scanner.nextLine();
        String player2CurrentWeapon = scanner.nextLine();
        scanner.close();
        // defining the tank types for player 1 and player 2
        {
                // tank definition for tank 1
                {
                    if (player1TankType.equals("Abrams")) {
                        player1Tank = new com.tankstars.game.TankAbrams(true, false);
                    } else if (player1TankType.equals("Frost")) {
                        player1Tank = new com.tankstars.game.TankFrost(true, false);
                    } else {
                        player1Tank = new com.tankstars.game.TankBuratino(true, false);
                    }
                    player1Tank.setHitPoints(player1HitPoints);
                    player1Tank.setFuelLeft(player1Fuel);
                    player1Tank.setCurrentWeapon(player1CurrentWeapon);
                }
                // tank definition for tank 2
                {
                    if (player2TankType.equals("Abrams")) {
                        player2Tank = new com.tankstars.game.TankAbrams(false, true);
                    } else if (player2TankType.equals("Frost")) {
                        player2Tank = new com.tankstars.game.TankFrost(false, true);
                    } else {
                        player2Tank = new com.tankstars.game.TankBuratino(false, true);
                    }
                    player2Tank.setHitPoints(player2HitPoints);
                    player2Tank.setFuelLeft(player2Fuel);
                    player2Tank.setCurrentWeapon(player2CurrentWeapon);
                }
            }
        // setting up the box2d world, camera and debugrenderer
        {
            world = new World(new Vector2(0, -9.8f), true);
            debugRenderer = new Box2DDebugRenderer();
            camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
            tankDef.position.set(player1X, player1Y);
            tankBody = world.createBody(tankDef);
            PolygonShape tankShape = new PolygonShape();
            tankShape.setAsBox(20, 20);
            // Tank Fixture Definition
            FixtureDef tankFixtureDef = new FixtureDef();
            tankFixtureDef.shape = tankShape;
            tankFixtureDef.density = 12f;
            tankFixtureDef.friction = 0.7f;
            tankFixtureDef.restitution = 0.2f;
            Fixture tankFixture = tankBody.createFixture(tankFixtureDef);
            // Tank 2 Definition
            BodyDef tankDef2 = new BodyDef();
            tankDef2.type = BodyDef.BodyType.DynamicBody;
            tankDef2.position.set(player2X, player2Y);
            tankBody2 = world.createBody(tankDef2);
            PolygonShape tankShape2 = new PolygonShape();
            tankShape.setAsBox(20, 20);
            Fixture tankFixture2 = tankBody2.createFixture(tankFixtureDef);
        }
        //Bullet body
        {
            BodyDef bulletDef = new BodyDef();
            bulletDef.type = BodyDef.BodyType.DynamicBody;
            bulletDef.position.set(-400,-32);
            bulletBody = world.createBody(bulletDef);
            PolygonShape bulletshape = new PolygonShape();
            bulletshape.setAsBox(10,10);

            //Bullet Fixture Defination
            FixtureDef bulletFixtureDef = new FixtureDef();
            bulletFixtureDef.shape = bulletshape;
            bulletFixtureDef.density = 7f;
//            bulletFixtureDef.friction = 0;
//            bulletFixtureDef.restitution = 0.2f;
            Fixture bulletFixture = bulletBody.createFixture(bulletFixtureDef);
        }
    }

    public GameScreen(TankStars game, int player1, int player2) {
        super(game);
        // defining the tank types for player 1 and player 2
        {
            // tank definition for tank 1
            {
                if (player1 == 0) {
                    player1Tank = new com.tankstars.game.TankAbrams(true, false);
                    player1TankType = "Abrams";
                } else if (player1 == 1) {
                    player1Tank = new com.tankstars.game.TankFrost(true, false);
                    player1TankType = "Frost";
                } else {
                    player1Tank = new com.tankstars.game.TankBuratino(true, false);
                    player1TankType = "Buratino";
                }
            }
            // tank definition for tank 2
            {
                if (player2 == 0) {
                    player2Tank = new com.tankstars.game.TankAbrams(false, true);
                    player2TankType = "Abrams";
                } else if (player2 == 1) {
                    player2Tank = new com.tankstars.game.TankFrost(false, true);
                    player2TankType = "Frost";
                } else {
                    player2Tank = new com.tankstars.game.TankBuratino(false, true);
                    player2TankType = "Buratino";
                }
            }
        }
        // setting up the box2d world, camera and debugrenderer
        {
            world = new World(new Vector2(0, -9.8f), true);
            debugRenderer = new Box2DDebugRenderer();
            camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
            tankFixtureDef.density = 12f;
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
        //Bullet body
        {
            BodyDef bulletDef = new BodyDef();
            bulletDef.type = BodyDef.BodyType.DynamicBody;
            bulletDef.position.set(-400,-32);
            bulletBody = world.createBody(bulletDef);
            PolygonShape bulletshape = new PolygonShape();
            bulletshape.setAsBox(10,10);

            //Bullet Fixture Defination
            FixtureDef bulletFixtureDef = new FixtureDef();
            bulletFixtureDef.shape = bulletshape;
            bulletFixtureDef.density = 7f;
//            bulletFixtureDef.friction = 0;
//            bulletFixtureDef.restitution = 0.2f;
            Fixture bulletFixture = bulletBody.createFixture(bulletFixtureDef);
        }

    }
    @Override
    public void show() {
//        bullet = new Image(new Texture(Gdx.files.internal("Game Screen/tempBullet.png")));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        skin = new Skin(atlas);
        white = new BitmapFont(Gdx.files.internal("fonts/white.fnt"), false);
        black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        tankAtlas = new TextureAtlas("Tanks/items.pack");
        background = new Image(new Texture(Gdx.files.internal("Game Screen/gameScreenBackground.jpg")));
        healthBarP1 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        healthbarP2 = new Image(new Texture(Gdx.files.internal("Game Screen/healthbar.png")));
        badgeP1 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        badgeP2 = new Image(new Texture(Gdx.files.internal("Game Screen/badge.png")));
        {
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
        }
        // making buttons for main game screen
        {
            textButtonStyle = new TextButton.TextButtonStyle();
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
            exitButton = new TextButton("EXIT", textButtonStyle);
            exitButton.setTransform(true);
            exitButton.setScale(0.6f);
            exitButton1 = new TextButton("EXIT", textButtonStyle);
            exitButton1.setTransform(true);
            exitButton1.setScale(0.6f);
            exitButton2 = new TextButton("EXIT", textButtonStyle);
            exitButton2.setTransform(true);
            exitButton2.setScale(0.6f);
        }
        // Abram Weapon button definition
        {
            AbramsSplitterChain = new TextButton("Splitter Chain", textButtonStyle);
            AbramsSplitterChain.setTransform(true);
            AbramsSplitterChain.setScale(0.6f);
            AbramsSplitterChain.pad(10);
            AbramsBigOne = new TextButton("Big One", textButtonStyle);
            AbramsBigOne.setTransform(true);
            AbramsBigOne.setScale(0.6f);
            AbramsBigOne.pad(10);
            AbramsAirStrike = new TextButton("Air Strike", textButtonStyle);
            AbramsAirStrike.setTransform(true);
            AbramsAirStrike.setScale(0.6f);
            AbramsAirStrike.pad(10);
            AbramsShotgun = new TextButton("Shotgun", textButtonStyle);
            AbramsShotgun.setTransform(true);
            AbramsShotgun.setScale(0.6f);
            AbramsShotgun.pad(10);
            AbramsVolley = new TextButton("Volley", textButtonStyle);
            AbramsVolley.setTransform(true);
            AbramsVolley.setScale(0.6f);
            AbramsVolley.pad(10);
            AbramsMIRV = new TextButton("MIRV", textButtonStyle);
            AbramsMIRV.setTransform(true);
            AbramsMIRV.setScale(0.6f);
            AbramsMIRV.pad(10);
        }
        // Buratino Weapon button definition
        {
            BuratinoHoming = new TextButton("Homing", textButtonStyle);
            BuratinoHoming.setTransform(true);
            BuratinoHoming.setScale(0.6f);
            BuratinoHoming.pad(10);
            BuratinoMIRV = new TextButton("MIRV", textButtonStyle);
            BuratinoMIRV.setTransform(true);
            BuratinoMIRV.setScale(0.6f);
            BuratinoMIRV.pad(10);
            BuratinoShredder = new TextButton("Shredder", textButtonStyle);
            BuratinoShredder.setTransform(true);
            BuratinoShredder.setScale(0.6f);
            BuratinoShredder.pad(10);
            BuratinoAreaStrike = new TextButton("Area Strike", textButtonStyle);
            BuratinoAreaStrike.setTransform(true);
            BuratinoAreaStrike.setScale(0.6f);
            BuratinoAreaStrike.pad(10);
            BuratinoRapidFire = new TextButton("Rapid Fire", textButtonStyle);
            BuratinoRapidFire.setTransform(true);
            BuratinoRapidFire.setScale(0.6f);
            BuratinoRapidFire.pad(10);
            BuratinoHounds = new TextButton("Hounds", textButtonStyle);
            BuratinoHounds.setTransform(true);
            BuratinoHounds.setScale(0.6f);
            BuratinoHounds.pad(10);
        }
        // Frost Weapon button definition
        {
            FrostBlast = new TextButton("Blast", textButtonStyle);
            FrostBlast.setTransform(true);
            FrostBlast.setScale(0.6f);
            FrostBlast.pad(10);
            FrostBite = new TextButton("Bite", textButtonStyle);
            FrostBite.setTransform(true);
            FrostBite.setScale(0.6f);
            FrostBite.pad(10);
            FrostBlizzard = new TextButton("Blizzard", textButtonStyle);
            FrostBlizzard.setTransform(true);
            FrostBlizzard.setScale(0.6f);
            FrostBlizzard.pad(10);
            FrostAssaultDrones = new TextButton("Assualt Drones", textButtonStyle);
            FrostAssaultDrones.setTransform(true);
            FrostAssaultDrones.setScale(0.6f);
            FrostAssaultDrones.pad(10);
            FrostHighPressure = new TextButton("High Pressure", textButtonStyle);
            FrostHighPressure.setTransform(true);
            FrostHighPressure.setScale(0.6f);
            FrostHighPressure.pad(10);
            FrostIceSplitter = new TextButton("Ice Splitter", textButtonStyle);
            FrostIceSplitter.setTransform(true);
            FrostIceSplitter.setScale(0.6f);
            FrostIceSplitter.pad(10);
        }
        // Add a clicklistener for all the buttons of Abrams type
        {
            AbramsSplitterChain.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.AbramsSplitterChain;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.AbramsSplitterChain;
                    }
                }
            });
            AbramsBigOne.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.AbramsBigOne;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.AbramsBigOne;
                    }
                }
            });
            AbramsShotgun.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.AbramsShotgun;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.AbramsShotgun;
                    }
                }
            });
            AbramsAirStrike.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.AbramsAirStrike;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.AbramsAirStrike;
                    }
                }
            });
            AbramsVolley.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.AbramsVolley;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.AbramsVolley;
                    }
                }
            });
            AbramsMIRV.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.AbramsMIRV;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.AbramsMIRV;
                    }
                }
            });
        }
        // Add a clickListener for all buttons for all weapons for Buratino type
        {
            BuratinoHoming.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.BuratinoHoming;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.BuratinoHoming;
                    }
                }
            });
            BuratinoMIRV.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.BuratinoMIRV;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.BuratinoMIRV;
                    }
                }
            });
            BuratinoShredder.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.BuratinoShredder;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.BuratinoShredder;
                    }
                }
            });
            BuratinoAreaStrike.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.BuratinoAreaStrike;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.BuratinoAreaStrike;
                    }
                }
            });
            BuratinoRapidFire.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.BuratinoRapidFire;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.BuratinoRapidFire;
                    }
                }
            });
            BuratinoHounds.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.BuratinoHounds;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.BuratinoHounds;
                    }
                }
            });
        }
        // Add a clickListener for all buttons for all weapons for Frost type
        {
            // add a clickListener for all buttons for all weapons for Frost type
            FrostBite.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.FrostBite;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.FrostBite;
                    }
                }
            });
            FrostAssaultDrones.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.FrostAssaultDrones;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.FrostAssaultDrones;
                    }
                }
            });
            FrostHighPressure.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.FrostHighPressure;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.FrostHighPressure;
                    }
                }
            });
            FrostBlast.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.FrostBlast;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.FrostBlast;
                    }
                }
            });
            FrostBlizzard.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.FrostBlizzard;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.FrostBlizzard;
                    }
                }
            });
            FrostIceSplitter.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    if (isPlayer1Turn) {
                        player1Tank.CurrentWeapon = player1Tank.FrostIceSplitter;
                    } else {
                        player2Tank.CurrentWeapon = player2Tank.FrostIceSplitter;
                    }
                }
            });
        }
        healthBarP1.setPosition(230, 600);
        badgeP1.setSize(60, 60);
        badgeP1.setPosition(190, 600);
        healthbarP2.setPosition(670, 600);
        badgeP2.setPosition(930, 600);
        badgeP2.setSize(60, 60);
//        vslogo.setPosition(546,590);
        stage.addActor(background);
        stage.addActor(healthBarP1);
        stage.addActor(healthbarP2);
        stage.addActor(badgeP1);
        stage.addActor(badgeP2);
        stage.addActor(fireButton);
        fireButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Fire");
                isPlayer1Turn = !isPlayer1Turn;
            }
        });
//        stage.addActor(vslogo);
        TextureAtlas atlas = new TextureAtlas("mainMenu/pack/button.atlas");
        Skin skin = new Skin(atlas);
        BitmapFont black = new BitmapFont(Gdx.files.internal("fonts/black.fnt"), false);
        pauseTable = new Table(skin);
        AbramsTable = new Table(skin);
        BuratinoTable = new Table(skin);
        FrostTable = new Table(skin);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.getDrawable("button_up");
        textButtonStyle.down = skin.getDrawable("button_down");
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = black;
        // Making the buttons for the pause menu
        {
            resumeButton = new TextButton("Resume", textButtonStyle);
            mainMenuButton = new TextButton("MainMenu", textButtonStyle);
            resumeButton.setTransform(true);
            resumeButton.setScale(0.8f);
            mainMenuButton.setTransform(true);
            mainMenuButton.setScale(0.8f);
            saveGameButton = new TextButton("Save Game", textButtonStyle);
            saveGameButton.setTransform(true);
            saveGameButton.setScale(0.8f);
            saveGameButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    System.out.println("Save Game");
                    try {
                        saveGame();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            resumeButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    popUp.remove();
                    pauseTable.remove();
                }
            });
        }
        pauseTable.add(resumeButton);
        pauseTable.row();
        pauseTable.add(saveGameButton);
        pauseTable.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        // Adding the buttons and images to table for Abrams
        {
            AbramsTable.add(game.resources.AbramsSplitterChain);
            AbramsTable.add(AbramsSplitterChain);
            AbramsTable.row();
            AbramsTable.add(game.resources.AbramsBigOne);
            AbramsTable.add(AbramsBigOne);
            AbramsTable.row();
            AbramsTable.add(game.resources.AbramsAirStrike);
            AbramsTable.add(AbramsAirStrike);
            AbramsTable.row();
            AbramsTable.add(game.resources.AbramsShotgun);
            AbramsTable.add(AbramsShotgun);
            AbramsTable.row();
            AbramsTable.add(game.resources.AbramsVolley);
            AbramsTable.add(AbramsVolley);
            AbramsTable.row();
            AbramsTable.add(exitButton);
            AbramsTable.row();
            AbramsTable.setPosition(1000, 675 / 2f);
        }
        // Adding the buttons and images to table for Buratino
        {
            BuratinoTable.add(game.resources.BuratinoHoming);
            BuratinoTable.add(BuratinoHoming);
            BuratinoTable.row();
            BuratinoTable.add(game.resources.BuratinoMIRV);
            BuratinoTable.add(BuratinoMIRV);
            BuratinoTable.row();
            BuratinoTable.add(game.resources.BuratinoShredder);
            BuratinoTable.add(BuratinoShredder);
            BuratinoTable.row();
            BuratinoTable.add(game.resources.BuratinoAreaStrike);
            BuratinoTable.add(BuratinoAreaStrike);
            BuratinoTable.row();
            BuratinoTable.add(game.resources.BuratinoHounds);
            BuratinoTable.add(BuratinoHounds);
            BuratinoTable.row();
            BuratinoTable.add(exitButton1);
            BuratinoTable.setPosition(1040, 675 / 2f);
        }
        // Adding the buttons and images to table for Frost
        {
            FrostTable.add(game.resources.FrostBlast);
            FrostTable.add(FrostBlast);
            FrostTable.row();
            FrostTable.add(game.resources.FrostBite);
            FrostTable.add(FrostBite);
            FrostTable.row();
            FrostTable.add(game.resources.FrostBlizzard);
            FrostTable.add(FrostBlizzard);
            FrostTable.row();
            FrostTable.add(game.resources.FrostAssaultDrones);
            FrostTable.add(FrostAssaultDrones);
            FrostTable.row();
            FrostTable.add(game.resources.FrostHighPressure);
            FrostTable.add(FrostHighPressure);
            FrostTable.row();
//        FrostTable.add(game.resources.FrostIceSplitter);
//        FrostTable.add(FrostIceSplitter);
//        FrostTable.row();
            FrostTable.add(exitButton2);
            FrostTable.setPosition(1000, 675 / 2f);
        }
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
        // making the exit button clickable
        {
            exitButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    switch (check()) {
                        case 1:
                        case 4: {
                            AbramsTable.remove();
                            break;
                        }
                        case 2:
                        case 5: {
                            BuratinoTable.remove();
                            break;
                        }
                        case 3:
                        case 6: {
                            FrostTable.remove();
                            break;
                        }
                    }
                    weaponPopUp.remove();
                }
            });
            exitButton1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    switch (check()) {
                        case 1:
                        case 4: {
                            AbramsTable.remove();
                            break;
                        }
                        case 2:
                        case 5: {
                            BuratinoTable.remove();
                            break;
                        }
                        case 3:
                        case 6: {
                            FrostTable.remove();
                            break;
                        }
                    }
                    weaponPopUp.remove();
                }
            });
            exitButton2.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    switch (check()) {
                        case 1:
                        case 4: {
                            AbramsTable.remove();
                            break;
                        }
                        case 2:
                        case 5: {
                            BuratinoTable.remove();
                            break;
                        }
                        case 3:
                        case 6: {
                            FrostTable.remove();
                            break;
                        }
                    }
                    weaponPopUp.remove();
                }
            });
        }
        selectWeapon = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Tanks/chooseButton.png")))));
        selectWeapon.setPosition(Gdx.graphics.getWidth()/2+60,Gdx.graphics.getHeight()/6);
        selectWeapon.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                weaponPopUp.setPosition(Gdx.graphics.getWidth()-400,0);
                weaponPopUp.setSize(700,Gdx.graphics.getHeight());
                stage.addActor(weaponPopUp);
                System.out.println(isPlayer1Turn);
                if (isPlayer1Turn){
                    if (Objects.equals(player1TankType, "Abrams")){
                        stage.addActor(AbramsTable);
                    }
                    else if (Objects.equals(player1TankType, "Buratino")){
                        stage.addActor(BuratinoTable);
                    }
                    else{
                        stage.addActor(FrostTable);
                    }
                }
                else{
                    if (Objects.equals(player2TankType, "Abrams")){
                        stage.addActor(AbramsTable);
                    }
                    else if (Objects.equals(player2TankType, "Buratino")){
                        stage.addActor(BuratinoTable);
                    }
                    else{
                        stage.addActor(FrostTable);
                    }
                }
            }
        });
        stage.addActor(selectWeapon);
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
        stage.setDebugAll(true);
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


        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            System.out.println("HERE");
            isPlayer1Turn = !isPlayer1Turn;
            bulletBody.applyLinearImpulse(bulletSpeed,bulletBody.getPosition(),true);
        }

        tankBody.applyForceToCenter(tank1Speed,true);
//        tankBody.applyForce();
        tankBody2.applyForceToCenter(tank2Speed,true);
        world.step(1/60f, 6, 2);
        debugRenderer.render(world, camera.combined);
        batch.end();
    }
    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }
    public int check(){
        if (isPlayer1Turn){
            if (Objects.equals(player1TankType, "Abrams")){
                return 1;
            }
            else if (Objects.equals(player1TankType, "Buratino")){
                return 2;
            }
            else{
                return 3;
            }
        }
        else{
            if (Objects.equals(player2TankType,"Abrams")){
                return 4;
            }
            else if (Objects.equals(player2TankType,"Buratino")){
                return 5;
            }
            else{
                return 6;
            }
        }
    }
}

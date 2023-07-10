package com.mygdx.game;
import com.badlogic.gdx.physics.box2d.*;

public class TankBulletContactListener implements ContactListener {
    private Body groundBody;
    private Body tankBody;
    private Body tankBody2;
    private Body bulletBody;
    private Body bulletBody2;
    public TankBulletContactListener(Body groundBody, Body tankBody,Body tankBody2, Body bulletBody, Body bulletBody2) {
        this.groundBody = groundBody;
        this.tankBody = tankBody;
        this.bulletBody = bulletBody;
        this.tankBody2 = tankBody2;
        this.bulletBody2 = bulletBody2;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        if ((fixtureA.getBody() == tankBody && fixtureB.getBody() == bulletBody) || (fixtureA.getBody() == bulletBody && fixtureB.getBody() == tankBody)) {
            System.out.println("Tank1 and Bullet1 initialised");
        }

        if ((fixtureA.getBody() == tankBody2 && fixtureB.getBody() == bulletBody2) || (fixtureA.getBody() == bulletBody2 && fixtureB.getBody() == tankBody2)) {
            System.out.println("Tank2 and Bullet2 initialised");
        }

        if ((fixtureA.getBody() == bulletBody && fixtureB.getBody() == groundBody) || (fixtureA.getBody() == groundBody && fixtureB.getBody() == bulletBody)) {
            System.out.println("Bullet1 on ground");
        }
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }
}

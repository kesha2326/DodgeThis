package com.unicorngames.dodgethis.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.unicorngames.dodgethis.tools.CollisionProcessing;

public class Box {

    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private static Texture texture;

    public float x,y;
    CollisionProcessing collision;

    public Box(float x, float y) {
        this.x = x;
        this.y = y;
        texture = new Texture("box.png");
        this.collision = new CollisionProcessing(x, y, WIDTH, HEIGHT);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public CollisionProcessing getCollisionProcessing() {
        return collision;
    }

}

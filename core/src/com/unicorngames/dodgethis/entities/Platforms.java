package com.unicorngames.dodgethis.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.unicorngames.dodgethis.tools.CollisionProcessing;

public class Platforms {
    private static final int PLATFORM_WIDTH = 1000;
    private static final int PLATFORM_HEIGHT = 50;
    public float x;
    public float y;

    CollisionProcessing collision;

    public Platforms() {
        x = 0;
        y = 200;
        this.collision = new CollisionProcessing(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
    }

    public void render(SpriteBatch batch) {
        batch.draw(new Texture("grass_platform.png"), x, y);
    }

    public CollisionProcessing getCollisionProcessing() {
        return collision;
    }

    public int getPLATFORM_HEIGHT() {
        return PLATFORM_HEIGHT;
    }
}

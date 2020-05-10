package com.unicorngames.dodgethis.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.unicorngames.dodgethis.tools.CollisionProcessing;

public class Platforms {
    private static final int PLATFORM_WIDTH = 1000;
    private static final int PLATFORM_HEIGHT = 50;
    int x;
    int y;

    CollisionProcessing collision;

    public Platforms(int x, int y) {
        this.x = x;
        this.y = y;
        this.collision = new CollisionProcessing(x, y, PLATFORM_WIDTH, PLATFORM_HEIGHT);
    }

    public void render(SpriteBatch batch) {
        batch.draw(new Texture("grass_platform.png"), x ,y - PLATFORM_HEIGHT);
    }

    public CollisionProcessing getCollisionProcessing() {
        return collision;
    }
}

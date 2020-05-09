package com.unicorngames.dodgethis.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Box {

    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private static Texture texture;

    float x,y;

    public Box(float x, float y) {
        this.x = x;
        this.y = y;
        texture = new Texture("box.png");
    }

    public void update (float deltaTime) {

    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

}

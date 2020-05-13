package com.unicorngames.dodgethis.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    Texture background;

    public Background() {
        background = new Texture("background.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(background ,0, 0);
    }

}

package com.unicorngames.dodgethis.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TreeTexture {

    float x;
    float y;

    public TreeTexture(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(new Texture("tree.png"), x, y, 56 * 3, 80 * 3);
    }
}

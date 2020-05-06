package com.unicorngames.dodgethis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Level1 {
    Texture floor;
    Vector2 floorpos;
    int speed = 3;

    public Level1() {
        floor = new Texture("floor.png");
        floorpos = new Vector2(0 ,215);
    }
    public void render(SpriteBatch batch) {
        batch.draw(floor, floorpos.x, floorpos.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            floorpos.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            floorpos.x -= speed;
        }
    }
}

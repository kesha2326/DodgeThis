package com.unicorngames.dodgethis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    Texture skin;
    Vector2 position;
    public int difficulty = 3;
    int vy = 0;
    int gravity = 1;

    public Player() {
        skin = new Texture("snake.jpg");
        position = new Vector2(500-15,250);
    }

    public void render(SpriteBatch batch) { //render method for drawing objects on the screen
        batch.draw(skin,position.x,position.y);
    }

    public void update() { //Method for math of the player
        //WASD movement realisation
//        if (Gdx.input.isKeyPressed(Input.Keys.W) && position.y == 0) {
//
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.S) && position.y > 0) {
//            position.y -= difficulty;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.D) && position.x < 970) {
//            position.x += difficulty;
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.A) && position.x > 0) {
//            position.x -= difficulty;
//        }
    }
}

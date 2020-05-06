package com.unicorngames.dodgethis;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.security.Key;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public int posx = 0, posy = 0;
	public int speed = 3;
	public int vy = 0, vyspeed = 1;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("snake.jpg");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, posx, posy);
		batch.end();
	}

	public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.W) && posy >= 0) {
            if (posy == 0) {
                vy = 20;
            }
            vy -= vyspeed;
            posy += vy;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && posx > 0) {
            posx -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && posx < 970-1) {
            posx += speed;
        }
	}
//	public void jump() {
//        vy = 10;
//    }

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

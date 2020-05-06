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
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		player.render(batch);
		batch.end();
	}

	public void update() {
		player.update();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

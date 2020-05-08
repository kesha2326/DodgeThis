package com.unicorngames.dodgethis;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.unicorngames.dodgethis.screens.MainMenuScreen;

public class DodgeThis extends Game {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;

	public SpriteBatch batch;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
        this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}

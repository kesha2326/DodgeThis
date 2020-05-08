package com.unicorngames.dodgethis.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.I18NBundleLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.unicorngames.dodgethis.DodgeThis;

public class MainGameScreen implements Screen {

    DodgeThis dodgeThis;

    Texture tx;
    public int cubex = 0;
    public int cubey = 0;

    public MainGameScreen(DodgeThis dodgeThis) {
        this.dodgeThis = dodgeThis;
        tx = new Texture("snake.jpg");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        dodgeThis.batch.begin();

        dodgeThis.batch.draw(tx, cubex, cubey);

        if (Gdx.input.isKeyPressed(Input.Keys.W) && cubey < dodgeThis.HEIGHT - 30) {
            cubey += 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && cubey > 0) {
            cubey -= 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) && cubex > 0) {
            cubex -= 4;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) && cubex < dodgeThis.WIDTH - 30) {
            cubex += 4;
        }

        dodgeThis.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

package com.unicorngames.dodgethis.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.unicorngames.dodgethis.DodgeThis;

public class MainMenuScreen implements Screen {

    private static final int PLAY_BUTTON_WIDTH = 420;
    private static final int PLAY_BUTTON_HEIGHT = 150;
    private static final int EXIT_BUTTON_WIDTH = 390;
    private static final int EXIT_BUTTON_HEIGHT = 150;

    DodgeThis dodgeThis;

    Texture playButtonInactive;
    Texture playButtonActive;
    Texture exitButtonInactive;
    Texture exitButtonActive;

    public MainMenuScreen(DodgeThis dodgeThis) {
        this.dodgeThis = dodgeThis;
        playButtonInactive = new Texture("play_button_inactive.png");
        playButtonActive = new Texture("play_button_active.png");
        exitButtonInactive = new Texture("exit_button_inactive.png");
        exitButtonActive = new Texture("exit_button_active.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        dodgeThis.batch.begin();

        if (Gdx.input.getX() < dodgeThis.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2 || Gdx.input.getX() > dodgeThis.WIDTH / 2 + PLAY_BUTTON_WIDTH / 2 || Gdx.input.getY() < 150 || Gdx.input.getY() > 150 + PLAY_BUTTON_HEIGHT) { //checks the mouse in play texture diaposone
            dodgeThis.batch.draw(playButtonInactive, dodgeThis.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2, 500);
        } else {
            dodgeThis.batch.draw(playButtonActive, dodgeThis.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2, 500);
            if (Gdx.input.isTouched()) { //checks the mouse click on play button
                this.dispose(); //clear memory of menu screen
                dodgeThis.setScreen(new MainGameScreen(dodgeThis)); //switching on game screen
            }
        }

        if (Gdx.input.getX() < dodgeThis.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2 || Gdx.input.getX() > dodgeThis.WIDTH / 2 + EXIT_BUTTON_WIDTH / 2 || Gdx.input.getY() < 450 || Gdx.input.getY() > 450 + EXIT_BUTTON_HEIGHT) { //checks the mouse in exit texture diaposone
            dodgeThis.batch.draw(exitButtonInactive, dodgeThis.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2, 200);
        } else {
            dodgeThis.batch.draw(exitButtonActive, dodgeThis.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2, 200);
            if (Gdx.input.isTouched()){ //checks the mouse click on exit button
                Gdx.app.exit();
            }
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

package com.unicorngames.dodgethis.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.unicorngames.dodgethis.DodgeThis;

public class MainGameScreen implements Screen {

    public static float SPEED = 200;

    public static final float WALKING_ANIMATION_SPEED = 0.3f;
    public static final int PERSON_WIDTH_PIXELS = 35;
    public static final int PERSON_HEIGHT_PIXELS = 70;

    Animation walkAnimation;
    TextureRegion[] walkFrames;

    float x;
    float y;
    float stateTime;

    DodgeThis dodgeThis;

    public MainGameScreen(DodgeThis dodgeThis) {
        this.dodgeThis = dodgeThis;
        x = dodgeThis.WIDTH / 2 - PERSON_WIDTH_PIXELS - 2;
        y = 100;

        TextureRegion[][] textureSpriteSheet = TextureRegion.split(new Texture("person_walking.png"), PERSON_WIDTH_PIXELS, PERSON_HEIGHT_PIXELS);
        walkFrames = new TextureRegion[7];

        for (int i = 0; i <7 ; i++) {
                walkFrames[i] = textureSpriteSheet[0][i];
        }
        walkAnimation = new Animation(WALKING_ANIMATION_SPEED, walkFrames);
        stateTime = 0f;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        stateTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        dodgeThis.batch.begin();

        dodgeThis.batch.draw((TextureRegion) walkAnimation.getKeyFrame(stateTime, true), 50, 50);

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

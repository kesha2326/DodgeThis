package com.unicorngames.dodgethis.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.unicorngames.dodgethis.DodgeThis;
import com.unicorngames.dodgethis.entities.Box;
import com.unicorngames.dodgethis.entities.Platforms;
import com.unicorngames.dodgethis.tools.CollisionProcessing;

public class MainGameScreen implements Screen {

    public static float SPEED = 200;

    public static final float WALKING_ANIMATION_SPEED = 0.3f;
    public static final int PERSON_WIDTH_PIXELS = 35;
    public static final int PERSON_HEIGHT_PIXELS = 70;

    Animation walkLeftAnimation;
    Animation walkRightAnimation;
    TextureRegion[] walkLeftFrames;
    TextureRegion[] walkRightFrames;

    float x;
    float y;
    float stateTime;
    float vy;
    float gravity;
    boolean isJumped;
    boolean onPlatform;

    DodgeThis dodgeThis;
    Box box;
    CollisionProcessing collision;
    Platforms platforms;

    public MainGameScreen(DodgeThis dodgeThis) {
        this.dodgeThis = dodgeThis;
        x = dodgeThis.WIDTH / 2 - PERSON_WIDTH_PIXELS - 2;
        y = 200;

        gravity = 0.7f;
        vy = 0;
        isJumped = false;
        onPlatform = true;

        box = new Box(700, 200);
        collision = new CollisionProcessing(x, y, PERSON_WIDTH_PIXELS, PERSON_HEIGHT_PIXELS);
        platforms = new Platforms(0, 200);

        TextureRegion[][] textureSpriteSheet = TextureRegion.split(new Texture("person_walking.png"), PERSON_WIDTH_PIXELS, PERSON_HEIGHT_PIXELS);
        walkLeftFrames = new TextureRegion[4];
        walkRightFrames = new TextureRegion[4];
        for (int i = 0; i <3 ; i++) {
                walkLeftFrames[i] = textureSpriteSheet[0][i];
            walkRightFrames[i] = textureSpriteSheet[0][i+4];
        }

        walkLeftFrames[3] = textureSpriteSheet[0][1];
        walkRightFrames[3] = textureSpriteSheet[0][5];
        walkLeftAnimation = new Animation(WALKING_ANIMATION_SPEED, walkLeftFrames);
        walkRightAnimation = new Animation(WALKING_ANIMATION_SPEED, walkRightFrames);

        stateTime = 0f;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        stateTime += Gdx.graphics.getDeltaTime();
        collision.move(x, y);

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        dodgeThis.batch.begin();

        //drawing objects
        dodgeThis.batch.draw(new Texture("tree.png"), platforms.x, platforms.y, 56 * 3, 80 * 3);
        platforms.render(dodgeThis.batch);
        box.render(dodgeThis.batch);


        if (isJumped) { // Jump realisation (checking under person platform y + platform height)
            vy -= gravity;
            y += vy;
            if (y < platforms.y + platforms.getPLATFORM_HEIGHT()) {
                isJumped = false;
                y = platforms.y + platforms.getPLATFORM_HEIGHT();
            }
        }

        //person moving

        if (Gdx.input.isKeyPressed(Input.Keys.W) && y == platforms.y) {
            System.out.println(platforms.y);
            // onPlatform = false;
            //isJumped = true;
            //vy += 15;
        }

        //moving right, and if we have box collision, pushing the box
        if (Gdx.input.isKeyPressed(Input.Keys.D) && x + PERSON_WIDTH_PIXELS < dodgeThis.WIDTH) {
            //box & person collision checking
            if(getCollisionProcessing().collidesWith(box.getCollisionProcessing()) && x + PERSON_WIDTH_PIXELS < box.x + 4 && x + PERSON_WIDTH_PIXELS > box.x) {
                box.x += SPEED * Gdx.graphics.getDeltaTime();
            }
            x += SPEED * Gdx.graphics.getDeltaTime();
            dodgeThis.batch.draw((TextureRegion) walkRightAnimation.getKeyFrame(stateTime, true), x, y);
        }

        //moving left, and if we have box collision, pushing the box
        else if (Gdx.input.isKeyPressed(Input.Keys.A) && x > 0) {
            //box & person collision checking
            if(getCollisionProcessing().collidesWith(box.getCollisionProcessing()) && x > box.x + box.WIDTH - 4 && x < box.x + box.WIDTH) {
                box.x -= SPEED * Gdx.graphics.getDeltaTime();
            }
            x -= SPEED * Gdx.graphics.getDeltaTime();
            dodgeThis.batch.draw((TextureRegion) walkLeftAnimation.getKeyFrame(stateTime, true), x, y);

        } else {
            dodgeThis.batch.draw(new Texture("person_staying.png"), x, y);
        }

        dodgeThis.batch.end();
    }
    public CollisionProcessing getCollisionProcessing() {
        return collision;
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

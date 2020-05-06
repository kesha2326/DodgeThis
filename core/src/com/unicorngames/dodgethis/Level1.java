package com.unicorngames.dodgethis;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Level1 {
    class Platform {

        private Texture tx;
        private Vector2 pos;

        public Platform(Vector2 pos) {
            tx = new Texture("grass_platform.png");
            this.pos = pos;
        }
    }

    private int speed;
    Platform[] platform;

    public Level1() {
        speed = 3;
        platform = new Platform[3];
        platform[0] = new Platform(new Vector2(-1000,200));
        platform[1] = new Platform(new Vector2(0,200));
        platform[2] = new Platform(new Vector2(1000,200));
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i <platform.length; i++) {
            batch.draw(platform[i].tx, platform[i].pos.x, platform[i].pos.y);
        }
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            for (int i = 0; i < platform.length; i++) {
                platform[i].pos.x += speed;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            for (int i = 0; i < platform.length; i++) {
                platform[i].pos.x -= speed;
            }
        }

        if (platform[1].pos.x > 1000 || platform[1].pos.x < -1000) {
            platform[0].pos.x = -1000;
            platform[1].pos.x = 0;
            platform[2].pos.x = 1000;
        }
    }
}

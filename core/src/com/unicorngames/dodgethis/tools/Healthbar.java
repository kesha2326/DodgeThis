package com.unicorngames.dodgethis.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Healthbar {

    private static final int WIDTH = 13;
    private static final int HEIGHT = 12;
    private int hWIDTH = WIDTH;
    private int GAME_WIDTH;
    private int GAME_HEIGHT;
    public static int HEARTS = 5;

    Texture hbTexture;

    public Healthbar(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
        hbTexture = new Texture("heart.png");
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < HEARTS; i++) {
            batch.draw(hbTexture, GAME_WIDTH - WIDTH * 2 - hWIDTH * i + 1, GAME_HEIGHT - HEIGHT * 2, WIDTH * 2, HEIGHT * 2);
        }
    }
}

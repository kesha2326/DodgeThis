package com.unicorngames.dodgethis.tools;

public class CollisionProcessing {

    float x, y;
    int width, height;

    public CollisionProcessing(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this. height = height;
    }

    public void move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean collidesWith(CollisionProcessing collision) {
        return x < collision.x + collision.width && y < collision.y + collision.height && x + width > collision.x && y + height > collision.y;
    }
}

package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

public class Bullet extends GameObject {
    public Bullet (double x, double y, Direction direction) {
        super (x,y);
        if (direction == Direction.UP) {
            dy = -1;
        } else {
            dy = 1;
        }
        setMatrix (ShapeMatrix.BULLET);
    }

    private int dy;
    public boolean isAlive = true;

    public void move () {
        y += dy;
    }
}

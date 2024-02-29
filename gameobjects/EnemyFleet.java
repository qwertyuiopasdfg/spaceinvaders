package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    public EnemyFleet () {
        createShips();
    }
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;
    private void createShips (){
        ships = new ArrayList<EnemyShip>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip((x * STEP), (y * STEP + 12)));
            }
        }
    }
    public void draw (Game game) {
        for (EnemyShip ship : ships) {
            ship.draw (game);
        }
    }

    private double getLeftBorder () {
        double space = SpaceInvadersGame.WIDTH;
        for (GameObject ship : ships) {
            if (ship.x < space)
                space = ship.x;
        }
        return space;
    }
    private double getRightBorder () {
        double space = 0;
        for (GameObject ship : ships) {
            if ((ship.x+ship.width) > space)
                space = ship.x+ship.width;
        }
        return space;
    }

    private double getSpeed () {
        double speed = 2.0;
        double speed2 = 3.0 / ships.size();
        if (speed2<speed) {
            speed = speed2;
        }
        return speed;
    }

    public void move () {

        if (ships.isEmpty()) {
            return;
        }
        Direction currentDirection = direction;
        if (direction == Direction.LEFT && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            currentDirection = Direction.DOWN;
            /*for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN, speed);
            }*/
        }
        else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            currentDirection = Direction.DOWN;
            /*for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN, speed);
            }*/
        }
        double speed = getSpeed();
            for (EnemyShip ship : ships) {
                ship.move(currentDirection, speed);
            }
    }

    public Bullet fire (Game game) {
        if (ships.isEmpty()) {
            return null;
        }
        int kubik1 = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);

        if (kubik1 > 0) {
            return null;
        } else {
            int kubikAction = game.getRandomNumber(ships.size());
            return ships.get(kubikAction).fire();
        }
    }
}


package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;


public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;

    @Override
    public void initialize () {

        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    private void createGame () {
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        drawScene();
        setTurnTimer(40);
    }
    private void drawScene () {
        drawField();
        enemyFleet.draw(this);
        for (Bullet bullet : enemyBullets) {
            bullet.draw(this);
        }
    }
    private void drawField () {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx (y, x, Color.DARKBLUE, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }
    private void createStars () {
        stars = new ArrayList<>();
        /*for (int i = 0; i < 8; i++) {
            stars.add (new Star (getRandomNumber(HEIGHT), getRandomNumber(WIDTH)));
        }*/
        //starList = new ArrayList<Star>();
        stars.add (new Star (6,1));
        stars.add (new Star (38,3));
        stars.add (new Star (57,4));
        stars.add (new Star (21,2));
        stars.add (new Star (41,4));
        stars.add (new Star (17,2));
        stars.add (new Star (31,1));
        stars.add (new Star (45,1));
    }
    @Override

    public void onTurn(int step) {
        check();
        moveSpaceObjects();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }
        drawScene();
    }
    private void moveSpaceObjects () {
        enemyFleet.move();
        /*for (Bullet bullet : enemyBullets) {
            bullet.move();
        }*/
        enemyBullets.forEach(bullet -> bullet.move());
    }

    private void removeDeadBullets () {
        enemyBullets.removeIf(bullet -> bullet.isAlive==false || bullet.y >= HEIGHT-1);
    }

    private void check () {
        removeDeadBullets();
    }
}

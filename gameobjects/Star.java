package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;
//import com.javarush.engine.cell.Game;

public class Star extends GameObject {

    private static final String STAR_SIGN = "\u2605";
    public Star (double x, double y) {
      super (x, y);
    }
    public void draw (Game game) {
        game.setCellValueEx ((int) x, (int) y, Color.NONE, STAR_SIGN, Color.BURLYWOOD, 100);
    }
}

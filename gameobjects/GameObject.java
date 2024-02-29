package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;
//import com.javarush.engine.cell.Game;

public class GameObject {
    public double x;
    public double y;
    public GameObject (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int height;
    public int width;

    public int [][] matrix;

    public void setMatrix (int[][] matrix) {
        this.matrix = matrix;
        width = this.matrix[0].length;
        height = this.matrix.length;
    }

    public void draw (Game game) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                game.setCellValueEx((int) (x+j), (int) (y+i), Color.values()[matrix[i][j]], "");
            }
        }
    }
}

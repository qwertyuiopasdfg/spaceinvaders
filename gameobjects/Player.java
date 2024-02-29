package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.*;
//import com.javarush.games.spaceinvaders.Playerref;
public class Player {
    public double x;
    public double y;
    public double z;
    public Color color;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
       // setStaticView
       //for (int i = 0; i < ; i++) {

        //}(Playerref.REF);
    }

    public void draw(Game game) {

        game.setCellValueEx((int) x, (int) y, Color.WHITE, "");
    }

    public void drawX (Game game) {
        game.setCellValueEx((int) x, (int) y, Color.AQUA, "");
    }

    public int path(Player player, Player playerT, Player Xplayer) {

        int sl = (int) player.x - (int) playerT.x /*64*/ + (int) Xplayer.y;
        return sl; /*1*/
    }

    public int puth(Player player, Player playerT, Player Xplayer) {
        //double po = player.x - player.y * 0.9;

        double p0 = /*(int) ( (Xplayer.x + playerT.y) - po );*/ (playerT.x - Xplayer.x + player.y) - 1; // = 0 когда 0 - победа. playerT.x-Xplayer.x+player.y = 1; playerTx+playerT

        //int y_9 = player.x*1.0 - player.y*0,9ж   (playerT.y + 1;) winwinwin
        return -1 - (int) p0; // /*0*/ -playerT.x + Xpla
    }

    public int grow(int puth) {
        /*if puth > path {
            path++
        }*/
        //int puth = path ()
        int path = 0;
        if (puth < path) {
            puth++;
            //return puth;
        }
        return puth;
    }

    //-playerT.x-player.x = player.x - playerT.x
    //player.x = 0;
    //playerT.y = -1
}

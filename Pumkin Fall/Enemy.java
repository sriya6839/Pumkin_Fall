package com.brainmentors.gamimg.sprites.sprites;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    public int x,y,w,h;
int speed;
  ImageIcon image;

    public Enemy(int x,int speed){
        y=400;
       this. x=x;
       this. speed=speed;
        w=285;
        h=270;
       image= new ImageIcon(Enemy.class.getResource("pf1.gif"));


    }
    public void draw (Graphics pen) {

        pen.drawImage(image.getImage(), x, y, w, h, null);
    }
public void move(){
        if(y>550){
            y=0;
        }
        y=y+speed;
}
}

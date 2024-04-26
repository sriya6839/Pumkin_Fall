package com.brainmentors.gaming;
import java.awt.*;
import java.util.*;
import com.brainmentors.gamimg.sprites.Players;
import com.brainmentors.gamimg.sprites.sprites.Enemy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Timer;

public class Board  extends JPanel {
    Timer timer;
   BufferedImage backgroundImage;
   Players players;
   Enemy enemies[]=new Enemy[4];
    public Board(){

        setSize(1500,1500);
        loadBackgroundImage();
        players =new Players();
        loadEnemies();
        gameLoop();

        bindEvents();
        setFocusable(true);


    }
    private void loadEnemies(){
        int x=400;
        int gap=250;
        int speed=0;
        for(int i=0;i<enemies.length;i++){
            enemies[i]=new Enemy(x,speed);
            x=x+gap;
           speed=speed+2;
        }
    }
    private void gameOver(Graphics pen){
        if(players.outOfScreen()){
            pen.setFont(new Font("times",Font.BOLD,60));
            pen.setColor(Color.GREEN);
            pen.drawString("You win ",750,750);
          timer.stop();
        }
        for(Enemy enemy : enemies){
            if(isCollide(enemy)){
                pen.setFont(new Font("times",Font.BOLD,40));
                pen.setColor(Color.GREEN);
                pen.drawString("YOU ARE DEAD",650,650);
              timer.stop();
            }
        }
    }
    private boolean isCollide(Enemy enemy){
        int xDistance=Math.abs(players.x-enemy.x);
        int yDistance=Math.abs(players.y-enemy.y);
        int maxH=Math.max(players.h,enemy.h);
        int maxW=Math.max(players.w,enemy.w);
        return xDistance<=maxW-400&&yDistance<=maxH-450;
    }

    private void bindEvents(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    players.speed = 14;
                } else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
                    players.speed=-2;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                players.speed=0;
            }
        });
    }


    private void gameLoop(){
        timer=new Timer(30,(e)->repaint());

        timer.start();
    }

    private void loadBackgroundImage() {
        try {
           backgroundImage = ImageIO.read(Board.class.getResource("halloween.jpg"));
        } catch (Exception e) {
            System.out.println("Background image not found..");
            System.exit(1);
            e.printStackTrace();
        }
    }
    private void printEnemies(Graphics pen){
        for(Enemy enemy:enemies){
            enemy.draw(pen);
            enemy.move();
        }
    }
    public void paintComponent(Graphics pen){
        super.paintComponent(pen);// clean up
          pen.drawImage(backgroundImage,0,0,1950,820,null);
          players.draw(pen);
          players.move();
          printEnemies(pen);
          gameOver(pen);

    }
}

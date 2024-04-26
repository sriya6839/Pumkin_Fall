package com.brainmentors.gaming;

import javax.swing.*;
import javax.swing.JFrame;
public class GameFrame extends JFrame{
    public GameFrame(){
        Board board=new Board();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("graveyard");
        setResizable(false);
        setSize(1800,1200);
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);
    }
    public static void main(String[] args) {
        GameFrame gf=new GameFrame();
        //gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // gf.setResizable(false);
        // gf.setSize(900,700);
        // gf.setLocationRelativeTo(null);
        // gf.setVisible(true);
    }
}

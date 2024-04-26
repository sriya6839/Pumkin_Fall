package com.brainmentors.gamimg.sprites.sprites;

import javax.swing.*;
import java.awt.*;

public class Players {
    int x,y,w,h;
    ImageIcon image;
  public Players(){
      w=100;
      h=100;
      x=100;
      y=100;
     // URL imageUrl = getClass().getResource("/path/to/your/image.png");
     // ImageIcon imageIcon = new ImageIcon(imageUrl);

      image =new ImageIcon((Players.class.getResource("player.gif")));

  }
  public void draw(Graphics pen){
      pen.drawImage(image.getImage(),x,y,w,h,null);

  }
}

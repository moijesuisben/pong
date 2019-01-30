import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Pong extends PApplet {

int x, y;
int deplacementX, deplacementY;
int w, z;

public void setup (){
  
  background(0);
  z = 60;
  w = 15;
  deplacementY = -3;
  deplacementX = 6;
  y = 200;
  x = 200;
}

public void draw () {
  nettoyer();
  dessiner();
  bouger();
  rebondir();
}

public void nettoyer () {
  background(0xff072963);
}

public void dessiner (){
  rect(w,z,25,85);
  smooth();
  ellipse(x,y,20,20);
  line (200,0,200,400);
  fill(0xffb087f5);
}

public void bouger () {
  x = x + deplacementX;
  y = y + deplacementY;
  z = (mouseY);
}

public void rebondir () {
  if (x > width-10 && deplacementX > 0)
  {
    deplacementX = -deplacementX;
   }

  if (y > width-10 && deplacementY > 0)
  {
    deplacementY = -deplacementY;
  }

  if (y < 10 && deplacementY <0)
  {
    deplacementY = abs(deplacementY);
  }

  if (x<w+35 && y>z && y<z+85)
  {
    deplacementX = -deplacementX;
  }

  if (x < 10)
  {
    noLoop();
    println("Tu as perdu");
  }
}
  public void settings() {  size (400,400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Pong" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

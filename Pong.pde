int x, y;
int deplacementX, deplacementY;
int w, z;

void setup (){
  noCursor();
  size (400,400);
  background(0);
  z = 60;
  w = 15;
  deplacementY = -3;
  deplacementX = 6;
  y = 200;
  x = 200;
}

void draw () {
  nettoyer();
  dessiner();
  bouger();
  rebondir();
}

void nettoyer () {
  background(#D34654);
}

void dessiner (){
  noStroke();
  rect(w,z,25,85,8);
  smooth();
  ellipse(x,y,20,20);
  fill(#EBE8E9);
}

void bouger () {
  x = x + deplacementX;
  y = y + deplacementY;
  z = (mouseY);
}

void rebondir () {
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

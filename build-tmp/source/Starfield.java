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

public class Starfield extends PApplet {

Particle[] poops;

public void setup(){	
	background(0);
	size(600,600);
	poops = new Particle[1000];
	for(int i = 0; i<poops.length-1; i++){
		poops[i] = new NormalParticle();
	}
	poops[1] = new JumboParticle();
	poops[poops.length-1] = new OddballParticle();
}
public void draw(){
	fill(0,0,0,10);
	rect(0,0,600,600);
	for(int i = 0; i<poops.length; i++){
		poops[i].move();
		poops[i].show();
	}

}
class NormalParticle implements Particle {
	double myX, myY, myAngle, mySpeed;
	int myColor,mySize;
	NormalParticle(){
		myX = 300;
		myY = 300;
		mySpeed = Math.random()*10;
    	myAngle = Math.random()*2*Math.PI;
		myColor = color(0,(int)(Math.random()*100+100),(int)(Math.random()*100+100));
		mySize = 3;

	}
	public void move(){
		myX += Math.cos(myAngle)*mySpeed;
		myY += Math.sin(myAngle)*mySpeed;
		myAngle += .01f;
	}
	public void show(){
		noStroke();
		fill(myColor);
		ellipse((int)myX,(int)myY,mySize,mySize);
	}
}

class JumboParticle extends NormalParticle {
	JumboParticle(){
		myX = 300;
		myY = 300;
		mySpeed = Math.random()*10;
    	myAngle = Math.random()*Math.PI;
		myColor = color(255);
		mySize = 10;
	}
}
interface Particle {
	public void move();
	public void show();
}
class OddballParticle implements Particle {
	double myX, myY, myAngle, mySpeed;
	int myColor;
    OddballParticle(){
    	myX = 300;
		myY = 300;
		mySpeed = Math.random()*10;
    	myAngle = Math.random()*2*Math.PI;
		myColor = color(0,(int)(Math.random()*100+100),(int)(Math.random()*100+100));
	}
	public void move(){
	   myX = 300 + 200*Math.cos(myAngle);
       myY = 300 + 200*Math.sin(myAngle);
       myAngle+=.01f;
	}
	public void show(){
		fill(myColor);
	   ellipse((int)myX,(int)myY,20,20);
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

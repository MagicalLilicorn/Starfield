Particle[] poops;

void setup(){	
	background(0);
	size(600,600);
	poops = new Particle[1000];
	for(int i = 0; i<999; i++){
		poops[i] = new NormalParticle();
	}
	poops[999] = new OddballParticle();
}
void draw(){
	fill(0,0,0,10);
	rect(0,0,600,600);
	for(int i = 0; i<999; i++){
		poops[i].move();
		poops[i].show();
	}
	poops[999].move();
	poops[999].show();
}
class NormalParticle implements Particle
{
	double myX, myY, myAngle, mySpeed;
	int myColor;
	NormalParticle(){
		myX = 300;
		myY = 300;
		mySpeed = Math.random()*10;
    	myAngle = Math.random()*2*Math.PI;
		myColor = color(0,(int)(Math.random()*100+100),(int)(Math.random()*100+100));
	}
	public void move(){
		myX += Math.cos(myAngle)*mySpeed;
		myY += Math.sin(myAngle)*mySpeed;
		myAngle += .01;
	}
	public void show(){
		noStroke();
		fill(myColor);
		ellipse((int)myX,(int)myY,5,5);
	}
}
interface Particle
{
	public void move();
	public void show();
}
class OddballParticle implements Particle 
{
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
       myAngle+=.01;
	}
	public void show(){
		fill(myColor);
	   ellipse((int)myX,(int)myY,20,20);
	}
}



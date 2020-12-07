import java.awt.Graphics;

public class Paddle {
	
	//1) identify attributes of a paddle
	private int x;
	private int y;
	private int w = 50;
	private int h = 200;
	private int vy = 0;
	
	//2) write a constructor that allows the creation of a paddle object at a given position
	public Paddle (int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	//3) write the getters for the paddle's instance variables
	public int getX() {return x;}
	public int getY() {return y;}
	public int getW() {return w;}
	public int getH() {return h;}
	
	//4) write the setters for the paddle's instance variables
	public void setX(int newX) {x = newX;}
	public void setY(int newY) {y = newY;}
	public void setW(int newW) {w = newW;}
	public void setH(int newH) {h = newH;}
	
	public void moveUp() {
		vy = -20;
	}
	
	public void moveDown() {
		vy = 20;
	}
	
	public void stop() {
		vy = 0;
	}
	
	public void paint(Graphics g) {
		y += vy;
		g.fillRect(x,y,w,h);
	}
	
}

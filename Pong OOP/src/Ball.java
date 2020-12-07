import java.awt.Graphics;
	import java.awt.Rectangle;
	
	public class Ball {
		private int x;
		private int y;
		private int r = 50;
		private int vx;
		private int vy;
		
		//constructor
		public Ball (int newX, int newY) { //accepts new x and y position for ball
			x = newX; //reassigns x value
			y = newY; //reassigns y value
			vx = (int)(Math.random()*(4-3+1))+3;
			vy = (int)(Math.random()*(4-3+1))+3;
		}
		
		//getters
		public int getX() {return x;}
		public int getY() {return y;}
		public int getR() {return r;}
		public int getVx() {return vx;}
		public int getVy() {return vy;}
		
		//setters
		public void setX(int newX) {x = newX;}
		public void setY(int newY) {y = newY;}
		public void setR(int newR) {r = newR;}
		public void setVx(int newVx) {vx = newVx;}
		public void setVy(int newVy) {vy = newVy;}
		
		//paints the ball
		public void paint(Graphics g) { 
			x += vx; //increments x by velocity
			y += vy; //increments y by velocity
			if (y <= 0 || y >= 510) { vy *= -1;} //if exits top or bottom, bounces
			if (x <= 0 || x >= 750) { vx *= -1;} //if exits left or right, bounces
			g.fillOval(x, y, r, r); //draws the ball
		}
		//checks if ball collides with paddle-if yes, x direction reverses
		public void isColliding(Paddle p) { 
			Rectangle r1 = new Rectangle(x,y,r,r); //rectangle of circle
			Rectangle r2 = new Rectangle(p.getX(),p.getY(),p.getW(),p.getH()); //rectangle of paddle
			if (r1.intersects(r2)) { vx *= -1;} //if intersect, x direction reverses
		}
	}

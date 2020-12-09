import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x,y, vx, vy; 
	public int misses = 0; //initializes int misses to 0;
	private Image img; // image of the duck
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	Music soundQuack = new Music("Quack.wav", false);
	
	public Duck() {
		img = getImage("GlassesDuck.png"); //loads image for duck into img
		resetDuck();
		init(x, y); //initialize the location of the image
	}
	
	//resets the duck back to the bottom
	public void resetDuck() {
		x = (int)(Math.random()*(800)-50);  //sets x to random within window
		y = 400; // sets duck y to bottom of screen
		vy = (int)(Math.random()*10)+4; //sets velocity y random from 4 to 13
		vx = (int)(Math.random()*10)+4; //sets velocity x random from 4 to 13
		if (Math.random()<=0.5)vx*=-1; //half the time, velocity is other (negative) direction
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		x += vx; // increment x by x velocity 
		y -= vy; // increment y by y velocity
		if (y <= -50) this.resetDuck(); //if exits top, goes to bottom and resets
		if (x < -50 || x > 750)  vx *= -1; //if exits left or right, bounces
		
		tx.setToTranslation(x,  y); // must call this every time you update x and y
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	//tests if mouse clicked duck - if yes, make duck fall
	public boolean collided (int mX, int mY) {
		System.out.println (mX + ":" + mY); 

		Rectangle hitbox = new Rectangle (x,y,150,150); //defines the duck hitbox
		
		//runs if mouse clicked duck
		if(hitbox.contains (mX, mY)) {
			System.out.println("ouch");
			soundQuack.play(); //play quack sound
			img = getImage("TiltedGlassesDuck.png"); //changes image to tilted duck image
			vx = 0; //duck stops moving horizontally
			vy = -15; //duck starts falling downwards (negative velocity in y)
			return true;
		}
		else misses++; // if didn't click duck, add 1 to misses
		//*************************can you have it say "haha" if it misses only by a little
		return false;
	}
	
	//getter for misses
	public int getMisses() {return misses;}
	
	//resetter for misses
	public void resetMisses() {misses = 0;}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

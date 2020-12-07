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
	private int x = (int)(Math.random()*(700))-49;
	private int y = 400;
	private int vx, vy;
	private int misses = 0;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	Music soundQuack = new Music("Quack.wav", false);

	public Duck() {
		img = getImage("GlassesDuck.png");
		//img = getImage("duck.gif"); //load the image for duck here
		init(x, y); 				//initialize the location of the image
		vy = (int)(Math.random()*3)+3;
		vx = (int)(Math.random()*3)+3;
		if (Math.random()<=0.5)vx*=-1;
	}
	
	public void resetDuck() {
		x = (int)(Math.random()*(800)-50); 
		y = 400;
		vy = (int)(Math.random()*2)+4;
		vx = (int)(Math.random()*2)+4;
		if (Math.random()<=0.5) vx*=-1;
	}
	
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		
		x += vx;
		y -= vy;
		if (y <= -50) this.resetDuck(); //if exits top, goes to bottom
		if (x < -50 || x > 750)  vx *= -1; //if exits left or right, bounces
		//get the bird to move randomly up from the bottom of the screen - it should start at the bottom - make it bounce off of the top and side borders
		
		
			//perform intersection task
		
		tx.setToTranslation(x,  y); //must call this every time you update x and y
		   
	
		
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
	//Music bang = new Music("bang2.wav", false);
	
	public boolean collided (int mX, int mY) {
		System.out.println (mX + ":" + mY);
		
		Rectangle hitbox = new Rectangle (x,y,150,150);
		
		if(hitbox.contains (mX, mY)) {
			System.out.println("ouch");
			soundQuack.play();
			
			//what happens to the duck if hit?!
			//have the duck fall from the sky
			//after a hit
			//play the "bang" sound
		}
		
		//can you have it say "haha" if it misses only by a little
		
		return false;
	}
	
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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Dog {
	private int x = 400,y = 350; //starting dog position
	private int time = 0; //initializes int time to 0
	private Image img1; // first image
	private Image img2; // second dog image
	private Image img; // actual img object
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public Dog() {
		img1 = getImage("dog1.png"); //assigns img1 as dog1.png
		img2 = getImage("dog2.png"); //assigns img2 as dog2.png
		img = img1; //sets img to img1 first
		init(x, y); //initialize the location of the image
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		//every 5 "time units", switches the dog image to simulate laughing
		if (time % 10 >= 5) img = img2; else img = img1;
		//increments time by 1
		time++; 
		g2.drawImage(img, tx, null);  
		tx.setToTranslation(x,  y); //call this every time paint is updated
	}
	
	//getter for the time int
	public int getTime() {return time;}
	
	//setter for the time int
	public void changeTime(int newTime) {time = newTime;}
	
	//resetter for the time int (resets to 0)
	public void resetTime() {time = 0;}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Dog.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}

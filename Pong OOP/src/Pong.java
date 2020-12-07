import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
 
public class Pong extends JPanel implements ActionListener, KeyListener{
 
	//attributes for a Pong frame
	Paddle left = new Paddle(50, 100);
	Paddle right = new Paddle(700,250);
	Ball b = new Ball(300, 250);
 
	public void paint(Graphics g) {
		super.paintComponent(g); //ignore
 
		//ask the objects to draw
		// call their paint method!
		left.paint(g);
		right.paint(g);
		b.paint(g);
	}
	/* update variables */
	/*
	 * update ball x and y here
	 * update all other variables as necessary
	 */
	public void update() {
		b.isColliding(left);
		b.isColliding(right);
	}
 
 
	public static void main(String[] arg) {
		Pong p = new Pong();
	}
 
 
	Timer t = new Timer(16,this);
	//setup frame 
	JFrame f;
	public Pong() {
		//800x600 frame
		int width = 800;
		int height = 600;
 
		//setup frame
		f = new JFrame("P-OOP");
		f.setSize(width,height);		
		t.start();
		f.addKeyListener(this);
		f.add(this);
 
		//make frame visible
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		update();
	}
 
 
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
		
		//switch-case
		switch(arg0.getKeyCode()) {
		case 83: //key code for s
			left.moveDown();
			break;
		case 87: //key code for w
			left.moveUp();
			break;
		case 38: //key code for up arrow
			right.moveUp();
			break;
		case 40: //key code for down arrow
			right.moveDown();
			break;
		}
	}
 
	@Override
	public void keyReleased(KeyEvent e) {
		left.stop();
		right.stop();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
 
	}
 
 
}

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongFrame extends JPanel implements ActionListener, KeyListener{

	//practice declarations and assignments
	int bx = 260;
	int by = 150;
	int bw = 30;
	int bh = 30;
	
	//ball velocity
	int bvx = 3;
	int bvy = 4;			
	
	//score variables
	int p1Score = 0;
	int p2Score = 0;
	
	// declare and assign new variables
	// to represent the two paddles you will
	// see on the screen
	// please use descriptive short names
	int	p1x = 50, p1y = 0, pw = 30, ph = 100; 	//paddle 1 and the width/height
	int	p2x = 500, p2y = 0; 	//paddle 2 and the width/height
										//i can reuse pw and ph 
	
	//font for score
	Font verdana = new Font("Verdana", Font.BOLD,40);
	
	//paint is called 60x per second
	public void paint(Graphics g) {
		   super.paintComponent(g); //do not remove
		   
		   g.setFont(verdana);//set the font
		   //drawing text on the screen + using variables
		   g.drawString(""+p1Score, 150,100);		   
		   g.drawString(""+p2Score, 350,100);		
		   
		   //add code below
		   g.setColor(Color.blue);
		   g.fillOval(bx, by, bw, bh);
		   //position in the x changes based on velocity in the x
		   bx = bx + bvx;
		   by = by + bvy;		   

		  
		   g.fillRect( p1x, p1y, pw, ph);
		   g.fillRect( p2x, p2y, pw, ph);
		   
		  if (by > 339 || by <=0) {
			  bvy *= -1;
		   }
		   
		   if (bx > 555) {
			   bx = 260;
			   bvx *= -1;
			   p1Score++;
		   }
		   
		   if (bx <= 0) {
			   bx = 260;
			   bvx *= -1;
			   p2Score++;
		   }
		   
		   //working on this
		   if (by <= p1y + 100 && by >= p1y ) {
			   if (p1x + 30 == bx) {
					   bvx *= -1;
		   }
		   }
		   if (by <= p2y + 100 && by >= p2y) {
			   if (p2x - 30 == bx) {
			   bvx *= -1;
		   }
		   }
	       // end working on this
		   
		   
		   
		   //to do
		   // add additional if statements and conditions
		   // to detect the top, left, bottom borders
		   
		   
		   //add code above - enter new lines when needed
	} //end of paint curly do not delete

	//do not touch
	public PongFrame(){
		JFrame frame = new JFrame("Pong");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		//setup frame to listen to keyboard presses
		frame.addKeyListener(this);
		
		Timer t = new Timer(16, this);
		t.start();
		
		frame.setVisible(true);
	}//end of MainFrame




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	} //end of actionPerformed curly do not delete

	@Override
	public void keyPressed(KeyEvent e) {
		// print out the keyCode for the current key
		// being pressed
		System.out.println ( e.getKeyCode());
		   if( e.getKeyCode() == 87) {
			   p1y -= 8;
		   }
		   
		   if ( e.getKeyCode() == 83 ) {
			   p1y += 8;
		   }
		   
		   if ( e.getKeyCode() == 38) {
			   p2y -= 8;
		   }
		   
		   if ( e.getKeyCode() == 40) {
			   p2y += 8;
		   }
		
		//detect w key which is 87
		
	
		//try to control 
		
				
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

} //end of class curly - do not delete

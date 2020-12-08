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

	// ball declarations
	int bx = 260, by = 150, bw = 30, bh = 30; // declarations of ball dimensions, and starting position
	int bvx = 3, bvy = 4; // declarations of ball velocity			
	
	//score declarations, intial score is 0
	int p1Score = 0, p2Score = 0;
	
	// paddle declarations
	int pw = 30, ph = 100; // declaration paddle width and height
	int	p1x = 50, p1y = 0; // declaration of paddle 1 starting position
	int	p2x = 500, p2y = 0; // declaration of paddle 2 starting position

	//font for score
	Font verdana = new Font("Verdana", Font.BOLD,40);
	
	//paint is called 60x per second
	public void paint(Graphics g) {
		   super.paintComponent(g);
		   
		   g.setFont(verdana); // setting the font 
		   
		   //drawing text on the screen + using variables
		   g.drawString(""+p1Score, 150,100); //drawing player 1 score
		   g.drawString(""+p2Score, 350,100); //drawing player 2 score
		   
		   g.setColor(Color.blue); //sets color of paddles + ball
		   g.fillOval(bx, by, bw, bh); // drawing the ball 
		   
		   // ball position assignments
		   bx = bx + bvx; // ball x position
		   by = by + bvy; // ball y position

		  // drawing the paddles
		   g.fillRect( p1x, p1y, pw, ph); // drawing paddle 1
		   g.fillRect( p2x, p2y, pw, ph); // drawing paddle 2
		   
		  // testing if ball goes out of up/down boundary, then ball reverses direction (y)
		  if (by > 339 || by <=0) {
			  bvy *= -1;
		   }
		  
		   // testing if ball goes out of right boundary; when it does, xy position is reset, direction is reset, and player 1 score goes up by 1
		   if (bx > 555) {
			   bx = 260; 
			   by = 150;
			   bvx = -3;
			   bvy = 4;			
			   p1Score++;
		   }
		   
		   
		   // testing if ball goes out of left boundary; when it does, xy position is reset, direction is reset, player 2 score goes up by 1
		   if (bx <= 0) {
			   bx = 260;
			   by = 150;
			   bvx = 3;
			   bvy = 4;		
			   p2Score++;
		   }
		   
		   //if the ball hits the left paddle, then ball reverses direction (x) and goes right
		   if (by <= p1y + 100 && by >= p1y ) {
			   if (p1x + 15 == bx) {
					   bvx *= -1;
		   }
		   }
		   
		   //if the ball hits the right paddle, then ball reverses direction (x) and goes left
		   if (by <= p2y + 100 && by >= p2y) {
			   if (p2x - 15 == bx) {
			   bvx *= -1;
		   }
		   }

	} // end paint

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
	} //end of actionPerformed

	@Override
	public void keyPressed(KeyEvent e) {
		// print out the keyCode for the current key
		// being pressed
		System.out.println ( e.getKeyCode()); 
		
		// if w key pressed, left paddle goes up
		   if( e.getKeyCode() == 87) {
			   p1y -= 8;
		   }
		   
		// if s key pressed, left paddle goes down
		   if ( e.getKeyCode() == 83 ) {
			   p1y += 8;
		   }
		   
		// if upArrow key pressed, right paddle goes up
		   if ( e.getKeyCode() == 38) {
			   p2y -= 8;
		   }
		   
		// if downArrow key pressed, right paddle goes down
		   if ( e.getKeyCode() == 40) {
			   p2y += 8;
		   }
	} // end keyPressed

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

} //end of class

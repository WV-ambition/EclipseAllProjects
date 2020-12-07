import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongFrame extends JPanel implements ActionListener{

	//practice declarations and assignments
	int ballx = 260;
	int bally = 150;
	int ballw = 30;
	int ballh = 30;
	
	
	
	//paint is called 60x per second
	public void paint(Graphics g) {
		   super.paintComponent(g); //do not remove
		   
		   //add code below
		   g.setColor(Color.blue);
		   
		   ballx++; //++ operator increments val of var by 1
		   bally++;
		   g.fillOval(ballx,bally,ballw,ballh);
		   
		   //drawing a rectangle
		 int ax = 50, ay = 0, w = 30, ah = 100;
		 
		 ax = 10;
		 ay = 10;
		 w = 10;
		 ah = 10;
		 
		   g.fillRect(ax,ay,w,ah);
		int bx, by, bh;
		bx = 10;
		by = 10;
		bh = 10;
		   g.fillRect(bx,by,w,bh);
		   
		   //add code above - enter new lines when needed
		   
	} //end of paint curly do not delete

	


	
	
	
	
	
	
	//do not touch
	public PongFrame(){
		JFrame frame = new JFrame("Pong");
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		Timer t = new Timer(16, this);
		t.start();
		frame.setVisible(true);
	}//end of MainFrame




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	} //end of actionPerformed curly do not delete

} //end of class curly - do not delete

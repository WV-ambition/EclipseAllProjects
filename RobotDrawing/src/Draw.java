import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Draw extends JPanel implements ActionListener{
	
	public void paint(Graphics g) {
		
		
		super.paintComponent(g); //do not remove
		
		g.drawRect(10,10,960,600);
		int x1 = 10;
		int y1 = 610;
		int x2 = 970;
		int y2 = 610;
		
		for(int x=1; x<=60;x++) {
			x1+=16;
			y2 -=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 970;
		y1 = 610;
		x2 = 10;
		y2 = 610;
		
		for(int x=1; x<=60;x++) {
			x1-=16;
			y2 -=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 970;
		y1 = 10;
		x2 = 10;
		y2 = 10;
		
		for(int x=1; x<=60;x++) {
			x1-=16;
			y2 +=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 10;
		y1 = 10;
		x2 = 970;
		y2 = 10;
		
		for(int x=1; x<=60;x++) {
			x1+=16;
			y2 +=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		
		
		
		
		
		
		g.drawRect(250,160,480,300);
		
		x1 = 250;
		y1 = 460;
		x2 = 730; 
		y2 = 460; 
		
		for(int x=1; x<=30;x++) {
			x1+=16;
			y2-=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 730; 
		y1 = 460; 
		x2 = 250; 
		y2 = 460; 
		
		for(int x=1; x<=30;x++) {
			x1-=16;
			y2-=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 730;
		y1 = 160;
		x2 = 250;
		y2 = 160;
		
		for(int x=1; x<=30;x++) {
			x1-=16; 
			y2 +=10; 
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 250;
		y1 = 160;
		x2 = 730;
		y2 = 160;
		
		for(int x=1; x<=30;x++) {
			x1+=16;
			y2 +=10; 
			g.drawLine(x1, y1, x2, y2);
		} 
		
		
		
		
		
		
g.drawRect(370,235,240,150);
		
		x1 = 370;;
		y1 = 385;;
		x2 = 610;;
		y2 = 385;;
		
		for(int x=1; x<=15;x++) {
			x1+=16;
			y2-=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 610;; 
		y1 = 385;;
		x2 = 370;;
		y2 = 385;;
		
		for(int x=1; x<=15;x++) {
			x1-=16;
			y2-=10;
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 610;;
		y1 = 235;;
		x2 = 370;;
		y2 = 235;;
		
		for(int x=1; x<=15;x++) {
			x1-=16; 
			y2 +=10; 
			g.drawLine(x1, y1, x2, y2);
		}
		
		x1 = 370;;
		y1 = 235;;
		x2 = 610;;
		y2 = 235;;
		
		for(int x=1; x<=15;x++) {
			x1+=16;
			y2 +=10; 
			g.drawLine(x1, y1, x2, y2);
		}
		
	}
	//do not touch
	public Draw(){
		JFrame frame = new JFrame("Pong");
		frame.setSize(1000,660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);

		//Timer t = new Timer(16, this);
	//	t.start();
		frame.setVisible(true);
	}//end of MainFrame




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	} //end of actionPerformed curly do not delete

} //end of class curly - do not delete



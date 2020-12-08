import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	public boolean paintDog = false;
	//Objects that need to be drawn on the JFrame in the paint method.
	// 1) write the code to create a Ground object as one of your instance variables
	Ground foreground = new Ground();
	
	// 2) try the same thing with the Tree class
	Tree tree = new Tree();
	Duck duck = new Duck();
	Duck duck2 = new Duck();
	Dog dog = new Dog();
	
	//create music sound class
	Music soundBang = new Music("Clang.wav", false);
	Music soundQuack = new Music("Quack.wav", false);
	
	public void paint(Graphics g) {
		//invoke the paint methods of the foreground and tree objects
		super.paintComponent(g);
		//tree.paint(g);
		duck.paint(g);
		duck2.paint(g);
		foreground.paint(g);
		if (duck.getMisses() % 3 == 0 && duck.getMisses() != 0)  {dog.paint(g);}
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
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
		soundBang.play(); //plays soundBang
		int mouseX = arg0.getX();
		int mouseY = arg0.getY();
		
		//send mouse x and y to the duck object's
		//collision code
		duck.collided(mouseX, mouseY);
		duck2.collided(mouseX, mouseY);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}

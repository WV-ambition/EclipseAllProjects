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
	public int misses, time;
	//create the foreground, tree, ducks, and dog objects
	Ground foreground = new Ground();
	Tree tree = new Tree();
	Duck duck = new Duck();
	Duck duck2 = new Duck();
	Dog dog = new Dog();
	
	//create music sounds
	Music soundBang = new Music("Clang.wav", false);
	Music soundQuack = new Music("Quack.wav", false);
	Music soundHaha = new Music("haha.wav", false);
	
	public void paint(Graphics g) {
		//invoke the paint methods of the foreground and tree objects
		super.paintComponent(g);
		tree.paint(g);
		duck.paint(g);
		duck2.paint(g);
		foreground.paint(g);
		
		misses = duck.getMisses();
		time = dog.getTime();
		if (misses == 3 && time < 100) paintDog = true;
		else if (time >= 100) {
			duck.resetMisses(); 
			dog.resetTime();
			paintDog = false;
		}
		if (paintDog == true) dog.paint(g);
	}
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	//creates the frame of the application
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

	@Override //when mouse pressed, play bang and run collision check / action
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		soundBang.play(); //plays soundBang
		int mouseX = arg0.getX(); //get mouse x coordinate
		int mouseY = arg0.getY(); //get mouse y coordinate
	
		duck.collided(mouseX, mouseY); //check if mouse clicked duck, and perform action
		duck2.collided(mouseX, mouseY); //check if mouse clicked duck2, and perform action
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override //if an action is performed, refresh paint
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}

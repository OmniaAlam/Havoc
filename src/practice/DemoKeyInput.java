package practice;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class DemoKeyInput extends JPanel implements KeyListener {

	/**
	 * Create the panel.
	 */
	int x=100,y=100;
	public DemoKeyInput() {
		setFocusable(true);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		g.drawRect(20, 20, 100, 100);
		g.drawOval(x, y, x+50,y+50 );
	}//paint
	
	void go(){
		JFrame f=new JFrame("scroll");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		
	//	this.requestFocus();
		addKeyListener(this);
		this.add(new JButton("sad"));
		
		f.getContentPane().add(this);
		
		f.setVisible(true);
	}
	
	public static void main(String []args){
		try {
			  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
			  System.out.println("Error setting native LAF: " + e);
			}
			
		new DemoKeyInput().go();
	}//main


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x+=20;
			System.out.println("Right");
			repaint();
		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

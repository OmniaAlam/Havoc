package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainGame.GameTest;
import mainGame.Util;

public class AboutMenu extends JPanel {
	public static void main (String args[]){
		Util.changeLookAndFill();
		JFrame f=new JFrame();
		f.setSize(1024,768);
		f.getContentPane().add(new AboutMenu());
		f.setVisible(true);

	}

	// super.paintComponent(g);
			 Image i;
			
			@Override 
			 public void paintComponent(Graphics g){
				
				
			
					 g.drawImage(new ImageIcon("images/menu/about.jpg").getImage(),0,0,null);
			}

	/**
	 * Create the panel.
	 */
	public AboutMenu() {
		setLayout(null);
		
		JButton exit = new JButton("Back");
		exit.setFont(new Font("Vijaya", Font.BOLD | Font.ITALIC, 52));
		exit.setForeground(new Color(173, 216, 230));
		exit.setBackground(Color.BLACK);
		exit.setBounds(826, 401, 128, 45);
		add(exit);
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					   GameTest.f.remove(GameTest.about);
					   GameTest.f.add(GameTest.menu);
					   GameTest.f.validate();
					   GameTest.f.repaint();
					   
					  
				
			}
			   
			 
			  });

	}

}

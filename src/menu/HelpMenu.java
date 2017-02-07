package menu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainGame.GameTest;
import mainGame.Util;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelpMenu extends JPanel {

	public static void main (String args[]){
		Util.changeLookAndFill();
		JFrame f=new JFrame();
		f.setSize(1024,768);
		f.getContentPane().add(new HelpMenu());
		f.setVisible(true);

	}
	// super.paintComponent(g);
		 Image i=new ImageIcon("images/menu/help.jpg").getImage();
		
		@Override 
		 public void paintComponent(Graphics g){
			
			
					 if(i==null)
					System.out.println("jkkjk");
			 else 
				 g.drawImage(i,0,0,null);

    
 }	
		
		public static boolean isCalledFromResumeMenu=false;
		
	/**
	 * Create the panel.
	 */
	public HelpMenu() {
		setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				GameTest.f.remove(GameTest.help);
				if(isCalledFromResumeMenu)
				
				GameTest.f.getContentPane().add(GameTest.resume);
				else
					GameTest.f.getContentPane().add(GameTest.menu);
					
				GameTest.f.validate();
				GameTest.f.repaint();
			
			
			}
		});
		btnBack.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		btnBack.setForeground(new Color(175, 238, 238));
		btnBack.setBounds(730, 272, 177, 48);
		add(btnBack);

	}
}

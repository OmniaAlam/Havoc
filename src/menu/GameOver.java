package menu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import mainGame.GameTest;
import mainGame.Util;

public class GameOver extends JPanel {
	public static void main (String args[]){
		Util.changeLookAndFill();
		JFrame f=new JFrame();
		f.setSize(1024,768);
		f.getContentPane().add(new GameOver());
		f.setVisible(true);

	}

	// super.paintComponent(g);
			 Image i=new ImageIcon("images/menu/gameover.jpg").getImage();
			
			@Override 
			 public void paintComponent(Graphics g){
				
			
					 g.drawImage(i,0,0,null);
			}/**
	 * Create the panel.
	 */
			JButton backtomainmenu;			
	public GameOver() {
	setLayout(null);
	
	 backtomainmenu = new JButton("Back to Main Menu");
	backtomainmenu.setHorizontalAlignment(SwingConstants.LEADING);
	backtomainmenu.setFont(new Font("Vivaldi", Font.PLAIN, 38));
	backtomainmenu.setForeground(new Color(153, 204, 204));
	backtomainmenu.setBackground(new Color(0, 0, 0));
	backtomainmenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	
		
		GameTest.f.remove(GameTest.over);
			GameTest.f.add(GameTest.menu);
			GameTest.f.validate();
			GameTest.f.repaint();
			//GameTest.newGameClicked=false;//already done
		
		}
	});
	backtomainmenu.setBounds(628, 644, 350, 46);
	add(backtomainmenu);
	
	JLabel lblGameOver = new JLabel("GAME  OVER");
	lblGameOver.setFont(new Font("Old English Text MT", Font.BOLD | Font.ITALIC, 50));
	lblGameOver.setBackground(new Color(0, 0, 0));
	lblGameOver.setForeground(new Color(153, 204, 204));
	lblGameOver.setBounds(311, 40, 530, 59);
	add(lblGameOver);

	}
}

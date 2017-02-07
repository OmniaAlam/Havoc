package menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainGame.GameTest;
import mainGame.Util;


public class Menu extends JPanel {
	
	public static void main (String args[]){
		Util.changeLookAndFill();
		JFrame f=new JFrame();
		f.setSize(1024,768);
		f.getContentPane().add(new Menu());
		f.setVisible(true);

	}
	// super.paintComponent(g);
		 Image i=new ImageIcon("images/menu/mainmenu.jpg").getImage();
		
		@Override 
		 public void paintComponent(Graphics g){
			
			
					 if(i==null)
					System.out.println("jkkjk");
			 else 
				 g.drawImage(i,0,0,null);

    
 }	
	public Menu() {
		
		//change cursor
	this.setCursor( getToolkit().createCustomCursor(new ImageIcon("images/menu/blue_cursor.png").getImage(), new Point(0,0), "BatCursor"));
		//this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		setLayout(null);
		
		JButton play = new JButton("Play");
		play.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		play.setForeground(new Color(153, 204, 204));
		play.setBackground(new Color(0, 0, 0));
		play.setBounds(717, 84, 223, 60);
		add(play);
		
		JButton settings = new JButton("Settings");
		settings.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 46));
		settings.setForeground(new Color(153, 204, 204));
		settings.setBackground(new Color(0, 0, 0));
		settings.setBounds(717, 178, 223, 60);
		add(settings);
		
		JButton btnAbout = new JButton("About");
	
		btnAbout.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		btnAbout.setForeground(new Color(153, 204, 204));
		btnAbout.setBackground(new Color(0, 0, 0));
		btnAbout.setBounds(717, 389, 223, 60);
		add(btnAbout);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setForeground(new Color(153, 204, 204));
		btnHelp.setBackground(new Color(0, 0, 0));
		btnHelp.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		btnHelp.setBounds(717, 282, 223, 66);
		add(btnHelp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(153, 204, 204));
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnExit.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		btnExit.setBounds(717, 500, 223, 60);
		add(btnExit);
	
		ImageIcon icon=new ImageIcon("images/newgame.jpg");
		//Image a=new ImageIcon("halloween/menu.jpg").getImage();
		
	   
   
	/**
	 * Create the panel.
	 */
	
		//*******************************************************
				//code for listeners   
		/**********************************************************/	
				play.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
					GameTest.f.remove(GameTest.menu);
					GameTest.f.validate();
					GameTest.f.repaint();
					GameTest.f.requestFocusInWindow();
					
					GameTest.newGameClicked=true;
					GameTest.gameOn=true;
					GameTest.gameIsNotPaused=true;
					GameTest.Score=0;
					GameTest.currentLevel=1;
					}
					
				});//play button
				
				settings.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						SettingPanel.isCalledFromResumeMenu=false;
						GameTest.f.remove(GameTest.menu);
						GameTest.f.getContentPane().add(GameTest.setting);
						GameTest.f.validate();
						GameTest.f.repaint();
					}
					
				});//s
				
				btnAbout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
							GameTest.f.remove(GameTest.menu);
							GameTest.f.getContentPane().add(GameTest.about);
							GameTest.f.validate();
							GameTest.f.repaint();
					
					
					
					}
				});//about
				btnHelp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						HelpMenu.isCalledFromResumeMenu=false;
						GameTest.f.remove(GameTest.menu);
						GameTest.f.getContentPane().add(GameTest.help);
						GameTest.f.validate();
						GameTest.f.repaint();
				
					}
				});//help
	}
}

package menu;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import mainGame.GameTest;
import mainGame.Util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class ResumeMenu extends JPanel {

	public static void main (String args[]){
		Util.changeLookAndFill();
		JFrame f=new JFrame();
		f.setSize(1024,768);
		f.getContentPane().add(new ResumeMenu());
		f.setVisible(true);

	}
	// super.paintComponent(g);
	 Image i=new ImageIcon("images/menu/resume.jpg").getImage();

	@Override 
	 public void paintComponent(Graphics g){
		
		
	
			 g.drawImage(i,0,0,null);

    
 }	
	
	
	
	/**
	 * Create the panel.
	 */
	public ResumeMenu() {
		setLayout(null);
		
		JButton resume = new JButton(new ImageIcon("images/menupics/cntinue.png"));
		resume.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		resume.setText("Resume");
		resume.setForeground(new Color(0, 204, 0));
	
		resume.setBackground(Color.BLACK);
		resume.setBounds(162, 434, 220, 53);
		add(resume);
		
		JButton settings = new JButton(new ImageIcon("images/menupics/ldg.png"));
		settings.setText("Settings");
		settings.setForeground(new Color(0, 204, 0));
		settings.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
	
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingPanel.isCalledFromResumeMenu=true;
				GameTest.f.remove(GameTest.resume);
				GameTest.f.getContentPane().add(GameTest.setting);
				GameTest.f.validate();
				GameTest.f.repaint();
		
			}
		});
		settings.setBackground(Color.BLACK);
		settings.setBounds(144, 562, 262, 53);
		add(settings);
		
		JButton help = new JButton(new ImageIcon("images/menupics/save.png"));
		help.setText("Help");
		help.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		help.setForeground(new Color(0, 204, 0));
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpMenu.isCalledFromResumeMenu=true;
				GameTest.f.remove(GameTest.resume);
				GameTest.f.getContentPane().add(GameTest.help);
				GameTest.f.validate();
				GameTest.f.repaint();
		
			
			}
		});
		help.setBackground(Color.BLACK);
		help.setBounds(179, 498, 200, 53);
		add(help);
		
		JButton back = new JButton(new ImageIcon("images/menupics/back.png"));
		back.setText("Back to Main Menu");
		back.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 52));
		back.setForeground(new Color(0, 204, 0));
		
		back.setBackground(Color.BLACK);
		back.setBounds(42, 626, 531, 53);
		add(back);
//////////////////lisener code//////////////////////
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameTest.f.remove(GameTest.resume);
				GameTest.f.validate();
				GameTest.f.repaint();
				GameTest.f.requestFocusInWindow();
				GameTest.gameIsNotPaused=true;//resume the current game
			
			}
			
		});//resume
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GameTest.f.remove(GameTest.resume);
					GameTest.f.add(GameTest.menu);
					GameTest.f.validate();
					GameTest.f.repaint();
					GameTest.newGameClicked=false;//close this game
					GameTest.gameOn=false;
			}
		});	//back
	}
}

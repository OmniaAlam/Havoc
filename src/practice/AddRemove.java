package practice;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import screen.FullScreen;

public class AddRemove {

	FullScreen f;
	JPanel mainPanel;
	JPanel menuPanel;
	JPanel settingPanel;
	JButton setting,back,exit;
	
	AddRemove(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				init();
				
				
			}
		});
		
	
	}
	
void init(){
	 f=new FullScreen();
	 f.setToFullScreen(new DisplayMode(1024,768,32,DisplayMode.REFRESH_RATE_UNKNOWN));
	
	
	 
	 
	
	 setting=new JButton("Settings");
	 setting.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e){
			 mainPanel.remove(menuPanel);
			 mainPanel.add(settingPanel);
			 mainPanel.revalidate();
			 mainPanel.repaint();
		 }
	 });
	 
	 back=new JButton("back");
	 
	 back.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e){
			 mainPanel.remove(settingPanel);
			 mainPanel.add(menuPanel);
			 mainPanel.revalidate();
			 mainPanel.repaint();
		 }
	 });
	 
	 exit=new JButton("Exit");
	 exit.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		 
	 });
	 
	
	 
//setting	 
	 settingPanel=new JPanel();
	 settingPanel.add(back);
//mainpanel
	 mainPanel=new JPanel();
	 menuPanel=new JPanel();
	 menuPanel.add(setting);
	
	 mainPanel.add(menuPanel);
	 menuPanel.add(exit);
	f.add(mainPanel);
	//f.add(BorderLayout.SOUTH,exit);
}
	

/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	AddRemove a=new AddRemove();
	
	try{
		while(true){
			Thread.sleep(1500);
		}
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		a.f.restoreScreen();
	}
		

	}

}

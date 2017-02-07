package practice;

import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import screen.FullScreen;

public class HavocDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final FullScreen  f=new FullScreen();
		final JButton play=new JButton("Play");
		final JButton exit=new JButton("exit");
		play.setFocusable(false);
		exit.setFocusable(false);
		
		final JPanel p=new JPanel();
		p.add(exit);
		p.add(play);
		
		play.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("play clicked");
				f.remove(p);
				f.add(new JPanel().add(new JButton("lsdhflshl")));
				
				
				f.validate();
				f.repaint();
				
			}
			
		});
		
		
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		
	try{
			try {
				SwingUtilities.invokeAndWait(new Runnable(){
					public void run(){
						
						
						f.getContentPane().setLayout(new FlowLayout());
						//f.setFocusable(true);
						//f.requestFocus();
						f.setIgnoreRepaint(false);
						f.add(p);
						
						//f.add(play);
						f.setToFullScreen(new DisplayMode(1280,720,32,DisplayMode.REFRESH_RATE_UNKNOWN));
						//f.add(exit);
						
					}//run
				});
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		
		while(true){
		//	Graphics2D g=f.getPaintGraphics();
			
			
		//	f.paintComponents(g);
			//f.bs.show();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	
	
	
	}
	finally{
		f.restoreScreen();
	}
	}

}

package practice;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;

/**this class set the screen to a fullscreen mode
 * 
 * @author USER
 *
 */

public class ScreenManager {
			
		GraphicsDevice gd; //interface to video card.set displaymode	
	
		ScreenManager(){
			GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();//needs to instantiate device
			
			gd=ge.getDefaultScreenDevice();// return device
			
		}//const

/**
Enters full screen mode and changes the display mode.
*/
	public void setToFullScreen(JFrame f,DisplayMode dm){
		//	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setUndecorated(true);
			f.setResizable(false);
			
		//set this frame to fullscreen
			gd.setFullScreenWindow(f);
			
			if(dm!=null && gd.isDisplayChangeSupported())
			
					try{
							gd.setDisplayMode(dm);//change display mode with specified height,width,bit rate and reresh rate
					}catch(IllegalArgumentException e) {e.getStackTrace();  };
			
			
	}//full
	
	 /**
    Restores the screen's display mode.
*/
	public void restoreScreen() {
		Window window = gd.getFullScreenWindow();
			if (window != null) {
				window.dispose();
			}
    gd.setFullScreenWindow(null);
}//restore screen

}//class
			
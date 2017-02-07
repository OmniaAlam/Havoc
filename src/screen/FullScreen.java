package screen;

import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class FullScreen extends JFrame {

	/**
	 * this class make the working window full screen
	 * setDisplayMode() takes resoulation,color bit and refressh rate and switch
	 * the display to this mode.main method test the  class
	 * this is where the entire game will be played
	 */
	 private	GraphicsDevice gd;
	public BufferStrategy bs;

	
//constructor	
	public FullScreen(){
		GraphicsEnvironment e=GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd= e.getDefaultScreenDevice();//get the video card
	
	}//const ends
	
	
//methods
	/**setfullScreen() sets this frame to fullscreen with displaymode*/
public void setToFullScreen(DisplayMode dm){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);//remove titles for bigger drwing surface
		setIgnoreRepaint(true);	//prevent OS from calling paint()
		setResizable(false);//if resized Paint will be called results hazard
	/*	
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
					System.exit(0);
			
			}
		});//screen is undecorated so ESC is assigned to exit the program
*/
		
		if(gd.isFullScreenSupported())//check if video card support fullscrren
					gd.setFullScreenWindow(this);//set this frame to full scrreen
		//now attemt to change displaymode
			if(dm!=null && gd.isDisplayChangeSupported()){
					
				
				try{
						gd.setDisplayMode(dm);
				}catch(IllegalArgumentException e){ 
					System.out.println("cant set DisplayMode") ;
					e.printStackTrace();
					}//catch
					
			}//if
		
			
	}//setscreen end
	



/**restoreScreen() dispose the fullscreen and resotore the screen*/

public void restoreScreen(){
	Window w=gd.getFullScreenWindow();//get this fullscreen window
	if(w!=null )
		w.dispose();//frees memory
	gd.setFullScreenWindow(null);//
}//restore


/**
 * this method returns the graphic object that is needed to draw on this 
 * full screen screen
 * @return
 */
public Graphics2D getPaintGraphics(){
Window w=gd.getFullScreenWindow();
	
	if(w!=null){
		w.createBufferStrategy(2);//no of buffer to perform PF/DB
	 bs=w.getBufferStrategy(); //get BS of this full screen
		/**
		 * BufferStrategy creates a 'g' which enables page flipping and
		 * double buffering on need.that results faster rendering 
		 */
		return (Graphics2D) bs.getDrawGraphics();
		
	}//if 
		
	return null;
	
}//getGraphics
	

/**height and width of this frame is required by the tile maps and other method*/
/*
public  int getScreenWidth(){
	return getWidth();
	}//getwidth
public  int getScreenHeight(){
	return getHeight();
	}//getHeight end
*/
}//class



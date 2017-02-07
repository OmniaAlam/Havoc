package practice;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;

/** this class is a used to create custom buttons with gradient color
 the button is round rectangled
 */

public class GameButton extends JButton {

	int x,y,h,w,arcH,arcW;//variables for the rounded cornered rectangle
	Color c1,c2;
	/**
	 * the constructor  takes a name and setfilledarea true
	 */
	
	public GameButton(){
		super();
		c1=Color.BLUE;
		c2=c1.brighter();
	}//P.less const
	
	public GameButton(String name){
		super(name);//name of the button
		setContentAreaFilled(false);//makes the button opaque cause setOpaque dosent work for jbutton
	//	this.setOpaque(false); 
		setFocusPainted(false);//hide the borders around the name
		
		 c1=Color.BLUE;
		c2=Color.cyan;
	}//
	public GameButton(String name,Color startingColor,Color endColor){
		this(name); 
		c1=startingColor;
		c2=endColor;
	}
	
/**override paintComponent to make the button more colorfull
 * using gradientPaint	
 */
	@Override
	
	public void paintComponent(Graphics g){
		
			Graphics2D g2=(Graphics2D)g.create();//create()-copy of g's cast into g2.so if we dispose g2 it wont be a problem
		/**g2 is needed to draw gradient color/gradient color is simply
		 * 	shaded color.first 2 arguments takes starting color position
		 * and 4,5 takes coordinates for ending color position.
		 * joining the line if it's vertical then the starting color
		 * starts to shaded towards the end color vertically
		 * in the constructor we use top-left of the button and top right
		 */
			g2.setPaint(new GradientPaint(0,0,c1,0,getHeight(),c2));
		
			//draw the rectangle equal to the button with the color
		//	g2.fillRoundRect(x, y, getWidth(), getHeight(), arcW, arcH);
			g2.fillRect(x, y, getWidth(), getHeight());
			super.paintComponent(g);//this is needed to paint other non-standerd comp. like the name on it 
			
			g2.dispose();
	}//paint end
	
	
	
	
	
	//main method tests the button
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    final JFrame frame = new JFrame("Gradient JButton Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(new GameButton("New Game",Color.GREEN,Color.yellow));
      //  frame.add(new GameButton());
        frame.setSize(500, 500); // used for demonstration
        //frame.pack();
       frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}//main

}//class

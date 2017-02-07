package characters;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import mainGame.GameConstants;
import mainGame.Util;

/**
 * a simple class that holds the common characteristics of an object
 * @author USER every object has its x and y coordinate.which is the drawing TOP-LEFT
 * corner of the image.
 *the class holds these.so that no need to write them for every other obeject class
 */
public  class GameObjects implements GameConstants {
/**
 * image's top-left corner's x value.where the image of this object is drawn
 */
	public int x;
/**
 * image's top-left corner's y value.where the image of this object is drawn
 */
	public int y;
/**
 * image of this object
 */
	public Image pic;
	
/**
 * class name of the object
 */
	private String class_name="GameObjects";

	protected GameObjects(){
			 }
	
	
	protected GameObjects(int x,int y,String className){
			this.x=x;
			this.y=y;
			
			setClassName(className);
			
	}

	 protected GameObjects(Image img,String className){
		 pic=img;
		
		 setClassName(className);
		 
	 }
	 public GameObjects(int x,int y,Image img,String className){
			
		 this(x,y,className);
		 pic=img;
	}
	 
/**
 * draw the image of this object with its x and y coordinate	 
 * @param g graphics 2fd object by which the image is drawn
 */
	public void draw(Graphics2D g){
		if(pic!=null && isVisible())
		g.drawImage(pic, x, y, null);
		
	
		
		//g.drawString(" x "+x+" y "+y, x, y);
	}
	
	
	
public boolean isVisible(){
	if((x>=0 && x<=SCREEN_WIDTH) || (x<=0 && x+getWidth()>=0) ) 
		return true;
	
	else return false;
}
	
public boolean isFullyVisible(){
	if(x>=0 && x+getWidth()<=SCREEN_WIDTH)
		return true;
	else return false;
}



public void scroll(int speed,int direction){
	x+=speed*direction;
}


/**
 * returns the width of the pic	
 * @return pic's width
 */

public int getWidth(){
	if(pic!=null)
	return pic.getWidth(null);
	
	return 0;
}

public int getHeight(){
	if(pic!=null)
	return pic.getHeight(null);
	
	return 0;
}
	
/**
 * sets the image of this sprite
 * @param path image file path that represents the sprite
 */
public void setImage(String path){
	pic=Util.getImage(path);
}//setimage
	
	
	
	

public boolean intersects(Sprite s){
	Rectangle br=new Rectangle(x,y,getWidth(),getHeight()); 
	Rectangle sr=new Rectangle(s.x,s.y,s.getWidth(),s.getHeight()); 
	
	if(br.intersects(sr))
	return true;
	
	
	return false;
}//intersext
	
	
	
	/**
	 * sets the classname of the object
	 * @param name class name of the object
	 */
	public void setClassName(String name){
		if(name!=null)
		class_name=name;
	}//setClassName
	
/**
 * returns the class Name of this object	
 * @return
 */
public String getClassName(){
	return class_name;
}
	
}//class

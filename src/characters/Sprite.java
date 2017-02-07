package characters;

import static mainGame.Util.getViewX;
import static mainGame.Util.getY;

import java.awt.Image;

import mainGame.AllImages;
import mainGame.AllSounds;



public class Sprite extends GameObjects implements AllImages,AllSounds {

	
		
	public int r;
/**
 * tile index of column on which the sprite was first drawn i.e. in the textmap
 * */
	public int c;
	
/**
 * speed of movement	
 */
protected byte xSpeed;	
protected byte ySpeed;
public int life;
public int health;
int hitRate;
	
//********************* CONSTRUCTORS ****************************/	
	public Sprite(int i,int j,Image img,String className,byte xSpeed,byte ySpeed,int LIFE,int HitRate){
		this(i,j,img,className,xSpeed,ySpeed);
		this.life=LIFE;
		this.hitRate=HitRate;
	}//1st constructor
	
	public Sprite(int i,int j,Image img,String className,byte xSpeed,byte ySpeed){
		this(i,j,img,className);
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
		
	}//1st constructor	

public Sprite(int i,int j,String imagePath){
//	System.out.println("i "+i+" j "+j);

	setTile(i,j);
	
	setImage(imagePath);
	
	x=getViewX(j);
	y=getY(i+1)-pic.getHeight(null);//place the image above the tile underneath it
	//System.out.println("i "+this.i+" j "+this.j);
}//2nd constructor

public Sprite(int i,int j,Image img,String className){

	super(img,className);
	setTile(i,j);
	x=getViewX(j);
	y=getY(i+1)-pic.getHeight(null);//place the image above the tile underneath it
	
	
	
}


/**
	 * sets the sprite on this tile
	 * @param x index of the tile's row
	 * @param y index of the tile's collum
	 */
	public void setTile(int i,int j){
	//	System.out.println("x "+x+" y "+y);
		r=i;
		c=j;
	
	//	System.out.println("i "+i+" j "+j);
	}//

	


	
/*******************THESE METHODS ARE OVERRIDEN BY THE SUBCLASSES FOR DMP****************/	
	
	boolean isJumping;
	
 void move(){
		
	}
 public void allCalculation(){
		
}
	

public void jump(){
	
}
public void doThingsForHit(){
	
}
}//sprite

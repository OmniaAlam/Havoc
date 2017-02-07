package characters;

import java.awt.Image;

public class Enemy extends Sprite {
	
	int hitpoints;
//	byte moveSpeed;
	
	
	public Enemy(int i,int j,Image img,String className,byte xSpeed,byte ySpeed,int LIFE,int HitRate){
		super(i,j,img,className,xSpeed,ySpeed,LIFE,HitRate);
	}
	
	
	
	public void shoot(){
		
	}
//	void move();
}//

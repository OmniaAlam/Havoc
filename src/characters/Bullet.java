package characters;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bullet extends GameObjects  {
	
	public static CopyOnWriteArrayList<Bullet> list=new CopyOnWriteArrayList<Bullet>();


	/**
	 * x,y reperesents topLeft corner of the bullet image
	 * d is the direction the bullet will move
	 * speed determine how fast that means how many pixel the bullet pass each move
	 */
	public byte d,speed;
	
	
	/**
	 * boolean to determine whether this bullet will hit enemy or player
	 */
	public boolean isThisEnemyBullet;
	
	
//	public static byte playerAim=RIGHT;
	
	/**
	 *create a bullet object with specific direction and speed 
	 * @param x	 represents topLeft corner's x of the bullet image
	 * @param y  represents topLeft corner's y of the bullet image
	 * @param direction the direction to which the bullet will move
	 * @param speed determines how fast that means how many pixel the bullet pass each move
	 * @param img image of this bullet
	 * @param isThisEnemyBullet if this bullet is shoot from enemy then it will be true
	 */
	public Bullet(int x,int y,byte direction,byte speed,Image img,boolean isThisEnemyBullet) {
	
		super(x,y,img,"Bullet");
	
		this.isThisEnemyBullet=isThisEnemyBullet;
	
	
		d=direction;
		this.speed=speed;
		
	
	}//constructor
	
	
	
/**
 * moves bullet with its speed,direction etc	
 */
	public void move(){
			
			
		 if(isVisible()){
				
			 if(d==RIGHT || d==LEFT)	
					x+=speed*d;
			 
			// else if(d==BULLET_CURRENT_DIRECTION)
				// x+=speed*playerAim;
		 
		 
		 
		 
		 }//if
		 
		 
		 //if bullet is out of the screen remove the bullet
		 if(!isVisible()){
			 list.remove(this);
		
		 }
			 //	y+=speed*d;
	}//move
//DDDD	
	





/*

	@Override
	public void draw(Graphics2D g){
		super.draw(g);
		
		
	}*/
	
/**
 * @return the array list that holds all the objects of this class
 */
	public static  CopyOnWriteArrayList<Bullet> getList(){
		return list;
	}
	
	
}//weapons

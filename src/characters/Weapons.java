package characters;

import java.awt.Image;
import java.util.concurrent.CopyOnWriteArrayList;

import mainGame.Sound;


public class Weapons extends GameObjects {
	
	
	  CopyOnWriteArrayList<Bullet> list;
/**
 * determines how fast the projectile is	
 */
int fireRate;

/**
 * boolean that stablish fire rate
 */


boolean weaponReadyToShoot;
/**
 * an integer that increase over time. when its equal to the 100-fireRate then player can shoot
 * 
 */
int fireIt;

public Sound fire;


	public Weapons(int x,int y,Image img,int firingRate){
		super(x,y,img,"Weapons");
		fireRate=firingRate;
		list=Bullet.getList();
	}//1st const
	
	
	public Weapons(int firingRate,Sound sound){
		fireRate=firingRate;
		list=Bullet.getList();
		fire=sound;
	}

	/*
	
	public void shoot(){
		
		if(weaponReadyToShoot){
			
			
		}//if
		
	}//shhoot
	*/
}//weapons

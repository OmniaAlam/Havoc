package characters;

import java.awt.Rectangle;

import mainGame.GameTest;
import mainGame.Sound;
import mainGame.Util;
import screen.Tile;
import screen.TileMap;

public class Player extends Sprite {
	
	
	//public CopyOnWriteArrayList<Bullet> list=new CopyOnWriteArrayList<Bullet>();
	//public Animation RMAnimation; //animation of right movement
	Weapons rifle;
	 //public int life=10;
	/**
	 * player facing direction.needed to animate the player
	 */
	public byte faceDirection=RIGHT;
	
	/**
	 * player constructor takes the
	 * @param i index of row on which the sprite was first drawn i.e. in the textmap
	 * @param j index of column on which the sprite was first drawn i.e. in the textmap
	 * @param imgPath   file Path of the image of this sprite
	 */
	public Player(int i,int j,String imgPath){
		
		super(i,j,imgPath);
		//list=Bullet.getList();
		rifle=new Weapons(PLAYER_BULLET_FIRE_RATE,BULLET_SOUND);
	}
	
	public Player(int i,int j,String imgPath,int life,int health){
		this(i,j,imgPath);
		this.life=life;
		this.health=health;
	}
		

	
	
	
	/**
	 * creates a bullet on the mouth of the weapon
	 */
	//@Override
	/*
	public void shoot(){
		
		
		
		if(rifle.weaponReadyToShoot){
			rifle.list.add(new Bullet(x+112,y+42,RIGHT,PLAYER_BULLET_SPEED,DEFAULT_Player_BULLET_IMAGE,false));
			rifle.fireIt=0;	
			rifle.weaponReadyToShoot=false;
			Sound.bullet();
		}
		

		
		
	}//shoot
*/	
	
	/**
	 * 3 types of key UP,RIGHT,LEFT 
	 * @param directionKEY is the constant that determines the bullet direction
	 */
	public void shoot(byte directionKEY){
		
		
		
		if(rifle.weaponReadyToShoot){
			
			int bX;
			if(this.faceDirection==RIGHT)
				bX=x+110;
			else
				bX=x;
			
			rifle.list.add(new Bullet(bX,y+35,directionKEY,PLAYER_BULLET_SPEED,DEFAULT_Player_BULLET_IMAGE,false));
			
			rifle.fireIt=0;	
			
			rifle.weaponReadyToShoot=false;
			if(GameTest.isSoundOn)
			Sound.play(rifle.fire	);
		}
		

		
		
	}//shoot
		
	public boolean canBePlacedOnTile(){
		//	int x2=x+getWidth();
		
		//System.out.println(i);	
			Tile lt=	TileMap.getTile(r, c);	
			Tile rt=TileMap.getTile(r, c+1);
			
			if( (rt!=null && lt!=null) && (lt.pic!=null || rt.pic!=null)){				
			
				
				//System.out.println("itle"+" row "+t.r+ " colum "+t.c);
			//	System.out.println("player"+" row "+r+ " colum "+c);
				return true;

			}
		 return false;
	}
	
	
	/*
	
	public boolean isOnTile(){
		Tile lt=	TileMap.getTile(r, c);	
		Tile rt=TileMap.getTile(r, c+1);
		
		//System.out.println(rt.r+" "+rt.c+" "+lt.r+" "+lt.c);
		if( (rt!=null && lt!=null) && (lt.pic!=null || rt.pic!=null)){
	 	Rectangle RRect=new Rectangle(rt.x,rt.y,rt.getWidth(),rt.getHeight());
	 	Rectangle LRect=new Rectangle(lt.x,lt.y,lt.getWidth(),lt.getHeight());
	 	
		Rectangle playerRect=new Rectangle(x,y,getWidth(),getHeight());
		
		if(LRect.intersects(playerRect) || RRect.intersects(playerRect))
			return true;
		}
			return false;
	}
	
	
	*/
	public boolean spriteCollision(Sprite s){
		Rectangle pr=new Rectangle(x,y,getWidth(),getHeight()); 
		Rectangle sr=new Rectangle(s.x,s.y,s.getWidth(),s.getHeight()); 
		
		if(pr.intersects(sr))
		return true;
		else
		return false;
	}
	
	
	@Override
	public void jump(){
		
		if(!isJumping && canBePlacedOnTile()){
		isJumping=true;
	
			
		jumpStartedFromThisPixel=y;
		}
	}//jump
	
private	int jumpStartedFromThisPixel;
	/*
private boolean isTilecolide(byte dir){
	if(dir==RIGHT && TileMap.getTile(r-2, c+1)!=null)
		return true;
	else if(dir==LEFT && TileMap.getTile(r-1, c-1)!=null)
			return true;
		
	else	
	return false;
}
*/
/**
 * if the move player is not out of bounds and 	
 * @return
 */
boolean	isMovePossible(byte dir){
	int X=x+SCROLLING_SPEED*dir;
	if(X>=0 && X+getWidth()<=SCREEN_WIDTH  )
		return true;
	
		return false;
	}


public void move(byte direction){
	if(isMovePossible(direction))
	{
		
		x+=direction*SCROLLING_SPEED;
	

	

	}
	Util.calcColum(this);
	Util.calcRow(this);
}


	
public void allCalculations(){
	
	//for(Bullet )
	if(rifle.fireIt==REF-rifle.fireRate)
	rifle.weaponReadyToShoot=true;
	else
		rifle.fireIt++;
	
	
	
	
	Util.calcColum(this);
	Util.calcRow(this);
	
//now jump the player if player press jump key i.e. isjumping=true	

	if(isJumping){
		y-=JUMPING_SPEED;
		
		
		if( y<=jumpStartedFromThisPixel-MAX_HEIGHT_OF_JUMPING)
			isJumping=false;
	}
	
	
		
		
		
//now chek if this sprite can be placed upon a tile	
		if(  !canBePlacedOnTile() && !isJumping && y+getHeight()<SCREEN_HEIGHT )
			y+=PLAYER_FALLING_SPEED;




}//calc
	
}//player

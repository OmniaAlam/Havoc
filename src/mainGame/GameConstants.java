package mainGame;


/**
 * this interface holds the constants that is used by the game.changing the constants
 * changes the tilemap/game behavior
 * @author USER
 *
 */
public interface GameConstants  {
	/**
	 * constant that determines whether the map scroll left
	 */
		 byte LEFT=-1;
		/**
		 * constant that determines whether the map scroll right
		 */
		 byte RIGHT=1;
		/**
		 * constant that determines how many pixel the map scroll in each call
		 */
	 int SCROLLING_SPEED=2;
		
	 /**
	  * null tile images height.it is needed to draw the map
	  */
		int EMPTY_TILE_HEIGHT=100;
		/**
		  * null tile images Width.it is needed to draw the map
		  */
		
		int EMPTY_TILE_WIDTH=100;
		
		/**
		 * width of the full screen
		 */
		int SCREEN_WIDTH=1024;
		
		int SCREEN_HEIGHT=768;
		
		/**
		 * the left most point on screen where player stops and map starts scrolling when 
		 * player moves left
		 */
		 int LEFT_BOUND_OF_MAP_SCORLLING= SCREEN_WIDTH/2/2/2;
		 /**
		  * the right most point on screen where player stops and map starts scrolling
		  * while player is moving right
		  */
		 int  RIGHT_BOUND_OF_MAP_SCROLLING=SCREEN_WIDTH/2;
		 
		 
		 
//players		 
		 /**
		  * determines how much high the player can jump.higher the value
		  * higher player can jump
		  */
				 
		 int MAX_HEIGHT_OF_JUMPING=250;
		 int PLAYER_LIFE=3;
		 int PLAYER_HEALTH=10;
	
		
		 int JUMPING_SPEED=10;
		 byte PLAYER_FALLING_SPEED=10;
		
		 int PLAYER_BULLET_FIRE_RATE=80;	
		 byte PLAYER_BULLET_SPEED=5;
		 
		
//weapons

		 int REF=100;
		 Sound GUN=new Sound("sound/gun.wav");
		  //byte BULLET_CURRENT_DIRECTION=0;
//ghost
		 byte GHOST_XSPEED=1;
		 byte GHOST_YSPEED=2;
		 int LIFE=60;
		 int HITRATE=20;
		 
//skeleton
		 byte SKELETON_XSPEED=1;
		 byte SKELETON_YSPEED=1;
		 
//frank
		 byte FRANK_XSPEED=1;
		 byte FRANK_YSPEED=1;

//zombie
		
		 byte ZOMBIE_XSPEED=1;
		 byte ZOMBIE_YSPEED=1;
	}//class

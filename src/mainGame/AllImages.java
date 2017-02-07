package mainGame;

import java.awt.Image;


public interface AllImages {
 //	BufferedImage DEFAULT_Player_BULLET_IMAGE=loadImage("images/Bullet.png");
//ui 	
 			 Image DEFAULT_Player_BULLET_IMAGE=Util.getImage("images/player/bullet.png");
 			 Image Help=Util.getImage("images/help.png");
 			// Image SCORE=Util.getImage("images/player/score.png");
 			 Image GREEN_HEART=Util.getImage("images/player/button_green_heart.png");
//player
 			 Image PLAYER_RIGHT_STANDING_PIC=Util.getImage("images/player/stand_right.png");
 			 Image PLAYER_LEFT_STANDING_PIC=Util.getImage("images/player/stand_left.png");
 			 
 			 Image PLAYER_LEFT_WALK_IMAGE=Util.getImage("images/player/walk_left.gif");
 			Image PLAYER_RIGHT_WALK_IMAGE=Util.getImage("images/player/walk_right.gif");
 			
 			Image PLAYER_LEFT_FIRE_IMAGE=Util.getImage("images/player/fire_left.gif");
 			Image PLAYER_RIGHT_FIRE_IMAGE=Util.getImage("images/player/fire_right.gif");
 			
 			Image PLAYER_LEFT_JUMP_IMAGE=Util.getImage("images/player/jump_left.gif");
 			Image PLAYER_RIGHT_JUMP_IMAGE=Util.getImage("images/player/jump.gif");
 			Image HEALTH_BAR=Util.getImage("images/player/hpHolder.png");
 //witch
 			Image BUBBLE_BULLET=Util.getImage("images/bullet_blue.png");
 			
}

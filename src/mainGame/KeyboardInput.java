package mainGame;

import static java.awt.event.KeyEvent.VK_DOWN;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_H;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;
import static java.awt.event.KeyEvent.VK_UP;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import screen.FullScreen;
import screen.TileMap;
import characters.Player;

public class KeyboardInput implements KeyListener , GameConstants,AllImages {
Player p;
TileMap map;
FullScreen f;
GameTest game;


/**
 * constructor takes the map which has effect on user keypress
 * @param map map of this game.which also contains the player of this game
 */
	public KeyboardInput(GameTest game){
		this.game=game;
		f=GameTest.f;
		map=game.map;
		p=map.getPlayer();
		
	}
	

boolean jumpKeyPressed;
boolean leftKeyPressed;
boolean rightKeyPressed;
boolean fireKeyPressed;




/**
* proccess the multiple combination of keys and do things for their corrosopondin works	
*/
 void keyProcess(){



 if(leftKeyPressed && jumpKeyPressed && fireKeyPressed){
	p.jump();
	doThingsForLeftKey();
	p.shoot(LEFT);
			//	Bullet.playerAim=LEFT;
				p.faceDirection=LEFT;
				
				//p.pic=PLAYER_LEFT_JUMP_IMAGE;
			//	p.pic=PLAYER_LEFT_FIRE_IMAGE;
				
}

else if(rightKeyPressed && jumpKeyPressed && fireKeyPressed){
	p.jump();
	doThingsForRightKey();
	p.shoot(RIGHT);
	
	//change face direction
	p.faceDirection=RIGHT;
	
//change pic accordin to face direciton
//	p.pic= PLAYER_RIGHT_FIRE_IMAGE;
	
}

 
else if(rightKeyPressed && leftKeyPressed){
	
}


else if(rightKeyPressed && jumpKeyPressed){
	p.jump();
	doThingsForRightKey();

	
	p.faceDirection=RIGHT;

//	p.pic=PLAYER_RIGHT_JUMP_IMAGE;

}//if for jump & right

else if(leftKeyPressed && jumpKeyPressed ){
	p.jump();
	doThingsForLeftKey();
	

	
	p.faceDirection=LEFT;
	
	//p.pic=PLAYER_LEFT_JUMP_IMAGE;

}
else if(leftKeyPressed && fireKeyPressed){
	doThingsForLeftKey();
	
	p.shoot(LEFT);
	

	//change the face
	p.faceDirection=LEFT;
	
	p.pic=PLAYER_LEFT_FIRE_IMAGE;
}

else if(rightKeyPressed && fireKeyPressed){
	doThingsForRightKey();
	p.shoot(RIGHT);

	
	p.faceDirection=RIGHT;
	
	p.pic= PLAYER_RIGHT_FIRE_IMAGE;
}


	
else if( jumpKeyPressed && fireKeyPressed){
			p.jump();
		
			
		p.shoot(p.faceDirection);
		
		
		//	p.pic= PLAYER_RIGHT_FIRE_IMAGE;
			
	}//if for jump & right
	


	else if(rightKeyPressed)
	{
		doThingsForRightKey();

		//change the pic of the player
		p.pic=PLAYER_RIGHT_WALK_IMAGE;
		
		p.faceDirection=RIGHT;
		
	}
	else if(leftKeyPressed){
		

		p.faceDirection=LEFT;
		p.pic=PLAYER_LEFT_WALK_IMAGE;
		doThingsForLeftKey();
		
	}
		
	else if(jumpKeyPressed)
		
	{
	
		//if(p.faceDirection==RIGHT)
		//	p.pic=PLAYER_RIGHT_JUMP_IMAGE;
	//	else
//			if(p.faceDirection==LEFT)
		//		p.pic=PLAYER_LEFT_JUMP_IMAGE;
		
		
		p.jump();
        
	}
 
	else if(fireKeyPressed){
			p.shoot(p.faceDirection);
			
			if(p.faceDirection==RIGHT)
				p.pic=PLAYER_RIGHT_FIRE_IMAGE;
			else	if(p.faceDirection==LEFT)
					p.pic=PLAYER_LEFT_FIRE_IMAGE;
	}
	
 
 //now check if player has to be normaled
 //if left,right,jump,or fire is not pressed then pic=static pic
 	

}//keyProcces()





/**
* left key scrolls map or scroll player
*/
private void doThingsForLeftKey(){

if(map.isScrollPossible(TileMap.LEFT))
map.scroll(TileMap.RIGHT);
else 	p.move(LEFT);

}

/**
* right key scrolls map or scroll player
*/
private void doThingsForRightKey(){

if(map.isScrollPossible(TileMap.RIGHT))
map.scroll(TileMap.LEFT);

else 	p.move(RIGHT);


}	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int x=e.getKeyCode();
		
		switch(x){
			case VK_RIGHT:
				rightKeyPressed=true;
				//change the pic of the player
				p.pic=PLAYER_RIGHT_WALK_IMAGE;
				
				break;
				
				
			case VK_LEFT:
				leftKeyPressed=true;
				//change the pic of the player to left walk
				p.pic=PLAYER_LEFT_WALK_IMAGE;
				
			
				break;
				
			case VK_UP:
			//	p.y-=10;
				break;
				
			case VK_DOWN:
				//p.y+=10;
				break;
			case VK_F:
				fireKeyPressed=true;;
				
		//		if(p.faceDirection==RIGHT)
						//p.pic=PLAYER_RIGHT_FIRE_IMAGE;
	//			else	//if(p.faceDirection==LEFT)
							//p.pic=PLAYER_LEFT_FIRE_IMAGE;

				break;
			case VK_SPACE:
				jumpKeyPressed=true;
				break;
			case VK_H:
				 GameTest.showHelpScreen=true;
				break;
			case VK_ESCAPE://pause the game
				GameTest.gameIsNotPaused=false;
				f.add(GameTest.resume);
				f.validate();
				f.repaint();
			///	System.exit(0);
			//	f.add(comp)
				break;
		default:
				break;
		}//switch
		


		
	
  //keyProcess();


	}//keypressed


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
int x=e.getKeyCode();
		
		switch(x){
			case VK_RIGHT:
				
				
				
				rightKeyPressed=false;
				//change the pic of the player
				p.pic=PLAYER_RIGHT_STANDING_PIC;
				break;
				
				
			case VK_LEFT:
				leftKeyPressed=false;
				//change the pic of the player
				p.pic=PLAYER_LEFT_STANDING_PIC;
				
				break;

			case VK_SPACE:
			
				jumpKeyPressed=false;
				break;
			case VK_F:
				
				fireKeyPressed=false;
				if(p.faceDirection==RIGHT)
					p.pic=PLAYER_RIGHT_STANDING_PIC;
				else	if(p.faceDirection==LEFT)
						p.pic=PLAYER_LEFT_STANDING_PIC;
				break;
			case VK_H:
				GameTest.showHelpScreen=false;

				break;
		default:
				break;
		}//switch
	//	keyProcess();
		
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}

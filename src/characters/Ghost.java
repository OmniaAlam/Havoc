package characters;

import java.awt.Image;
import mainGame.GameTest;
import mainGame.Sound;


public class Ghost extends Enemy {

	public Ghost(int i,int j,Image img,String className,byte xSpeed,byte ySpeed,int LIFE,int HitRate){

	super (i,j,img,className,xSpeed,ySpeed,LIFE,HitRate);
	//System.out.println("x "+x+" y "+y);
	}

	
@Override	
	public void allCalculation(){
	//System.out.println("x "+x+" y "+y);
		if(isVisible())
		{	//Sound.play(WITCH_SOUND);
		move();
		shoot();
		}
		
	}
	

	
 static int bulletRate;
	//hard coded
@Override
public void shoot()
{
	if(bulletRate==500){
		Bullet.getList().add(new Bullet(x,y,LEFT,(byte) 1,BUBBLE_BULLET,true));
	  
		bulletRate=0;
		
		if(GameTest.isSoundOn)
		Sound.play(BULLET_SOUND);
	}
	
	bulletRate++;
	
}


private	byte signX=RIGHT;
@Override
	
	
public	void move()

{
	//	xSpeed=(byte) new Random().nextInt(10);
		
	if ( signX==RIGHT && x>=SCREEN_WIDTH-220 )//working
		
		signX=LEFT;
	
	else if(signX==LEFT && x<20  )
		signX=RIGHT;
	
		 
		 x+=xSpeed*signX;
	
	//System.out.println("after"+x);
		//System.out.println("moved");
	}//move
	
	
	public  void doThingsForHit(){
	
		life=life-hitRate;
		if(life<=0){
			GameTest.Score+=10;
		}
		
		
	}

}//classe

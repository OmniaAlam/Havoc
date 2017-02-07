package characters;

import java.awt.Image;


	public class Frank extends Sprite{
		public Frank(int i,int j,Image img,String className,byte xSpeed,byte ySpeed){
			super(i,j,img,className,xSpeed,ySpeed);
		}
			public void allCalculation()
			{
				if(isVisible()){
					//Sound.play()
				
					move();
				}
			}
			
			byte sign=LEFT;
	public void move()
	{
		
		x+=xSpeed*sign;
		if(x<10){
			sign=RIGHT;
		//pic=rightpic;
		}
	}

	}



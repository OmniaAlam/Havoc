package characters;

import java.awt.Image;


	public class Zombie extends Sprite{
		public Zombie(int i,int j,Image img,String className,byte xSpeed,byte ySpeed){
			super(i,j,img,className,xSpeed,ySpeed);
		}
			public void allCalculation()
			{
				if(isVisible())
					move();
			}
	public void move()
	{
		
		x-=xSpeed;
	}

	}


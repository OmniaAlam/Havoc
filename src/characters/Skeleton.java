package characters;

import java.awt.Image;

public class Skeleton extends Sprite{
	public Skeleton(int i,int j,Image img,String className,byte xSpeed,byte ySpeed){
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

package screen;



import java.awt.Graphics2D;

import mainGame.GameConstants;
import mainGame.Util;
import characters.GameObjects;

public class Tile extends GameObjects implements GameConstants {
	/**
	 * saves the row index of this tile if it is used in an array
	 */
	public int r;
	/**
	 * saves colum index of this tile if used in an array
	 */
	public int c;
	

	
	public Tile(int row,int colum){
		super(Util.getViewX(colum),Util.getY(row),"Tile");

		r=row;
		c=colum;
	//System.out.println("x "+x+" y "+y+" row "+r+" colum "+c);
	}
	
	
	
	/*
	public boolean getCollition(){
		
		return true;
	}
	*/
	@Override
	public int getWidth(){
		
		
		if(pic!=null)
			return super.getWidth();
		else	
			return EMPTY_TILE_WIDTH;
	}//getTileWidth
/*
	@Override
	public void draw(Graphics2D g){
		super.draw(g);
		
		g.drawString("row "+r+"colum "+c, x+50, y+50);
}
*/
@Override
	public int getHeight(){
		if(pic!=null)
			return super.getHeight();
		else
			return EMPTY_TILE_HEIGHT;
		
	}

	
}//TIle

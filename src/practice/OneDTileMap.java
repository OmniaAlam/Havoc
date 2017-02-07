package practice;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class OneDTileMap {
	/**
	 * array that holds all the images of the map
	 */
	Image tile[];	
/**
 * constant that determines whether the map scroll left
 */
	public static final int LEFT=-1;
	/**
	 * constant that determines whether the map scroll right
	 */
	public static final int RIGHT=1;

/**
 * map lop left x/start point of drawing
 */

public int SP;  
/**
starting tile index On screen of the map.map starts to draw from this tile
*/
public int SI;


public OneDTileMap(int width){
		
		tile =new Image[width];
		tile[0]=new ImageIcon("images/grassTile.png").getImage();
		
		
		for(int i=1;i<tile.length;i++)
	
			tile[i]=tile[0];
			
			}

	
	public Image getTile(int index){
		
		return tile[index];
	}
	
	public int getTileWidth(int tile_index){
		if(tile_index>=0 && tile_index<tile.length){
		if(tile[tile_index].getWidth(null)==0)
		return 50;
		
		
			
		return tile[tile_index].getWidth(null);
		}
		else return 0;
	}
	
	/**WE ONLY Draw the ONSCreen tiles.not the entire array.so we use 
	 * 
	 * @param g :drawing graphics of the screen on which the map has to be drawn
	 * @param start_point :x position of the tile map.where the first tile will be drawn
	 * @param end_point :last point/width of the frame
	 * @param first_tile_index :first image tile of the map of the screen
	 */
public void drawMap(Graphics2D g,int start_point,int end_point, int first_tile_index){
	int x=start_point;
	g.drawString("SP "+SP, 0, 400);//
	g.drawString("x "+x, 0, 410);//
	int count=0;//
	for(int i=SI;x<end_point && i<tile.length;i++){
				g.drawImage(tile[i], x, 500, null);
				x+=getTileWidth(i);
				count++;
		}
	g.drawString("x "+x, 0, 420);
	g.drawString("SI "+SI, 0, 430);
	g.drawString("NTD "+count, 0, 440);
	
	
	}
	/**
	 * this method corrects the starting point -SP of drawing of tile map and
	 * starting index  SI of the tile that is drawn first.SP changes as the user
	 * moves right or left.so Sometimes SP has negative value.but if the value is
	 *less then the fist tile image then there is no need to draw the image as
	 *the following image passes the 0 toward negative.so we increment SP with the
	 *first image width and increment SI so the drawing may start from the 
	 *following image.
	 *the reverse thing happen when SP has positive value.in a short  
	 *we want SP a negative value but not less than the SI tile width
	 */
void correctSPandSI(){
		if(SP<-getTileWidth(SI)){ //checking if SP has passed the limit of n. value
			SP+=getTileWidth(SI);
			if(SI<tile.length)//prevents AIOOB exception
			SI++;//increment the image to the next image.
		}//if
		else if(SP>0 && SI>0){ //if SP has Positive value we made it (-) 
			
			SI--;
			SP-=getTileWidth(SI);
		}//else if
			
	}//correction
/**
 * scrolls the tile map left or right 
 * @param direction 
 * takes -1 or +1.if the value is + then map will move right.and if -
 * then will move left.Because we multiplied the dir with the distanceTObe scrolled
 */
 

public void scroll(int direction){
	SP+=5*direction;
	correctSPandSI();
	}//scroll

}//map

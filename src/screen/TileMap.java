package screen;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

import mainGame.GameConstants;
import mainGame.Util;
import characters.Frank;
import characters.GameObjects;
import characters.Ghost;
import characters.Player;
import characters.Skeleton;
import characters.Sprite;
import characters.Zombie;



/**
 * a Tile map which is used by the game.the map is consist of many tiles
 * the loadMap() mehtod parse .txt file into the two array of tiles
 * if the player scrolls map scrolls to the opposite direction
 * dramap method draws the background and the visible tiles on screen
 * no extra/non-visible tiles are drawn
 * @author USER use this in a platform game.constructor takes a txt file
 * which is a map represented by various alphabets.
 */
public class TileMap implements GameConstants {
/**
 * array that represents the map
 */
	private static	Tile tile[][];
/**
 * a single hi res pic that is the background of this tilemap	
 */
Image background;	
	/**
	 * map  left x/start point of drawing of the  first tile on scrreen
	 */

 private  int SP;  
	/**
	*starting tile index On screen of the map.map starts to draw from this tile
	*each array of the 2D array starts to draw from the same index SI
	*/
	public static int SIx,SIy,mapLoaded;
	
	/**
	 * holds the sprite in this map except player
	 */
public	ArrayList<Sprite> sprites;	
public CopyOnWriteArrayList<Sprite> visibleSprites;

public ArrayList<GameObjects> decors;
public ArrayList<GameObjects> visibleDecors;

public static int totalDecors;
private Player player;



	/**
	 * create a complete tile engine with sprites and background etc.
	 * it parse the map into a 2D image array 
	 * @param mapName filepath of the textmap.text map is witten with letters.
	 */
public	TileMap(String mapName){

	
	
	sprites=new ArrayList<Sprite>();
	visibleSprites=new CopyOnWriteArrayList<Sprite>();
	
	decors=new  ArrayList<GameObjects>();
	visibleDecors= new ArrayList<GameObjects> ();
	//make values  0;
	totalDecors=0;
	tile=null;
	mapWidth=0;
	mapHeight=0;
	SIx=0;
	SIy=0;
	SP=0;
	mapLoaded=0;
	test=0;
	mapFirstPixel=0;
	loadMap(mapName);
	
	totalDecors=decors.size();
	//System.out.println(totalDecors);
}//constructor





/**
 * a complex method which takes a normal .txt file in which the entire 
 * map is written by alphabets. each alphabet represents a Sprite or
 * blocks of image.this method parse the  map from the map file to a 2d array
 * which is used by the game
 * @param mapFilePath file path of the map.txt file
 */
private void loadMap(String mapFilePath){


	/**
	 * this arraylist holds the lines that represent the tiles that means
	 * it holds the elements of a single row.also the size
	 * of the list represents the height of the map
	 * and the maximum length of the list represents
	 * the width of the map
	 */
	ArrayList<String> lines=new ArrayList<String>();
	/**
	 * v holds the letters and corresponding images used in this map
	 */
	ArrayList<TextMapTileVariables> v=new ArrayList<TextMapTileVariables>();
	
	/**
	 *list to help parsing the sprite and then add to the sprite list 
	 */
	
	ArrayList<TextMapSpriteVariables> s=new ArrayList<TextMapSpriteVariables>();
	
	BufferedReader r = null;//reader to read the txt file
	/**
	 * flag which is true when the reader is reading the map
	 * tiles.or line is representing the rows of the map
	 * map starts after "START" line.and ends After "END"
	 */
	boolean isLineInsideMap=false;
	//int mapWidth=0;
	char playerRepresentingChar='0';
	String playerImgPath=null;
	
	try {
		String line=null;//string that represents the lines

		 r=new BufferedReader(new FileReader(mapFilePath));
		
		while((line=r.readLine())!=null){

/*********************************************************************************
*finding the background image for this map.string after : is the file path
*********************************************************************************/
			
			if(line.startsWith("BACKGROUND")){
			
				String file=line.substring(line.indexOf(':')+1);//image path is after :
				background=new ImageIcon(file).getImage();
				
			}
			
/*************************************************************************************
 * 	finding the player.Line starts with PLAYER is the player string containing image and and symbol		
 *****************************************************************************************/
			
	
	if(line.startsWith("PLAYER")){
		playerRepresentingChar=	line.charAt(line.indexOf('=')+1);//cause after = sign p is written
		playerImgPath=line.substring(line.indexOf(':')+1);//now the filepath.it's after :
	}//if
			
/**************************************************************************************
 *finding the sprites except the player.Line starts with @ represents sprite definition 			
 *****************************************************************************************/
				if(line.startsWith("@"))
					s.add(new TextMapSpriteVariables(line));
				
/*********************************************************************************
*finding the tile varibles like A,L, which represents an image.adding these to list					
*********************************************************************************/
			if(line.startsWith("#"))
				v.add(new TextMapTileVariables(line));
			
			
			
			
/************************************************************************
 * finding the map on the text file and save the rows of it  int the list
 * ***********************************************************************/		
			if(line.startsWith("START")){
					isLineInsideMap=true;//"START"'s following lines represents map
					continue;
				}
				else if(line.startsWith("END")){
					isLineInsideMap=false;
					break;//map is done read.so loop is broken
				}
				else if(isLineInsideMap){
					lines.add(line);//add this line/row to the list
				
					mapWidth=Math.max(mapWidth, line.length());//get the maximum length 
				}//else

			
		}//while
		
		r.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//assign image to the array with specific tile
	
/**
 * construct the 2d array which represents the map with
 * the height and width of the textfile's map	
 */
	mapHeight=lines.size();
		tile=new Tile[mapHeight][mapWidth];
/*************************************************
 * initialize 2d array of tile		
 *******************************************************/
		for(int i=0;i<mapHeight;i++)
			for(int j=0;j<mapWidth;j++)
			tile[i][j]=new Tile(i,j);	
		
		
		
		
	//System.out.println(lines.size()+"  "+mapWidth);	
int row=0;	

/****************************************************************************
 * now arraylist "lines" holds only the lines of the map.every character in a 
 * line represents either a tile or a Sprite.Here these are processed i.e. assinging
 * them to their corresponding variables.Sprites are added to the spritelist
 * of this map.and their positions are also set according to the map.tiles are
 * assigned to the tile array.
 ***************************************************************************/
	for(String line:lines){ //assign each line of the list
		//System.out.println(line+row);
		for(int i=0;i<line.length();i++){
	/*****************************************************************
	 * 		finidng the player
	 **************************************************************/
			if(line.charAt(i)==	playerRepresentingChar)
			{
				player=new Player(row,i,playerImgPath,PLAYER_LIFE,PLAYER_HEALTH);
			//	System.out.println("r "+row+" col "+i);
			}
			
			
/*************************************************************************
 * 			parsing tiles
 *************************************************************************/
			for(TextMapTileVariables var:v){
			if(line.charAt(i)==var.c)//check if the tile matches the specified tile
				
				tile[row][i].pic=var.pic;
			
		
			}//for
/*************************************************************************
 * parsing the sprites except player			
 ************************************************************************/
//now check if the letter matches the sprites
			for(TextMapSpriteVariables sp:s){
				if(line.charAt(i)==sp.c){
					addSprite(sp,row,i);
				}//if
					
			}//for
			
			
		}//inner for
		row++;
	}//outer
	mapLoaded=100;	
}//parse map







/**
 * inner class to parse the sprites on the text map
 * @author USER
 *
 */

private class TextMapSpriteVariables {
	Image pic;
	char c;
	/**
	 * class name of this sprite
	 */
	String className;
	String imgPath;
	
	 TextMapSpriteVariables(String line){
		
		
/******************************************************************************
 * 	separate the alphabet,class name and the path of the image and assign them to the members	
 ********************************************************************************/
		for(int i=0;i<line.length();i++){
			
			if(line.charAt(i)=='@')
				c=line.charAt(i+1);//assign the tile letter in c
			else if(line.charAt(i)=='=')
				className=line.substring(i+1, line.indexOf(':'));
			else if(line.charAt(i)==':'){
				 imgPath=line.substring(i+1);//the path is after : sign
				 break;
			}//else
		}//if
		
	
		pic=Util.getImage(imgPath);//assign the image for this letter
	
	//	System.out.println(imgPath);
		//if(pic==null)
			//throw new IllegalArgumentException("pic did'nt found.please specify the path correctly for variable "+c);
			//if(pic==null)
				//System.out.println("the Sprite cant be load chek path "+line);
			
		test++;
	}//constructor
}

 
  



/**
 * the letters used in the text file has corresponding images.this class
 * constructor takes the line and assign the letter in c and
 * the image in pic
 * @author USER it is used in assiging the 2d array.when the list containing
 * this class objects.and cheks the maps letter with this class c
 */

public static int test;
private class TextMapTileVariables{
	Image pic;
	char c;
	
	
	 TextMapTileVariables(String line){
		String filePath=null;
		
/******************************************************************************
 * 	separate the alphabet and the path of the image and assign them to the members	
 ********************************************************************************/
		for(int i=0;i<line.length();i++){
			
			if(line.charAt(i)=='#')
				c=line.charAt(i+1);//assign the tile letter in c
			
			else if(line.charAt(i)==':'){
				 filePath=line.substring(i+1);//the path is after : sign
				 break;
			}//else
		}//if
		
		//System.out.println(filePath);
		pic=Util.getImage(filePath);//assign the image for this letter
		
		
		//if(pic==null)
			//System.out.println("the tile cant be load chek path "+line);
		
		test++;
	}//constructor
}//textmapvaribles end



/**add Sprites accordin to their class in their SuperClass Sprite list */
private void addSprite(TextMapSpriteVariables sp,int row,int colum){
	Sprite s=null;
	GameObjects dec=null;
	
	if(sp.className.equals("Ghost"))
		s=new Ghost(row,colum,sp.pic,"Ghost",GHOST_XSPEED,GHOST_YSPEED,LIFE,HITRATE);
	
	else if(sp.className.equals("Skeleton"))
		s=new Skeleton(row,colum,sp.pic,"Skeleton",SKELETON_XSPEED,SKELETON_YSPEED);
	
	else if(sp.className.equals("Frank"))
		s=new Frank(row,colum,sp.pic,"Frank",FRANK_XSPEED,FRANK_YSPEED);
	
	else if(sp.className.equals("Zombie"))
		s=new Zombie(row,colum,sp.pic,"Zombie",ZOMBIE_XSPEED,ZOMBIE_YSPEED);
	
	
	else	if(sp.className.equals("Decor"))
		
		dec=new GameObjects(Util.getViewX(colum), (Util.getY(row+1)-sp.pic.getHeight(null)), sp.pic,"Decor");
		
	else
		s=new Sprite(row,colum,sp.pic,sp.className);
/*********************************************************************************
 * 	add sprite or decorations to their visbile and total list
 ***************************************************************************/
	if(dec!=null && dec.pic!=null){
		
		
			decors.add(dec);
		
			if(dec.isVisible() )
				visibleDecors.add(dec);
	}//dec if
	
	
	else if(s!=null && s.pic!=null){
		sprites.add(s);	
	
		if(s.isVisible() )
		visibleSprites.add(s);
	}//sprite if
	
	
}//addSprite



  /**
 * draw the map on the screen.only the visible tiles are drawn.so the 
 * method is complicated.basically it depends on 2 variables.SP and SIx
 *SP is the starting point  where the first image of a row is drawn.
 *SIx is the starting image index.it changes upon scrolling
 *in the drawing loop x is set to SP first and upon finishing drawing first image
 *it moves to the drawed image top right corner. so x is incremented by 
 *the length of the tile.thus the map is drawn tile by tile
 * @param g the graphics object by which the map is drawn
 * @param screen_width the width of the screen where the map is drawn
 * @param screen_height  the Height of the screen where the map is drawn
 */
public void drawMap(Graphics2D g,int screen_width,int screen_height){
	

	int y=screen_height-getTileHeight(SIy ,SIx);
	int count=0;
	
if(background!=null)
	
	g.drawImage(background, 0, 0, null); //draw the background image



for(int i=mapHeight-1;i>=0;i--)//map is drawn from bottom to up
	{
		for(int j=SIx,x=SP ;x<screen_width && j<mapWidth;j++){
			
			//cheking if the map is scrolled.then changing the x of the tiles according to dir		
			tile[i][j].x=Util.getX(j);
			
			
			
			//drawing the images
			if(tile[i][j].pic!=null){
			g.drawImage(tile[i][j].pic, x, y, null);//draw the current tile
			
		//	g.drawString(" x "+tile[i][j].x+" y "+tile[i][j].y,tile[i][j].x , y);
			//g.drawString(" r "+tile[i][j].r+" c "+tile[i][j].c,tile[i][j].x+50 , y+50);
			
			count++;//counts number of tile drawn
			}

			
				x+=getTileWidth(i,j);//increment x to the the next tile draw position
		//x+=tile[i][j].getWidth();//not working ??
		
		
					}//inner
		y-=getTileHeight(i,SIx);
		
	}//outer
	


	//g.drawString("NTD "+count, 0, 440);
	//g.drawString("SIx "+SIx, 0, 430);
	//g.drawString("SP "+SP, 10, 500);
}//drawmap



/*
public void drawMap(Graphics2D g){
	for(int i=0;i<getHeight();i++)
		for(int j=0;j<getWidth() && tile[i][j].isVisible();j++)
			if(tile[i][j].pic!=null)
				tile[i][j].draw(g);
}
*/



/**
 * this method corrects the variables that draws the rows.it's a complicated algorithm
 * the best value of SP is negative but not too negative.as the first tile may
 * not need to be drawn as it's not visible.again if SP positve then its previous
 * tile is not drawn.so whenever SP gets too negative or positive we correct its
 * value.As SP changes SIx also changes.because if the unvisible tiles dont need
 * to be drawn then SIx should be incremented as it starts drawing from SP
 */

private void correctSPAndSIx(){
	
	if(getTileWidth(SIy,SIx)!=0 && SP<-getTileWidth(SIy,SIx)){//cheking if SI is too negative so that it needn't be drawn 
		SP+=getTileWidth(SIy,SIx);//place SP after one tile gap
			if(SIx<getWidth())
				SIx++; //SP ignored/cut a tile.so the map should be drawn from the next tile
	
	}//if
	
	//correct sp for positive
	else if(SP>0 && SIx>0){//SIx>0 means the map has scrolled left atleast once
		SIx--;//so the tile should also be decremented
		SP-=getTileWidth(SIy,SIx);//place SP before this tile
	}//else
	
	
}//correct





//private boolean isMapScrolled;
//private byte dir;
/**
 * scroll the map left or right with specific pixel.as SP represents the staring
 * drawing position of the map.changing SP changes the map visibility or scrolling 
 * Tile interface holds the constant SPEED represents the rate of scrolling
 * @param direction multiplied by SPEED.it's eithed -1 or +1 so it only changes 
 * the direction
 */
public void scroll(final byte direction){
	//dir=direction;
	//isMapScrolled=true;
	
	SP+=SCROLLING_SPEED*direction;
	mapFirstPixel+=SCROLLING_SPEED*direction;
	
	
	correctSPAndSIx();
	//scrollSprites(direction);
	//scrollDecors(direction);
	
	scrollDecorsAndSprites(direction);
	
	Util.calcColum(player);
	Util.calcRow(player);
	
	
}//scrooll



private void scrollDecorsAndSprites(int d){
	
	ArrayList<GameObjects> decs=new ArrayList<GameObjects>();
	CopyOnWriteArrayList<Sprite> sp=new CopyOnWriteArrayList<Sprite>();
	
	Sprite s=null;
	GameObjects dec=null;
	
	int totalSprite=sprites.size();
	int maxLength=Math.max(totalSprite, totalDecors);
	//System.out.println(max);
	
	for(int i=0;i<maxLength;i++){
		//do things for sprite
		if(i<totalSprite){
			s=sprites.get(i);
			
			
			s.scroll(SCROLLING_SPEED, d);
			if(s.isVisible())
				sp.add(s);
			
		}//sp if
		
		//do things for decors
		
		if(i<totalDecors){

			dec=decors.get(i);

			
			dec.scroll(SCROLLING_SPEED, d);
			
			if(dec.isVisible())
				decs.add(dec);
		}//if decor
		
 		

		
	}//for
	
	visibleSprites=sp;
	visibleDecors=decs;
	
}//scrollSP



/**
 * boolean that determines wheather the map can scroll or not
 */
private boolean scrollEnabled;



public boolean isScrollPossible(int playerDirection)
{
	if(playerDirection==RIGHT && tile[7][mapWidth-1].isFullyVisible())
		scrollEnabled=false;
	
	else	 if((SP==0 && SIx==0 && playerDirection==LEFT) )//working
		scrollEnabled=false;
		 else if(playerDirection==RIGHT && player.x>=RIGHT_BOUND_OF_MAP_SCROLLING)
			 scrollEnabled=true			 ;	 
		 else if(playerDirection==RIGHT && player.x>=LEFT_BOUND_OF_MAP_SCORLLING)
			 scrollEnabled=false;

		 else if(playerDirection==LEFT && player.x>LEFT_BOUND_OF_MAP_SCORLLING)
			 scrollEnabled=false;
		 else if(playerDirection==LEFT && player.x<=LEFT_BOUND_OF_MAP_SCORLLING)
			 scrollEnabled=true;	

return scrollEnabled;
	
} //possible scroll

/*
public boolean isScrollPossible(int playerDirection){
	
		if(playerDirection==LEFT && tile[6][0].isVisible())//first tile
			return false;
		else if(playerDirection==RIGHT && tile[0][mapWidth].isVisible())
			return false;
		else
			return true;
		
//	return false;
}
*/
/**
 * returns the tile object at the specified index of the 2D array
 * @param x index of row
 * @param y index of colum
 */
public static Tile getTile(int x,int y){
	if(x>=0 && x<mapHeight && y>=0 && y<mapWidth)

	return tile[x][y];
	else return null;
}


int getTileWidth(int x,int y){
	
	
	if(x>=0 && x<getHeight() && y>=0 && y<getWidth()){
		if(tile[x][y].pic==null)
			return	GameConstants.EMPTY_TILE_WIDTH;

		return tile[x][y].getWidth();
	}
	
		return 0;
}//getTileWidth



int getTileHeight(int x,int y){

	
	if(x>=0 && x<getHeight() && y>=0 && y<getWidth()){
		if(tile[x][y].pic==null)
			return GameConstants.EMPTY_TILE_HEIGHT;

		return tile[x][y].getHeight();
		}
	return 0;
}


	/**
	 * returns the width of the 2d array that is collumn no
	 * @return returns  the no of tiles in each row of the 2D array
	 */
	public	int getWidth()
	{
		return  tile[0].length;
	}
	/**
	 * returns the no of arrays in the 2d array as 2d array in java
	 * is arrays of array
	 * @return no of  rows
	 */
	public int getHeight(){
		return tile.length;
	}//getheight
	
	/**
	 * return the player of this map
	 * @return  an object of class PLayer
	 */
	public Player getPlayer(){
		return player;
	}//getplayer
	
	public void setPlayer(Player p){
		player=p;
	}
	/**
	 * this variable is needed to calculate the x distance of objects x
	 */
	private static int mapFirstPixel;

	/**
	 *returns the first pixel of map 
	 * @return first pixel of map.i.e. x of the first tile
	 */
	public static int getMapFirstPixel(){
		return mapFirstPixel;
	}
	
	
	private static int mapWidth;
	private static int mapHeight;

	public static int getMapWidth(){

		return mapWidth;
	}

	public static int getMapHeight(){

		return mapHeight;
	}


	
}//class

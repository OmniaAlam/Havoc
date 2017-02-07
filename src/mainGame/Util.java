package mainGame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

import screen.TileMap;
import characters.Sprite;





/**
 * this class holds various utilty methods used in the game.it basically improves
 * the readibility of the code.
 * @author USER
 *
 */
public class Util implements GameConstants {

	
	
	
	/**
 *returns the image of the specified path 
 * @param imageFilePath the filepath of the image
 * @return the image
 */
	public static Image getImage(String imageFilePath){
		Image img=null;
		
	
		img= new ImageIcon(imageFilePath).getImage();
	
		if(img==null)
		System.out.println("couldnt load the image from "+imageFilePath+" please correct the path");
	
	
	
	return img;
	}//getImage
	
	
	
 public static int getViewX(int columIndex){
	 return columIndex* GameConstants.EMPTY_TILE_WIDTH;
 }
 
 /*
 public static int getViewY(int rowIndex){
	 return SCREEN_HEIGHT-(TileMap.getMapHeight()-rowIndex)* EMPTY_TILE_HEIGHT;
 }*/
 
 
 public static int getY(int rowIndex){
	 
	int y= SCREEN_HEIGHT-(TileMap.getMapHeight()-rowIndex)* EMPTY_TILE_HEIGHT;
			// rowIndex* GameConstants.EMPTY_TILE_HEIGHT+20;//screen height is 720 so 20 will be subtracted
	//return SCREEN_HEIGHT-()		
		return y;
	}
 
 /**
  * returns value of x of the invoking object from 0
  * @param colum column index of the object
  * @return returns the x.it is calculated by maps' 0 position and the total res of prev. coll
  */
 public static int getX(int colum){
	 
	 return TileMap.getMapFirstPixel()+colum*EMPTY_TILE_WIDTH;
 }//getX
 /*
 public static int getYForDrawImage(int rowIndex){
	 return getY(rowIndex)-picHeight()
 }
 
 */
 /**
  * if x changes then the row will also be change 
  * @param s sprite or its subclass objects which row has to be changed
  */
 public static void calcColum(Sprite s){
	
	 if(getX(s.c)>s.x)
		 s.c--;
	 else if(getX(s.c)+EMPTY_TILE_WIDTH<=s.x)
		 s.c++;
	 
 }//setRow
 
 public static void calcRow(Sprite s){
	if(s.y+s.getHeight()<=getY(s.r))
		 s.r--;
	// System.out.println(getVerticalRes(s.r));
	else if(s.y+s.getHeight()>getY(s.r)+EMPTY_TILE_WIDTH)
		 s.r++;
	 
 }
 
public static int getRow(int y){
	
	return 0;
}
public static int getColum(Sprite s){
	
	
	return 0;
}
public static void changeLookAndFill(){
	 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
       if ("Nimbus".equals(info.getName())) {
           try {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           break;
       
       }

   }
}//LAF
}//util

package mainGame;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import menu.AboutMenu;
import menu.GameOver;
import menu.HelpMenu;
import menu.Menu;
import menu.ResumeMenu;
import menu.SettingPanel;
import screen.FullScreen;
import screen.TileMap;
import characters.Bullet;
import characters.GameObjects;
import characters.Player;
import characters.Sprite;


public class GameTest implements GameConstants {

	/**
	 * @param args
	 */
 public static FullScreen f;
	//int x;
	
	
	 KeyboardInput in;
	
	 Player p;
	 public static int Score;
	 public static boolean isSoundOn=true;
	 public static boolean isAAOn;
	 public static boolean showHelpScreen;
	 public static boolean gameIsNotPaused=true;
	 public static boolean gameOn=false;
	public static int currentLevel=1;

	 TileMap map;
	

	
	public GameTest(){
	
		try {
			SwingUtilities.invokeAndWait(new Runnable(){

				@Override
				public void run() {
						init();
		
				}//run
				
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//swing
	}//constructors
	

/************************************************************************
 * gui create
 ************************************************************************/

public  static Menu menu;
public  static ResumeMenu resume;
public static GameOver over;
public static SettingPanel setting;
public static AboutMenu about;
public static HelpMenu help;
//public  JPanel mainPanel;

LinearGradientPaint healthG;


private void init(){
	/*************************************
	 * init gradeints
	 ***************************/
	float [] points=new float[]{0.0f,.450f,.550f,1f};
	Color [] colors=new Color[] {Color.blue,Color.cyan,Color.cyan, Color.blue};

	healthG=new LinearGradientPaint(50,20,50,40,points,colors);
		
/***********************************************************************
 *   init gui
 ********************************************************************/

		menu=new Menu();//mainmenu
		over=new GameOver();
		setting=new SettingPanel();//done
		resume=new ResumeMenu();
		about=new AboutMenu();
		help=new HelpMenu();
		
	
				// TODO Auto-generated method stub
				f=new FullScreen();//set mainFrame fullScreen
				f.setToFullScreen(new DisplayMode(SCREEN_WIDTH,SCREEN_HEIGHT,32,DisplayMode.REFRESH_RATE_UNKNOWN));
		//add mainmeu
				
				f.add(menu);
				
				
				
			
}//int	




	/**
	 * starts a new game
	 */
	void startNewGame(){
		
	
				
				map=new TileMap("maps/level"+currentLevel+".txt");
		
		
	
				p=map.getPlayer(); //have to work
			f.requestFocusInWindow();//to listen keyboard after new game clik
				in=new KeyboardInput(this);//assign the input manager for this game
				f.addKeyListener(in);// add listener for the frame

				
				
				
				gameLoop();
			
	}//new game

	

void changeLevel(int level){
	if(level<3){
	map=null;
	
	map=new TileMap("maps/level"+level+".txt");
	p=map.getPlayer();
//	System.out.println("x "+p.x+" y "+p.y+" c "+p.c);


	gameOn=false;
	}
	
}
	

	
	void gameLoop(){
		
		
		
		ST=CT=System.currentTimeMillis();
		
		
			
			while(gameOn){
				
				if(gameIsNotPaused){
				CT=System.currentTimeMillis();
						
					
				if(p.c==map.getWidth()-2)//player reach end of the map
				
					changeLevel(++currentLevel);
					
				
				in.keyProcess(); //process keyboard inputs if any
				
					
					render();
				}//if
			}//while
	
		
	}//gameLoop ends
	
	
	
	
double HPfactor=100;	
	/**
	 * drawing codes are written in render()
	 */
	
	public void render(){
		
		Graphics2D g=f.getPaintGraphics(); //getting the pain graphics of the screen
		if(isAAOn)
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//f.paintComponents(g);
/***************************************************************
 * drawing the tile map		
 ********************************************************************/
	map.drawMap(g, f.getWidth(),f.getHeight());

	
	
	
/*************************************************************************************
 * 	drawing the decorations i.e lamp,fence etc
 **************************************************************************************/
	for(GameObjects dec:map.visibleDecors)
		dec.draw(g);
	
/***********************************************************************************
 * now drawing the sprites on the map	
 ***********************************************************************************/

	
	
	for(Sprite s:map.visibleSprites){
		s.allCalculation();
		//if player colide with an enemy
		if(!s.getClassName().equals("Decor") && !s.getClassName().equals("Pumking") && p.intersects(s))
		{
			this.HPfactor+=.5;
			if(HPfactor%10==0)
			{
				HPfactor=1;
			p.health--;
		
			if(p.health<=0)
			{
				p.life--;///if health goes to 0 decrement life
				if(p.life<=0)
					doThingsForGameOver();
				else
				p.health=PLAYER_HEALTH;//restore health
				
			}//if
			
			}
		}//if
			
		else if(s.getClassName().equals("Pumking") && p.intersects(s)){
			//System.out.println("dad");
			//make healthier
			p.life++;
			map.visibleSprites.remove(s);//make the pumpkin disappear
			map.sprites.remove(s);
		}
			
		s.draw(g);
	

	
	}//for
	
 
	
	
/**********************************************************************************
 * 	drawing player
 **********************************************************************************/
	p.allCalculations();
	
	p.draw(g);
	
	
	
	
		
/******************************************************************************
 * 	drawing the bullets 	
 ******************************************************************************/
		for(Bullet b:Bullet.getList()){
		
			if(checkForCollision( b)){
				//remove the bullet
				//Bullet.getList().remove(b);
				//remove the sprite from the game
				
			}
			
		else
			b.move();
			
			
		b.draw(g);
		}
//if user press for help then show help screen
		
if(	 showHelpScreen)
	g.drawImage(AllImages.Help,100,100,null);

		

//benchMark(g);
//score
drawUI(g);

f.bs.show();//show the screen

}//render

/**
 * user interface	
 * @param g2 graphics parameter
 */
private void drawUI(Graphics2D g2){
	Graphics2D g=(Graphics2D)g2.create();
	
//SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
//					SCORE
//SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
	//g.drawImage(AllImages.SCORE, 500, 20,null);
	//make the score smooother
	g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
	g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,30));

	g.setPaint(new GradientPaint(800,50,Color.BLACK.darker(),800,65,Color.GRAY));//shadow
	g.drawString(""+Score, 705, 58);
	g.setPaint(new GradientPaint(800,50,Color.BLUE.darker().darker(),800,65,Color.CYAN));
		
	g.drawString("Score: "+Score, 600, 60);
	
/***************************************************************
 * 		HEALTHBAR
 * ************************************************************/
	g.drawImage(AllImages.HEALTH_BAR, 50, 20,PLAYER_HEALTH*20,20, null);//full bar
	g.setPaint(healthG);
	
	g.fillRect(50, 20, p.health*20-10, 20);
		//if(p.life!=0)
	g.fillOval(p.health*20+30, 20, 20, 20);
	
/*********************************************************************
 * 			Heart
 ************************************************************************/
	int hp=50;//draw x of first heart
	for(int i=1;i<=p.life;i++)
	{
	g.drawImage(AllImages.GREEN_HEART, hp, 70, null);
		hp+=70;
	
	}
	g.dispose();
}//UI


	
	/**
	 * checks this bullet collision with any visible sprite
	 * @param visibleSprites the enemies to be collied with
	 */
public boolean checkForCollision(Bullet b){
	//check for enemybullet and chek intersection with player
	if(b.isThisEnemyBullet && b.intersects(p)){
		p.health--;
		Bullet.getList().remove(b);
		if(p.health<=0)
		{
			p.life--;///if health goes to 0 decrement life
			if(p.life<=0)
				doThingsForGameOver();
			else
			p.health=PLAYER_HEALTH;//restore health
			
		}//if
		
				
	}//if
			
	else	
	//else this is player fired bullet so check if it hits an enemy		
		for(Sprite s:map.visibleSprites){//iterats all the visible enemys
			
			if( !b.isThisEnemyBullet && b.intersects(s) ){
				//the bullet hits the sprite.so the bullet is dead
				Bullet.getList().remove(b);
				//remove the sprites
				s.doThingsForHit();
				if(s.life<=0){
				map.sprites.remove(s);
				//remove from the visible list
				map.visibleSprites.remove(s);
				Score+=10;
				}
				
				return true;
			}//if
		
		}//for
	
		return false;
	}//collision
	


void doThingsForGameOver(){
	gameOn=false;
	p.health=0;
	try {
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				f.add(over);
				f.validate();
				f.repaint();
				newGameClicked=false;
			}
		});
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private	int FPS;
private	int FFPS;
private int ms;
long ST;
long CT;
private void benchMark(Graphics2D g){
FPS++;

Graphics g1=g.create();
g1.setColor(Color.WHITE);
g1.fillRect(0, 0, 200, 200);


//draw FPS
g.drawString("FPS "+FFPS+" "+ms+" ms", 0, 20);

//draw total current total pic drawn
g.drawString("total pic "+TileMap.test, 0, 30);//DDD
g.drawString("Score:"+Score, 0,40);
g.drawString("total bullet "+(Bullet.getList().size()),0,50);
g.drawString("mapWidth "+map.getWidth(), 0, 60);
g.drawString("player row "+p.r+" colm "+p.c+" x "+p.x+" y "+p.y, 0, 70);
g.drawString("SIX "+TileMap.SIx+" SIy "+TileMap.SIy, 0, 80);
long m=CT-ST;
if(m>=1000){
	ms=(int)m;

	FFPS=FPS;

	ST=System.currentTimeMillis();
	FPS=0;
	
}
	
g1.dispose();
}//bechmark





public static boolean newGameClicked;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			Util.changeLookAndFill();
		
		GameTest game=new GameTest();
		
		
		
		gameOn=true;
		//game.startNewGame();
		try{
		while(true){
			
			gameOn=true;
		if(newGameClicked)
				game.startNewGame();
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while
		
		}//try
		finally	{ game.f.restoreScreen(); }//finally block ensure restoring the screen
	}//main

}//class

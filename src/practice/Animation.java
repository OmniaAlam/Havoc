package practice;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Animation  {

	private ArrayList<Frame> frames;
	/**
	 * totalduration of this animation.calculted from individul duration of each frame
	 */
	private long totalDuration;
	
	/**
	 * takes the file path where images for animations are save sequentially
	 * @param filename the .anim file where sequential images path are saved
	 */
	public Animation(String filename){
		
		//creating list in which every pic is stored 
		frames=new ArrayList<Frame>();
		
		//creating a reader to read from the file
		try{
		BufferedReader r=new BufferedReader(new FileReader(filename));
		//string that represents every line i.e. image path in the text file
		String line=null;
	//Graphics
		while((line=r.readLine())!=null){
			//line is containing the image path and its duration number after '=' is the time 
			//splitting the line into to string path[0] is the imgpath and path[1] is duration
				
			String path[]=line.split("=");
			//if cant split succeccfully that means the line is not written correctly
			
			if(path.length!=2){
				System.out.println("not written correctly "+line);
				continue;
			}
			
			//save the image in img
			Image img=new ImageIcon(path[0]).getImage();
			if(img==null){
				System.out.println("image not found. specify the path before = correctly");
				continue;
			}
			//save the dur in dur
			long	dur=0;
			
			try{
			dur=Long.parseLong(path[1]);
			}
			catch(NumberFormatException e){
				System.out.println("cant parse the duration please rewrite the number of mills after = sign "+line);
				e.printStackTrace();
				continue;
			}
			
			//creates a frame object with the image and its duration
			
			frames.add(new Frame(img,dur ));
			totalDuration+=dur;// sum of duration  of each frame is the total durattion of this animation
	
		}//while
	
		r.close();//close the file after done reading
		
		}catch(FileNotFoundException e){
			System.out.println("file cantbe load");
			e.printStackTrace();
		}
		catch(IOException e){
			System.out.println("error in animation file reading ");
			e.printStackTrace();
		}//catch
		
		
		
	}//const
	
	

	boolean repeat=true;
	
/**
 * start method start the animation with specified duration and the picture of the animated sprite	
 * @param duration how long the animation should be played in millis.if -1 then it means the anim will be played indefinitely 
 * @param picToAnimate picture of the invoking sprite.the method change the picture during the animation
 */
public void start(long duration,Image picToAnimate){

	//change the pic instantly once to more be more responsive
	if(!frames.isEmpty())
	picToAnimate=frames.get(0).img;

//System.out.println(""+frames.size());	

//start time in millis 	
	long startTime=0;
	long currTime=0;
	//assign the machine time to start and current time
	startTime=currTime=System.currentTimeMillis();
	
	
	while(currTime-startTime<duration || duration== -1 ){
			
		
			long elapsedTime=System.currentTimeMillis()-currTime;
	//increment current time by elapsed time
			currTime+=elapsedTime;
			
			
		//animate cheks if a frame has been changed 
			if(animate(elapsedTime))
				picToAnimate=frames.get(currFrameIndex).img;//change the image
		
			
		}//while
	}//start
	
/**
 * tracks how much time has passed
 */
long currAnimTime;
private int currFrameIndex;
/**
 * tracks the sum of duraiton of the previous frames of curent frame
 */
private long prevDur;


/**
 * checks if the frame has to be changed
 * @param elapsed how much time passed after the call of start
 * @return true if frame has changed else false
 */
private boolean animate(long elapsed){
	
	boolean frameChanged=false;
	if(frames.size()>1)//if frame contains only 1 image no need to animate
	{
		currAnimTime+=elapsed;
		
		if(currAnimTime>=totalDuration){
			//start from the begining.if animtime exacly not eqauals to the TD then the extra millis will be CAT
			currAnimTime%=totalDuration; 
			currFrameIndex=0;
			prevDur=0;
			frameChanged=true;//frameIndexchange means frameChanged
		}
	/*	
	if(currFrameIndex>=frames.size()){
			
			currFrameIndex=0;
			prevDur=0;
			frameChanged=true;
		}
	*/
//now see if animTime has passed the currFrame duration then the next frame will be displayed
		if(currAnimTime> frames.get(currFrameIndex).duration+prevDur){
			
			prevDur=frames.get(currFrameIndex).duration;
			
			if(currFrameIndex>=frames.size()-1)
				currFrameIndex=0;
			else
			currFrameIndex++;
			frameChanged=true;
		}
		
	
		
	}//if
	
	return frameChanged;
}//animate
	


	/**
	 * simple class that holds the image and its duration in millis
	 */
	 class Frame{
		Image img;
		long duration;
		
		Frame(Image img,long d){
			this.img=img;
			duration=d;
		}//const
	}//frame
	
	
}//class

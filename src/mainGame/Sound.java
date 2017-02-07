package mainGame;



import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;




public class Sound  {

	

	public static void play(final Sound clip){
		 
		new Thread(new Runnable(){

			public void run(){
			InputStream stream =
				    new ByteArrayInputStream(clip.getSamples());

					clip.play(stream);
			}
		}).start();
	}
	
	

	public static void play(final String file){
		 
		new Thread(new Runnable(){

			public void run(){
				Sound clip=new Sound(file);
			InputStream stream =
				    new ByteArrayInputStream(clip.getSamples());

					clip.play(stream);
			}
		}).start();
	}
	
	
	/*
	public static void bullet(){
		new Thread(new Runnable(){

			public void run(){
			InputStream stream =
				    new ByteArrayInputStream(GameConstants.GUN.getSamples());

					GameConstants.GUN.play(stream);
			}
		}).start();
	}
   // public static void main(String[] args) {
        
 /*       Sound sound =
            new Sound("");

        
        InputStream stream =
            new ByteArrayInputStream(sound.getSamples());

        
        sound.play(stream);

        
        System.exit(0);
 */
    
   // }
    
    

    private AudioFormat format;
    private byte[] samples;

   
    public Sound(String f) {
        try {
            
            AudioInputStream stream =
                AudioSystem.getAudioInputStream(
                new File(f));

            format = stream.getFormat();

            
            samples = getSamples(stream);
        }
        catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


   
    public byte[] getSamples() {
        return samples;
    }


    
    private byte[] getSamples(AudioInputStream audioStream) {
        
        int length = (int)(audioStream.getFrameLength() *
            format.getFrameSize());

        
        byte[] samples = new byte[length];
        DataInputStream is = new DataInputStream(audioStream);
        try {
            is.readFully(samples);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        
        return samples;
    }


  
    public void play(InputStream source) {

       
        int bufferSize = format.getFrameSize() *
            Math.round(format.getSampleRate() / 10);
        byte[] buffer = new byte[bufferSize];

        
        SourceDataLine line;
        try {
            DataLine.Info info =
                new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open(format, bufferSize);
        }
        catch (LineUnavailableException ex) {
            ex.printStackTrace();
            return;
        }

      
        line.start();

      
        try {
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                numBytesRead =
                    source.read(buffer, 0, buffer.length);
                if (numBytesRead != -1) {
                   line.write(buffer, 0, numBytesRead);
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        
        line.drain();

        
        line.close();

    }

}


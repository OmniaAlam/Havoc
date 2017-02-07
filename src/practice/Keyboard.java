package practice;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import practice.DemoKeyInput;

public class Keyboard  extends DemoKeyInput implements KeyListener {

	/**
	 * @param args
	 */
	
	
	

	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		if(k.getKeyCode()==KeyEvent.VK_LEFT)
		{
		new DemoKeyInput().repaint();
		System.out.println(k.getKeyCode());
		}
		
	}

	@Override
	public void keyReleased(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent k) {
		// TODO Auto-generated method stub
		
	}

}

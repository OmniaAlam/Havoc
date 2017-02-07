package practice;

import javax.swing.JFrame;

public class TestFrame extends JFrame {

	/**
	 * this is a testing frame for all the moduels of the game
	 */
	public TestFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		this.setLocationRelativeTo(null);//sets to the centre
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
new TestFrame();

	}

}

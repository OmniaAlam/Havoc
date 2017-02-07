/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import mainGame.GameTest;
import mainGame.Util;
import practice.TestFrame;

/**
 *
 * @author USER
 */
public class SettingPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingPanel
     */
	   Image background;
	   
	

    public SettingPanel() {
        
        initComponents();
        background=new ImageIcon("images/menu/blueShade.jpg").getImage();
        //this.setLocation(GameConstants.SCREEN_WIDTH/2-getWidth()-2, 100);
    }

    @Override
    protected void paintComponent(Graphics g){
    	 super.paintComponent(g);
    	 if(background!=null)
        g.drawImage(background, 0, 0,getWidth()-1,getHeight()-1,null);

    }
   
    
    private void initComponents() {
        back = new javax.swing.JButton();
        AA = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sound = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.setFont(new Font("Vivaldi", Font.PLAIN, 24));
    	back.setForeground(new Color(153, 204, 204));
    	back.setBackground(new Color(0, 0, 0));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        AA.setFont(new java.awt.Font("Aharoni", 3, 24)); // NOI18N
        AA.setForeground(new java.awt.Color(0,0 , 153).brighter().brighter());
        AA.setSelected(true);
        AA.setText("On");
        AA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Plantagenet Cherokee", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Antialiasing");
        jLabel4.setToolTipText("Blurring the edges of pictures to have smoother animation.");

       // jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/movie.png"))); // NOI18N
        jLabel3.setIcon(new ImageIcon("images/menu/movie.png"));
        sound.setFont(new java.awt.Font("Aharoni", 3, 24)); // NOI18N
        sound.setForeground(new java.awt.Color(0, 150, 153).brighter());
        sound.setSelected(true);
        sound.setText("On");
        sound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Plantagenet Cherokee", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Game Sound");
        jLabel2.setToolTipText("Turn on /off sound.");


     //   jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Panels/images/musici.png"))); // NOI18N
        jLabel1.setIcon(new ImageIcon("images/menu/musici.png"));


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)))
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AA)
                    .addComponent(sound))
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sound))))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(AA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(70, 70, 70))))
        );
}

    

private void soundActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
	
	if(sound.isSelected())
		GameTest.isSoundOn=true;
	else
		GameTest.isSoundOn=false;

}

private void AAActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
	if(AA.isSelected())
		GameTest.isAAOn=true;
	else
		GameTest.isAAOn=false;
}
public static boolean isCalledFromResumeMenu=false;
private void backActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:
	GameTest.f.remove(GameTest.setting);
	if(isCalledFromResumeMenu)
	GameTest.f.add(GameTest.resume);
	else
		GameTest.f.add(GameTest.menu);	
	GameTest.f.validate();
	GameTest.f.repaint();
	
	
	
}

// Variables declaration - do not modify
private javax.swing.JCheckBox AA;
private javax.swing.JButton back;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JCheckBox sound;

    public static void main(String args[]){
    	Util.changeLookAndFill();
    	SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
			 	TestFrame f=new TestFrame();
			 //	f.setLayout(new BoxLayout(f, BoxLayout.X_AXIS));
			    f.add(new SettingPanel());
			    
			   // f.pack();
			}
    		
    	});
    }
}

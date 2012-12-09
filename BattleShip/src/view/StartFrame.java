/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author truong
 */
public class StartFrame extends JFrame{
    
    private JPanel pnlButtons; //contains the buttons
    private JButton btnPlayGame; //play game
    private JButton btnHowToPlay; //show the help panel
    private JButton btnQuit;
    private StartImagePanel pnlImage; //just to display an image

    public StartFrame() throws HeadlessException {
        
        this.setLayout(new BorderLayout());
        
        //init the panel to display image
        pnlImage = new StartImagePanel();
        this.add(pnlImage,BorderLayout.CENTER);
        
        //init the panel contains some buttons
        pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPlayGame = new JButton("Play Game");
        pnlButtons.add(btnPlayGame);
        btnHowToPlay = new JButton("How To Play");
//        pnlButtons.add(btnHowToPlay);
        btnQuit = new JButton("Quit");
        pnlButtons.add(btnQuit);
        this.add(pnlButtons,BorderLayout.SOUTH);
        
        //add action listener for the play game button
        btnPlayGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });
        
        //action listener for the quit button
        btnQuit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        
        //init the frame and show
        this.pack();
        this.setLocation(ScreenDisplay.getDisplayLocation(this));
        this.setVisible(true);
    }
    
    private void playGame(){
        new ShipSelectionFrame(this);
        this.setVisible(false);
    }
    
    //restore the current frame
    public void restoreFrame(JFrame childrenFrame){
        childrenFrame.dispose();
        this.setVisible(true);
    }
    
    private void quit(){
        System.exit(-1);
    }
    
    public static void main(String[] args) {
        new StartFrame();
    }
}

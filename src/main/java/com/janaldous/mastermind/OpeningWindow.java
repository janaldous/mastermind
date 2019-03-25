package com.janaldous.mastermind;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Opening window
 * @author Jat Torres
 * @version 30 May 2012
 * 
 * description: window that is first seen when opening the program, 
 */
@Deprecated
class OpeningWindow extends JFrame implements ActionListener 
{
    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT   = 230;
    private static final int FRAME_X_ORIGIN = 400;
    private static final int FRAME_Y_ORIGIN = 300;

    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 30;

    private JButton cancelButton;
    private JButton okButton;    
    private JLabel logo2;
    private JLabel logo;  //This part added for image
    private boolean game;

    public OpeningWindow() 
    {

        // set the frame properties
        setTitle ("Mastermind");
        setSize  (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);

        // set the content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);

        //create and place two buttons on the frame's content pane
        okButton = new JButton("Start");
        okButton.setBounds(60, 110, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(okButton);

        cancelButton = new JButton("Quit");
        cancelButton.setBounds(60, 140, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(cancelButton);

        //registering the buttonHandler as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);

        logo2 = new JLabel(new ImageIcon("mastermind.jpeg")); // 
        logo2.setBounds(0, 0, 300, 100); // sets picture position and size
        contentPane.add(logo2); // adds image to frame
        logo2.setVisible(true);

        logo = new JLabel(new ImageIcon("brain.jpg")); // 
        logo.setBounds(0, 0, 400, 300); // sets picture position and size
        contentPane.add(logo); // adds image to frame
        logo.setVisible(true);
        // register 'Exit' upon closing as default close operation
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //This part revised for Input Text field
    public void actionPerformed(ActionEvent event){
        if (event.getSource() instanceof JButton){
            JButton clickedButton = (JButton) event.getSource();
            String buttonText = clickedButton.getText();

            if (buttonText.equals("Start"))
            {
                if (game == false)// not show if player already knows this after first game
                {
                    JOptionPane.showMessageDialog(null,"You have been hired as the decoder \nand within 9 attempts have the corrcet combination.");
                }
                MainGUI main = new MainGUI();
                this.setVisible(false);
                main.setVisible(true);
                game = true;
            }
            if (buttonText.equals("Quit"))
            {
                int selection = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to quit?",
                        "Quiting",
                        JOptionPane.YES_NO_OPTION);

                if (selection == JOptionPane.YES_OPTION)
                {
                    System.exit(0);//if click cancel then exit
                }
                if (selection == JOptionPane.NO_OPTION)
                {

                }            
            }     

        } 
    }

    public static void main(String[] args) {
        OpeningWindow ow = new OpeningWindow();
        ow.setVisible(true);
    }

}  // End of Class`

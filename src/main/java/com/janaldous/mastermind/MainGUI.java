package com.janaldous.mastermind;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Mastermind Main Class
 * @version 30 May 2012
 * @author Jat Torres
 * 
 * description: display class
 */
@Deprecated
public class MainGUI extends JFrame implements ActionListener 
{
    private static final int FRAME_WIDTH    = 450;
    private static final int FRAME_HEIGHT   = 690;
    private static final int FRAME_X_ORIGIN = 450;
    private static final int FRAME_Y_ORIGIN = 100;

    private static final int BUTTON_WIDTH = 70;
    private static final int BUTTON_HEIGHT = 30;
    private static final int peg_WIDTH = 30;
    private static final int peg_HEIGHT = 30;
    private static final int secondC = 120;
    private static final int thirdC = 190;
    private static final int forthC = 260;
    private int guessR = 50;
    private int guess2R = 50;
    private int firstR = 50;
    private int firstC = 50;

    private JButton helpButton;
    private JButton cancelButton;
    private JButton okButton;
    private JButton redButton;
    private JButton blueButton;
    private JButton purpleButton;
    private JButton yellowButton;
    private JLabel prompt1;
    private JLabel prompt;
    private JLabel prompt2;
    private JLabel guess1;
    private JLabel correct;

    private JLabel[] bluePeg1 = new JLabel[10]; 
    private JLabel[] bluePeg2 = new JLabel[10]; 
    private JLabel[] bluePeg3 = new JLabel[10]; 
    private JLabel[] bluePeg4 = new JLabel[10]; 
    private JLabel[] guess = new JLabel [10];
    private JLabel[] guess2 = new JLabel [10];
    private JLabel[] ansPic = new JLabel [4];
    public int[] ans = new int [4];
    public int[] gs = new int [4];
    public int[] temp = new int [4];

    int pc = -1;
    int x = 0;
    int x2 = 0;
    int ctr = 0;
    int u = 0;
    int ctr2 = 0;
    int ctrA = 1;
    int ctrB = 1;
    int ctrC = 1;
    int ctrD = 1;

    /**
     * Constructor for MainGUI class
     */
    public MainGUI() 
    {
        //set guess all to 1
        for(int i=0; i<4; i++)
        {
            gs[i] = 1;
        }

        //genrate 4 random numbers || the correct combination
        for (int j = 0; j < 4; j++)
        {
            ans[j]  = (int) Math.floor(Math.random() * 8) +1;
        }

        // set the frame properties
        setTitle ("Mastermind");
        setSize  (FRAME_WIDTH, FRAME_HEIGHT);
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setResizable(false);

        // set the content pane properties
        Container contentPane = getContentPane();   
        contentPane.setLayout(null);
        contentPane.setBackground(Color.white);

        correct = new JLabel();
        correct.setText("< Correct Combo");
        correct.setBounds(320, 440, 407, 258);
        contentPane.add(correct);
        correct.setVisible(false);

        //correct colour and position
        for (int u = 0; u < 10; u++)
        {
            guess[u] = new JLabel();
            guess[u].setText(" "+x);
            guess[u].setForeground(Color.RED);
            guess[u].setBounds(330, guessR, 40, 25);
            contentPane.add(guess[u]);
            guess[u].setVisible(true);

            guessR = guessR + 50;
        }

        guessR = 50;
        //correct colour only
        for (int u = 0; u < 10; u++)
        {
            guess2[u] = new JLabel();
            guess2[u].setText(" "+x2);
            guess2[u].setBounds(370, guessR, 40, 25);
            contentPane.add(guess2[u]);
            guess2[u].setVisible(true);

            guessR = guessR + 50;
        }

        //create and place two buttons on the frame's content pane
        okButton = new JButton("Guess");
        okButton.setBounds(310, 590, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(okButton);

        cancelButton = new JButton("Quit");
        cancelButton.setBounds(170,630, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(cancelButton);

        helpButton = new JButton("Help");
        helpButton.setBounds(240,630, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(helpButton);

        redButton = new JButton("1");
        redButton.setBounds(30,590, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(redButton);

        blueButton = new JButton("2");
        blueButton.setBounds(100,590, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(blueButton);

        purpleButton = new JButton("3");
        purpleButton.setBounds(170,590, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(purpleButton);

        yellowButton = new JButton("4");
        yellowButton.setBounds(240,590, BUTTON_WIDTH, BUTTON_HEIGHT);
        contentPane.add(yellowButton);

        //registering the buttonHandler as an action listener of the two buttons
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);
        redButton.addActionListener(this);
        blueButton.addActionListener(this);
        purpleButton.addActionListener(this);
        yellowButton.addActionListener(this);

        //blank pic
        for (int i= 0; i < 10; i++)
        {
            bluePeg1[i] = new JLabel(new ImageIcon("peg"+ctr+".png")); // 
            bluePeg1[i].setBounds(firstC, firstR, peg_WIDTH, peg_HEIGHT); // sets picture position and size
            contentPane.add(bluePeg1[i]); // adds image to frame
            bluePeg1[i].setVisible(true);

            bluePeg2[i]= new JLabel(new ImageIcon("peg"+ctr+".png")); // 
            bluePeg2[i].setBounds(secondC, firstR, peg_WIDTH, peg_HEIGHT); // sets picture position and size
            contentPane.add(bluePeg2[i]); // adds image to frame
            bluePeg2[i].setVisible(true);

            bluePeg3[i] = new JLabel(new ImageIcon("peg"+ctr+".png")); // 
            bluePeg3[i].setBounds(thirdC, firstR, peg_WIDTH, peg_HEIGHT); // sets picture position and size
            contentPane.add(bluePeg3[i]); // adds image to frame
            bluePeg3[i].setVisible(true);

            bluePeg4[i] = new JLabel(new ImageIcon("peg"+ctr+".png")); // 
            bluePeg4[i].setBounds(forthC, firstR, peg_WIDTH, peg_HEIGHT); // sets picture position and size
            contentPane.add(bluePeg4[i]); // adds image to frame
            bluePeg4[i].setVisible(true);

            firstR = firstR + 50;

        }

        firstR = 550;
        for (int i = 0; i < 4; i++)
        {
            ansPic[i] = new JLabel(new ImageIcon("peg"+ans[i]+".png")); // 
            ansPic[i].setBounds(firstC, firstR, peg_WIDTH, peg_HEIGHT); // sets picture position and size
            contentPane.add(ansPic[i]); // adds image to frame
            ansPic[i].setVisible(false);

            firstC = firstC + 70;
        }

        firstR = 0;
        firstR = firstR + 50;
        //ctr = 1;//
        ctr++;

        String pegName = "peg"+ctr+".png"; 
        ImageIcon img = new ImageIcon(pegName);                    

        pc++;
        bluePeg1[pc].setIcon(img);
        bluePeg2[pc].setIcon(img);  
        bluePeg3[pc].setIcon(img);  
        bluePeg4[pc].setIcon(img);

        bluePeg1[pc].setVisible(true);
        bluePeg2[pc].setVisible(true);
        bluePeg3[pc].setVisible(true);
        bluePeg4[pc].setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    //This part revised for Input Text field
    public void actionPerformed(ActionEvent event)
    {
        JButton clickedButton = (JButton) event.getSource();
        String buttonText = clickedButton.getText();

        if (buttonText.equals("Guess"))
        {
            firstR = firstR + 50;
            CheckGuess cg = new CheckGuess();
            x = cg.checkGuessPosition(gs, ans);
            x2 = cg.checkGuessColors(gs, ans);
            pc++;
            
            guess[u].setText(" " + x);
            guess2[u].setText(" " + x2);
            u ++;

            JOptionPane.showMessageDialog(null,
                "Correct colors and positions: "+ x 
                + "\nCorrect colors: "+ x2);

            if (x == 4)
            {
                JOptionPane.showMessageDialog(null,"Congratulations!\nYou have guessed the correct color combination.");

                display();

                int selection = JOptionPane.showConfirmDialog(null,
                        "Do you want to play again?",
                        "Play again?",
                        JOptionPane.YES_NO_OPTION);

                if (selection == JOptionPane.YES_OPTION)
                {
                    OpeningWindow ow = new OpeningWindow();
                    this.setVisible(false);
                    ow.setVisible(true);
                }
                if (selection == JOptionPane.NO_OPTION)
                {
                    System.exit(0);
                }
            }

            if (pc == 10)
            {
                if (x != 4)
                {
                    JOptionPane.showMessageDialog(null,"Incorrect\nYou have not guessed the correct color combination.");

                    display();

                    int selection = JOptionPane.showConfirmDialog(null,
                            "Do you want to play again?",
                            "Play again?",
                            JOptionPane.YES_NO_OPTION);

                    if (selection == JOptionPane.YES_OPTION)
                    {
                        OpeningWindow pt = new OpeningWindow();
                        this.setVisible(false);
                        pt.setVisible(true);
                    }
                    if (selection == JOptionPane.NO_OPTION)
                    {
                        System.exit(0);
                    }   
                }
            }

            ctr = 1;
            String pegName = "peg"+ctr+".png"; 
            ImageIcon img = new ImageIcon(pegName);                  

            bluePeg1[pc].setIcon(img);
            bluePeg2[pc].setIcon(img);  
            bluePeg3[pc].setIcon(img);  
            bluePeg4[pc].setIcon(img);  

            bluePeg1[pc].setVisible(true);
            bluePeg2[pc].setVisible(true);
            bluePeg3[pc].setVisible(true);
            bluePeg4[pc].setVisible(true);

            ctr = 1;
            ctrA = 1;
            ctrB = 1;
            ctrC = 1;
            ctrD = 1;
            x = 0;

            for (int i = 0; i < 4; i++)
            {
                gs[i] = 1;
            }

        }

        if (buttonText.equals("Quit"))
        {
            display();

            int selection = JOptionPane.showConfirmDialog(null,
                    "Do you want to play again?",
                    "Play again?",
                    JOptionPane.YES_NO_OPTION);

            if (selection == JOptionPane.YES_OPTION)
            {

                OpeningWindow pt = new OpeningWindow();
                this.setVisible(false);
                pt.setVisible(true);
            }
            if (selection == JOptionPane.NO_OPTION)
            {
                System.exit(0);
            }
        }

        if (clickedButton == redButton)
        {
            ctr = ctrA;
            ctr++;

            if (ctr == 9)
            {
                ctr = 1;
            }
            gs[0] = ctr;//

            String pegName = "peg"+ctr+".png"; 
            ImageIcon img = new ImageIcon(pegName);                    
            bluePeg1[pc].setIcon(img);                                       
            bluePeg1[pc].setVisible(true);

            ctrA = ctr;
        }

        if (clickedButton == blueButton)
        {
            ctr = ctrB;
            ctr++;

            if (ctr == 9)
            {
                ctr = 1;
            }
            //
            String pegName = "peg"+ctr+".png"; 
            ImageIcon img = new ImageIcon(pegName);                    
            bluePeg2[pc].setIcon(img);                                       
            bluePeg2[pc].setVisible(true);
            gs[1] = ctr;

            ctrB = ctr;

        }

        if (clickedButton == purpleButton)
        {
            ctr = ctrC;
            ctr++;

            if (ctr == 9)
            {
                ctr = 1;
            }

            String pegName = "peg"+ctr+".png"; 
            ImageIcon img = new ImageIcon(pegName);               
            bluePeg3[pc].setIcon(img);                                       
            bluePeg3[pc].setVisible(true);
            gs[2] = ctr;
            ctrC = ctr;

        }

        if (clickedButton == yellowButton)
        {
            ctr =ctrD;
            ctr++;

            if (ctr == 9)
            {
                ctr = 1;
            }

            String pegName = "peg"+ctr+".png"; 
            ImageIcon img = new ImageIcon(pegName);                   
            bluePeg4[pc].setIcon(img);                                       
            bluePeg4[pc].setVisible(true);
            gs[3] = ctr;
            ctrD =ctr;

        }

        if (buttonText.equals("Help"))
        {
            Help h = new Help();
            h.help();
        }
    }

    private void display()
    {

        for (int i = 0; i < 4; i++)
        {
            ansPic[i].setVisible(true);
        }

        correct.setVisible(true);
    }

    public static void main(String[] args) 
    {
        MainGUI frame = new MainGUI();
        frame.setVisible(true);

    }

}  // End of Class`
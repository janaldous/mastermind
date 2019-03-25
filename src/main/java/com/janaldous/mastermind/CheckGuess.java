package com.janaldous.mastermind;

import javax.swing.*;

/**
 * Write a description of class jh here.
 * 
 * @author Jat Torres
 * @version 30 May 2012
 */
@Deprecated
public class CheckGuess
{
    public int firstR;
    public int x = 0;
    public int x2 = 0;
    public int[] ans = new int [4];
    public int[] gs = new int [4];
    public int[] temp = new int [4];

    /**
     * compares the guess combination with the correct color combination
     * 
     * @param  gs[]   array of guess combination to be checked
     * @return    x     number of correct colors and positions    
     */
    public int checkGuessPosition(int gs[], int ans[])
    {
        x = 0;
        //check correct color and postion
        for (int i = 0; i < 4; i++)
        {
            if (gs[i] == ans[i])
            {
                x++;
            }
        }
        return x;
    }

    /**
     * compares the guess colors with the correct colors (not positions)
     * 
     * @param  gs[]   array of guess combination to be checked
     * @return    x2    number of correct colors       
     */
    public int checkGuessColors(int gs[], int ans[])
    {
        for (int f = 0; f < 4; f++)
        {
            temp[f] = ans[f];
        }

        for (int k = 0; k < 4; k++)
        {
            for (int j = 0; j < 4 && j != k; j++)
            {
                if (k != j)
                {
                    if (gs[k] == temp[j])
                    {
                        temp[j] = -1;
                        x2++;
                        break;
                    }
                }
            }
        }
        return x2;
    }
}


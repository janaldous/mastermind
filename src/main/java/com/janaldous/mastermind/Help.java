package com.janaldous.mastermind;

import java.io.*;
/**
 * opens and displayes contents of help document
 * 
 * @author Jat Torres
 * @version 1 June 2012
 */
@Deprecated
public class Help
{
    /**
     * Constructor for objects of class Help
     */
    public void help()
    {
        try
        {
            System.out.println('\f');    

            File f = new File("Instructions.txt");
            FileReader in = new FileReader(f);
            BufferedReader r = new BufferedReader (in);

            for (int i = 0; i < 23; i++)
            {
                String a = r.readLine();
                System.out.println(a);

            }

            r.close();
        }
        catch(Exception e) {
        }
    }
}

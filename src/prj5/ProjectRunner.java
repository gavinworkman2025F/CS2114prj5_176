// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Timothy Park (tim0thy)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

package prj5;

import java.io.IOException;

// -------------------------------------------------------------------------
/**
 * ProjectRunner class
 * 
 * @author timothypark
 * @version Nov 18, 2025
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Main method
     * 
     * @param args
     *            is the command line argument
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {
        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        boolean showConsole = false;
        boolean showGUI = true;
        if (showConsole)
        {
            System.out.println(filer.toString());
        }
        if (showGUI)
        {
            new DataWindow(filer);
        }
    }
}

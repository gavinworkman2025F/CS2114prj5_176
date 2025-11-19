package prj5;

import java.util.Scanner;
import student.IOHelper;

// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Matthew Seo (mjseo)
// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

// -------------------------------------------------------------------------
/**
 * Reads the files and sorts users into their respective months
 * 
 * @author mjseo
 * @version Nov 18, 2025
 */
public class InputFileReader
{
    private String inputFile;
    private SinglyLinkedList<Month> months;
    private String[] names = new String[4];

    // ----------------------------------------------------------
    /**
     * Creates a new input file reader
     * 
     * @param inputFile
     *            the input file name to put int
     */
    public InputFileReader(String inputFile)
    {
        this.inputFile = inputFile;
    }// new DataWindow(EngagementSet)


    // ----------------------------------------------------------
    /**
     * Reads the file
     * 
     * @param file
     *            the name of the file to be read
     */
    public void readInputFile(String file)
    {
        Scanner inStream = IOHelper.createScanner(inputFile);
        inStream.nextLine();// skip header
        boolean first = true;
        SinglyLinkedList<User> users = new SinglyLinkedList<User>();
        String prevMonth = null;
        months = new SinglyLinkedList<Month>();
        while (inStream.hasNextLine())
        {

            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];

            boolean contains = false;
            for (int i = 0; i < 4; i++)
            {
                if (names[i].equals(username))
                {
                    contains = true;
                }
            }
            if (contains == false)
            {
                for (int i = 0; i < 4; i++)
                {
                    if (names[i] == null)
                    {
                        names[i] = username;
                    }
                }
            }

            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            if (first)
            {
                prevMonth = month;
                first = false;
            }
            if (month != prevMonth)
            {
                Month newMonthSet = new Month(users, prevMonth);
                months.add(newMonthSet);
                users = new SinglyLinkedList<User>();
                prevMonth = month;
            }

            users.add(
                new User(
                    username,
                    channel,
                    country,
                    comments,
                    likes,
                    followers,
                    views,
                    posts));

        } // end while
    }


    // ----------------------------------------------------------
    /**
     * Turns string into int
     * 
     * @param str
     *            the string to turn to int
     * @return the int value of the string
     */
    private int toInt(String str)
    {

        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Getter for the months singly linked list
     * 
     * @return the months
     */
    public SinglyLinkedList<Month> getMonths()
    {
        return months;
    }


    // ----------------------------------------------------------
    /**
     * Calculates  Q1
     * @param n is name of user
     * @return traditional and reach engagement rates for Q1
     */
    @SuppressWarnings("null")
    public String calcQOne(String n)
    {
        int totalComments = 0;
        int totalLikes = 0;
        int totalFollowers = 0;
        int totalViews = 0;

        // january
        Node<Month> curr = months.getHead();
        while (!curr.getData().getMonthName().equals("January") && curr != null)
        {
            curr = curr.getNext();
        }
        SinglyLinkedList<User> userNames = curr.getData().getNames();
        Node<User> x = userNames.getHead();
        while (!x.getData().getUsername().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalViews += x.getData().getEngagementSet().getLikes();
        }

        // february
        curr = months.getHead();
        while (!curr.getData().getMonthName().equals("February") && curr != null)
        {
            curr = curr.getNext();
        }
        x = userNames.getHead();
        while (!x.getData().getUsername().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalViews += x.getData().getEngagementSet().getLikes();
        }

        // march
        curr = months.getHead();
        while (!curr.getData().getMonthName().equals("February") && curr != null)
        {
            curr = curr.getNext();
        }
        x = userNames.getHead();
        while (!x.getData().getUsername().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalFollowers += x.getData().getEngagementSet().getFollowers();
            totalViews += x.getData().getEngagementSet().getLikes();
        }
        String output = "";
        
        if (totalFollowers != 0)
        {
            double z = (totalComments + totalLikes) * 100.0 / totalFollowers;
            output+=String.valueOf(Math.round(z * 10.0) / 10.0);
        }
        else {
            output +="N/A";
        }
        
        output += ".";
        
        if (totalViews != 0)
        {
            double z = (totalComments + totalLikes) * 100.0 / totalViews;
            output+=String.valueOf(Math.round(z * 10.0) / 10.0);
        }
        else {
            output +="N/A";
        }

        return output;
    }
    
    public String toString() {
        //use calcQOne to get the output for each user (i.e. "3000.4000") and then split the string into trad "3000" and reach "4000"
        //then add to string with format
        return "";
    }

}

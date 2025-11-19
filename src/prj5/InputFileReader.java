package prj5;

import java.util.Arrays;
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
        readInputFile(inputFile);
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
            if (!month.equals(prevMonth))
            {
                Month newMonthSet = new Month(users, prevMonth);
                months.add(newMonthSet);
                users = new SinglyLinkedList<User>();
                prevMonth = month;
            }
            if (!users.contains(
                new User(
                    username,
                    channel,
                    country,
                    comments,
                    likes,
                    followers,
                    views,
                    posts)))
            {
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
            }

        } // end while
        if (users.size() > 0)
        {
            Month lastMonth = new Month(users, prevMonth);
            months.add(lastMonth);
        }
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
     * Calculates Q1's Traditional Engagement Rate
     * 
     * @param n
     *            is name of user
     * @return traditional engagement rates for Q1
     */
    public String calcQOneTrad(String n)
    {
        int totalComments = 0;
        int totalLikes = 0;
        int totalFollowers = 0;
        // january
        Node<Month> curr = months.getHead();
        while (!curr.getData().getMonthName().equals("January")
            && curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        SinglyLinkedList<User> userNames = curr.getData().getNames();
        Node<User> x = userNames.getHead();

        while (!x.getData().getChannelName().equals(n) && x.getNext() != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
        }

        // february
        curr = months.getHead();
        while (!curr.getData().getMonthName().equals("February")
            && curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        x = curr.getData().getNames().getHead();
        while (!x.getData().getChannelName().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
        }

        // march
        curr = months.getHead();
        while (!curr.getData().getMonthName().equals("March")
            && curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        x = curr.getData().getNames().getHead();
        while (!x.getData().getChannelName().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalFollowers += x.getData().getEngagementSet().getFollowers();
        }

        if (totalFollowers != 0)
        {
            double z = (totalComments + totalLikes) * 100.0 / totalFollowers;
            return String.valueOf(Math.round(z * 10.0) / 10.0);
        }
        return "N/A";
    }


    // ----------------------------------------------------------
    /**
     * Calculates Q1's Reach Engagement Rate
     * 
     * @param n
     *            is name of user
     * @return reach engagement rates for Q1
     */
    public String calcQOneReach(String n)
    {
        int totalComments = 0;
        int totalLikes = 0;
        int totalViews = 0;

        // january
        Node<Month> curr = months.getHead();
        while (!curr.getData().getMonthName().equals("January")
            && curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        SinglyLinkedList<User> userNames = curr.getData().getNames();
        Node<User> x = userNames.getHead();

        while (!x.getData().getChannelName().equals(n) && x.getNext() != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalViews += x.getData().getEngagementSet().getViews();
        }

        // february
        curr = months.getHead();
        while (!curr.getData().getMonthName().equals("February")
            && curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        x = curr.getData().getNames().getHead();
        while (!x.getData().getChannelName().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalViews += x.getData().getEngagementSet().getViews();
        }

        // march
        curr = months.getHead();
        while (!curr.getData().getMonthName().equals("March")
            && curr.getNext() != null)
        {
            curr = curr.getNext();
        }
        x = curr.getData().getNames().getHead();
        while (!x.getData().getChannelName().equals(n) && x != null)
        {
            x = x.getNext();
        }
        if (x != null)
        {
            totalComments += x.getData().getEngagementSet().getComments();
            totalLikes += x.getData().getEngagementSet().getLikes();
            totalViews += x.getData().getEngagementSet().getViews();
        }

        if (totalViews != 0)
        {
            double z = (totalComments + totalLikes) * 100.0 / totalViews;
            return String.valueOf(Math.round(z * 10.0) / 10.0);
        }
        return "N/A";
    }


    // ----------------------------------------------------------
    /**
     * toString for Q1
     * 
     * @return string of the engagement rates in Q1
     */
    public String toString()
    {
        // use calcQOne to get the output for each user (i.e. "3000.4000") and
        // then split the string into trad "3000" and reach "4000"
        // then add to string with format

        SinglyLinkedList<User> name = months.getHead().getData().getNames();
        Node<User> curr1 = name.getHead();
        String output = "";

        while (curr1 != null)
        {
            String n = curr1.getData().getChannelName();
            output += curr1.getData().getChannelName() + "\ntraditional: "
                + calcQOneTrad(n) + "\n" + "==========" + "\n";
            curr1 = curr1.getNext();
        }

        output += "**********\n" + "**********\n";

        SinglyLinkedList<User> reach = months.getHead().getData().getReach();
        reach = sortQ1EngagementReach(reach);
        Node<User> curr2 = reach.getHead();
        while (curr2 != null)
        {
            String n = curr2.getData().getChannelName();
            output += curr2.getData().getChannelName() + "\nreach: "
                + calcQOneReach(n) + "\n" + "==========" + "\n";
            curr2 = curr2.getNext();
        }
        return output;
    }


    private SinglyLinkedList<User> sortQ1EngagementReach(
        SinglyLinkedList<User> input)
    {
        SinglyLinkedList<User> sorted = new SinglyLinkedList<User>();
        Node<User> current = input.getHead();

        while (current != null)
        {
            User data = current.getData();
            Node<User> temp = sorted.getHead();
            int insertIndex = 0;
            double currentReach;
            if (!calcQOneReach(current.getData().getChannelName()).equals("N/A"))
            {
                currentReach = Double.parseDouble(
                    calcQOneReach(current.getData().getChannelName()));
            }
            else
            {
                currentReach = -1;
            }
            while (temp != null)
            {
                double tempReach;
                if (!calcQOneReach(temp.getData().getChannelName())
                    .equals("N/A"))
                {
                    tempReach = Double.parseDouble(
                        calcQOneReach(temp.getData().getChannelName()));
                }
                else
                {
                    tempReach = -1;
                }

                if (tempReach > currentReach)
                {
                    temp = temp.getNext();
                    insertIndex++;
                }
                else
                {
                    break;
                }
            }
            sorted.add(insertIndex, data);
            current = current.getNext();
        }
        return sorted;
    }

}

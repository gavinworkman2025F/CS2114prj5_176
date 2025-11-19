package prj5;

import java.util.Scanner;
import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author mjseo
 * @version Nov 18, 2025
 */
public class InputFileReader
{
    private String inputFile;
    private SinglyLinkedList<User> users;

    public InputFileReader(String inputFile)
    {

    }// new DataWindow(EngagementSet)


    public void readInputFile(String file)
    {
        Scanner inStream = IOHelper.createScanner(inputFile);
        inStream.nextLine();// skip header
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

            // if the user is already in the list then just add the new
            // engagegment set
            users.add(new User(month, username, channel, country, mainTopic));
            // else add both user and users new engagement set

        } // end while
    }


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


    public SinglyLinkedList<User> getUsers()
    {
        return users;
    }

}

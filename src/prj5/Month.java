package prj5;

// -------------------------------------------------------------------------
/**
 * Models a month of engagement by storing the name and the users in said month
 * 
 * @author williambovatsek
 * @version Nov 18, 2025
 */
public class Month
{
    private SinglyLinkedList<User> users;
    private String name;

    // ----------------------------------------------------------
    /**
     * Create a new Month object.
     * 
     * @param input
     *            input of users
     * @param month
     *            name of the month
     */
    public Month(SinglyLinkedList<User> input, String month)
    {
        users = input;
        name = month;
    }


    // ----------------------------------------------------------
    /**
     * Sorts by the channel name
     */
    public void sortChannelName()
    {

    }


    // ----------------------------------------------------------
    /**
     * Sorts by traditional engagement
     */
    public void sortEngagementTraditional()
    {

    }


    // ----------------------------------------------------------
    /**
     * Sorts by reach engagement
     */
    public void sortEngagementReach()
    {

    }
}

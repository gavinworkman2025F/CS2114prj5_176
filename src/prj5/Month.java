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
    private SinglyLinkedList<User> usersName;
    private SinglyLinkedList<User> usersTraditional;
    private SinglyLinkedList<User> usersReach;

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
        name = month;
        usersName = new SinglyLinkedList<User>();
        usersTraditional = new SinglyLinkedList<User>();
        usersReach = new SinglyLinkedList<User>();
        sortChannelName(input);
        sortEngagementTraditional(input);
        sortEngagementReach(input);
    }


    // ----------------------------------------------------------
    /**
     * Sorts by the channel name
     */
    public void sortChannelName(SinglyLinkedList<User> input)
    {

    }


    // ----------------------------------------------------------
    /**
     * Sorts by traditional engagement
     */
    public void sortEngagementTraditional(SinglyLinkedList<User> input)
    {

    }


    // ----------------------------------------------------------
    /**
     * Sorts by reach engagement
     */
    public void sortEngagementReach(SinglyLinkedList<User> input)
    {

    }
}

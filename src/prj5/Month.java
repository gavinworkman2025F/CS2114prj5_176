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
     * 
     * @param input
     *            user list to be sorted
     */
    private void sortChannelName(SinglyLinkedList<User> input)
    {
        Node<User> current = input.getHead();

        while (current != null)
        {
            User data = current.getData();
            Node<User> temp = usersName.getHead();

            int insertIndex = 0;

            while (temp != null && temp.getData().getChannelName()
                .compareToIgnoreCase(data.getChannelName()) < 0)
            {
                temp = temp.getNext();
                insertIndex++;
            }

            usersName.add(insertIndex, data);

            current = current.getNext();
        }
    }


    // ----------------------------------------------------------
    /**
     * Sorts by traditional engagement
     * 
     * @param input
     *            user list to be sorted
     */
    private void sortEngagementTraditional(SinglyLinkedList<User> input)
    {
        Node<User> current = input.getHead();

        while (current != null)
        {
            User data = current.getData();
            Node<User> temp = usersTraditional.getHead();

            int insertIndex = 0;

            while (temp != null && temp.getData().getEngagementSet()
                .compareTo(data.getEngagementSet()) > 0)
            {
                temp = temp.getNext();
                insertIndex++;
            }

            usersTraditional.add(insertIndex, data);

            current = current.getNext();
        }
    }


    // ----------------------------------------------------------
    /**
     * Sorts by reach engagement
     * 
     * @param input
     *            user list to be sorted
     */
    private void sortEngagementReach(SinglyLinkedList<User> input)
    {
        Node<User> current = input.getHead();

        while (current != null)
        {
            User data = current.getData();
            Node<User> temp = usersReach.getHead();

            int insertIndex = 0;

            while (temp != null && temp.getData().getEngagementSet()
                .compareToReach(data.getEngagementSet()) > 0)
            {
                temp = temp.getNext();
                insertIndex++;
            }

            usersReach.add(insertIndex, data);

            current = current.getNext();
        }
    }

    // ----------------------------------------------------------
    /**
     * Gets the name of the month
     * 
     * @return month
     */
    public String getMonthName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Get users sorted by names
     * 
     * @return list sorted by names
     */
    public SinglyLinkedList<User> getNames()
    {
        return usersName;
    }


    // ----------------------------------------------------------
    /**
     * Get users sorted by traditional engagement
     * 
     * @return list sorted by traditional engagement
     */
    public SinglyLinkedList<User> getTraditional()
    {
        return usersReach;
    }

}

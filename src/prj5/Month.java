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
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * toString (for console)
     * 
     * @return string of channel names and traditional/reach engagement rates
     */
    public String toString()
    {
        Node<User> curr = usersName.getHead();

        String s = "";
        for (int i = 0; i < usersName.size(); i++)
        {
            s += curr.getData().getChannelName() + "\n";
            String trad;
            if (curr.getData().getEngagementSet()
                .calculateTraditionalEngagement() < 0)
            {
                trad = "N/A";
            }
            else
            {
                trad = String.valueOf(
                    curr.getData().getEngagementSet()
                        .calculateTraditionalEngagement());
            }
            s += "traditional: " + trad + "\n==========" + "\n";
            curr = curr.getNext();
        }
        s += "**********\n" + "**********\n";

        curr = usersName.getHead();
        for (int i = 0; i < usersName.size(); i++)
        {
            s += curr.getData().getChannelName() + "\n";
            String rea;
            if (curr.getData().getEngagementSet()
                .calculateReachEngagement() < 0)
            {
                rea = "N/A";
            }
            else
            {
                rea = String.valueOf(
                    curr.getData().getEngagementSet()
                        .calculateReachEngagement());
            }
            s += "traditional: " + rea + "\n==========" + "\n";
            curr = curr.getNext();
        }
        return s;
    }
}

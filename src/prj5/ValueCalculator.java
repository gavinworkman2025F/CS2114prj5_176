package prj5;

// -------------------------------------------------------------------------
/**
 * Class used to sort the users based on various criteria.
 * 
 * @author williambovatsek
 * @version Nov 18, 2025
 */
public class ValueCalculator
{
    private SinglyLinkedList<User> users;

    // ----------------------------------------------------------
    /**
     * Create a new ValueCalculator object.
     * 
     * @param input
     *            input from the file reader
     */
    public ValueCalculator(SinglyLinkedList<User> input)
    {
        users = input;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the users alphabetically by channel name
     */
    public void sortChannelName()
    {

    }


    // ----------------------------------------------------------
    /**
     * Sorts the users based on pure engagement.
     * 
     * @param month
     *            month to be sorted by
     */
    public void sortEngagement(String month)
    {
        SinglyLinkedList<EngagementSet> usersEngagementSets =
            getUsersEngagementSets(month);
    }


    // ----------------------------------------------------------
    /**
     * Sorts the users based on engagement reach.
     * 
     * @param month
     *            month to be sorted by
     */
    public void sortEngagementReach(String month)
    {
        SinglyLinkedList<EngagementSet> usersEngagementSets =
            getUsersEngagementSets(month);
    }


    // ----------------------------------------------------------
    /**
     * Gets the engagement set for a particular moth for each user.
     * 
     * @param month
     *            the particular month
     */
    private SinglyLinkedList<EngagementSet> getUsersEngagementSets(String month)
    {
        Node<User> currentUser = users.getHead();
        SinglyLinkedList<EngagementSet> esList;
        User user;
        Node<EngagementSet> currentEs;
        SinglyLinkedList<EngagementSet> usersEngagementSets =
            new SinglyLinkedList<EngagementSet>();
        while (currentUser != null)
        {
            user = currentUser.getData();
            esList = user.getEngagementSets();
            currentEs = esList.getHead();
            while (currentEs.getData().getMonth() != month)
            {
                currentEs.getNext();
            }
            usersEngagementSets.add(currentEs.getData());

        }
        return usersEngagementSets;
    }
}

package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test User class
 * 
 * @author mjseo
 * @version Nov 18, 2025
 */
public class UserTest
    extends TestCase
{
    private User user1;
    private User user2;

    // ----------------------------------------------------------
    /**
     * Initializes users to be used in testing.
     */
    public void setUp()
    {
        user1 =
            new User("1username", "1channelName", "1country", 1, 1, 1, 1, 1);
        user2 =
            new User("2username", "2channelName", "2country", 2, 2, 2, 2, 2);
    }


    // ----------------------------------------------------------
    /**
     * Test getUsername(), getChannelName(), getCountry(), getPosts(),
     * getEngagementSet()
     */
    public void testGetters()
    {
        assertEquals(user1.getUsername(), "1username");
        assertEquals(user1.getChannelName(), "1channelName");
        assertEquals(user1.getCountry(), "1country");
        assertEquals(user1.getPosts(), 1);
        assertNotNull(user1.getEngagementSet());
        assertEquals(user1.getEngagementSet().getComments(), 1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the compareTo for User which compares based off of channel name
     */
    public void testCompareTo()
    {
        assertTrue(user1.compareTo(user2) < 0);
        assertTrue(user2.compareTo(user1) > 0);
        assertEquals(user1.compareTo(user1), 0);
    }

}

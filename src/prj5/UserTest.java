package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test User class
 * 
 *  @author mjseo
 *  @version Nov 18, 2025
 */
public class UserTest extends TestCase
{
    private User user1;
    private User user2;
    
    public void setUp() {
        user1 = new User("1username", "1channelName", "1country", 1, 1, 1, 1, 1);
        user2 = new User("2username", "2channelName", "2country", 2, 2, 2, 2, 2);
    }
    
    public void testGetters() {
        assertEquals(user1.getUsername(), "1username");
        assertEquals(user1.getChannelName(), "1channelName");
        assertEquals(user1.getCountry(), "1country");
        assertEquals(user1.getPosts(), 1);
        assertNotNull(user1.getEngagementSet());
        assertEquals(user1.getEngagementSet().getComments(), 1);
    }
    
    public void testCompareTo() {
        assertTrue(user1.compareTo(user2) < 0);
        assertTrue(user2.compareTo(user1) > 0);
        assertTrue(user1.compareTo(user1) == 0);
    }

}

// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Timothy Park (tim0thy)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

package prj5;

import static org.junit.Assert.*;

// -------------------------------------------------------------------------
/**
 * Test class for EngagementSet
 * 
 * @author timothypark
 * @version Nov 18, 2025
 */
public class EngagementSetTest
    extends student.TestCase
{
    private EngagementSet a;

    public void setUp()
    {
        a = new EngagementSet(5, 5, 10, 15, "January");
    }


    // ----------------------------------------------------------
    /**
     * Tests calculateTraditionalEngagementRate
     */
    public void testCalculateTraditionalEngagementRate()
    {
        assertEquals(100.0, a.calculateTraditionalEngagement(), 0.000000001);
    }


    // ----------------------------------------------------------
    /**
     * Tests calculateTraditionalEngagementRate
     */
    public void testCalculateReachEngagementRate()
    {
        assertEquals(66.7, a.calculateReachEngagement(), 0.000000001);
    }


    // ----------------------------------------------------------
    /**
     * Tests getComments
     */
    public void testGetComments()
    {
        assertEquals(5, a.getComments());
    }


    // ----------------------------------------------------------
    /**
     * Tests getComments
     */
    public void testGetLikes()
    {
        assertEquals(5, a.getLikes());
    }


    // ----------------------------------------------------------
    /**
     * Tests getComments
     */
    public void testGetFollowers()
    {
        assertEquals(10, a.getFollowers());
    }


    // ----------------------------------------------------------
    /**
     * Tests getComments
     */
    public void testGetViews()
    {
        assertEquals(15, a.getViews());
    }


    // ----------------------------------------------------------
    /**
     * Tests getMonth
     */
    public void testGetMonth()
    {
        assertEquals("January", a.getMonth());
    }


    // ----------------------------------------------------------
    /**
     * Tests compareTo
     */
    public void testCompareTo()
    {
        EngagementSet b = new EngagementSet(4, 4, 10, 15, "March");
        EngagementSet c = new EngagementSet(6, 6, 10, 15, "April");
        EngagementSet d = new EngagementSet(5, 5, 10, 15, "March");

        assertEquals(1, a.compareTo(b));
        assertEquals(0, a.compareTo(d));
        assertEquals(-1, a.compareTo(c));
    }


    // ----------------------------------------------------------
    /**
     * Tests compareTo
     */
    public void testCompareToReach()
    {
        EngagementSet b = new EngagementSet(4, 4, 10, 15, "March");
        EngagementSet c = new EngagementSet(6, 6, 10, 15, "April");
        EngagementSet d = new EngagementSet(5, 5, 10, 15, "March");

        assertEquals(1, a.compareToReach(b));
        assertEquals(0, a.compareToReach(d));
        assertEquals(-1, a.compareToReach(c));
    }

}

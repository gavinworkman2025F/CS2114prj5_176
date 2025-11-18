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

// -------------------------------------------------------------------------
/**
 * Sets the engagement metrics and calculates the engagement level
 * 
 * @author timothypark
 * @version Nov 18, 2025
 */
public class EngagementSet
    implements Comparable<EngagementSet>
{
    private int comments;
    private int likes;
    private int followers;
    private int views;
    private String month;

    // ----------------------------------------------------------
    /**
     * Create a new EngagementSet object.
     * 
     * @param c
     * @param l
     * @param f
     * @param v
     * @param m
     */
    public EngagementSet(int c, int l, int f, int v, String m)
    {
        comments = c;
        likes = l;
        followers = f;
        views = v;
        month = m;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the traditional engagement
     * 
     * @return the traditional engagement
     */
    public int calculateTraditionalEngagement()
    {
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * Calcualtes the reach engagement
     * 
     * @return the reach engagement
     */
    public int calculateReachEngagement()
    {
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the month
     * 
     * @return this engagement set's month
     */
    public String getMonth()
    {
        return month;
    }


    @Override
    public int compareTo(EngagementSet o)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}

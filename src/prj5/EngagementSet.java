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
 * Sets the engagement metrics and calculates the engagement rate
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
     *            is # of comments
     * @param l
     *            is # of likes
     * @param f
     *            is # of followers
     * @param v
     *            is # of views
     * @param m
     *            is # of months
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
     * Gets the traditional engagement
     * 
     * @return the traditional engagement
     */
    public double calculateTraditionalEngagement()
    {
        double x = (comments + likes) * 100.0 / followers;
        return Math.round(x * 10.0) / 10.0;
    }


    // ----------------------------------------------------------
    /**
     * Gets the reach engagement
     * 
     * @return the reach engagement
     */
    public double calculateReachEngagement()
    {
        double x = (comments + likes) * 100.0 / views;
        return Math.round(x * 10.0) / 10.0;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the number comments
     * 
     * @return this engagement set's comments
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the number of likes
     * 
     * @return this engagement set's likes
     */
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the number of followers
     * 
     * @return this engagement set's followers
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the number of views
     * 
     * @return this engagement set's views
     */
    public int getViews()
    {
        return views;
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
    // default compareTo method for traditional engagement comparison
    public int compareTo(EngagementSet o)
    {
        if (this.calculateTraditionalEngagement() > o
            .calculateTraditionalEngagement())
        {
            return 1;
        }
        else if (this.calculateTraditionalEngagement() < o
            .calculateTraditionalEngagement())
        {
            return -1;
        }
        return 0;
    }


    // ----------------------------------------------------------
    /**
     * compareTo method for reach engagement comparison instead of traditional
     * 
     * @param o
     *            is other EngagementSet
     * @return positive if this is greater, negative if less than other, 0 if
     *             equal
     */
    public int compareToReach(EngagementSet o)
    {
        if (this.calculateReachEngagement() > o.calculateReachEngagement())
        {
            return 1;
        }
        else if (this.calculateReachEngagement() < o.calculateReachEngagement())
        {
            return -1;
        }
        return 0;
    }

}

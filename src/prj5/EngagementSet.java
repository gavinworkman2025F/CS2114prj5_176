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
    private double traditionalEngagementRate;
    private double reachEngagementRate;
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
        double x = (c + l) * 100.0 / f;
        traditionalEngagementRate = Math.round(x * 10.0) / 10.0;

        double y = (c + l) * 100.0 / v;
        reachEngagementRate = Math.round(y * 10.0) / 10.0;

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
        return traditionalEngagementRate;
    }


    // ----------------------------------------------------------
    /**
     * Gets the reach engagement
     * 
     * @return the reach engagement
     */
    public double calculateReachEngagement()
    {
        return reachEngagementRate;
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

}

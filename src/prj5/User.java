package prj5;

// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Matthew Seo (mjseo)
// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.
// -------------------------------------------------------------------------
/**
 * Creates a new user object with values and engagement sets over different
 * months.
 * 
 * @author mjseo
 * @version Nov 18, 2025
 */
public class User
    implements Comparable<User>
{
    private String username;
    private String channelName;
    private String country;
    private int numPosts;
    private EngagementSet engagement;

    // ----------------------------------------------------------
    /**
     * Instantiates a new user with an empty engagementSet.
     * 
     * @param username
     *            the name of the user
     * @param channelName
     *            the channel name of the user
     * @param country
     *            the country of the user
     * @param numPosts
     *            the number of posts by the user
     */
    public User(
        String username,
        String channelName,
        String country,
        int comments,
        int likes,
        int followers,
        int views,
        int numPosts)
    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.numPosts = numPosts;
        engagement = new EngagementSet(comments, likes, followers, views);

    }


    // ----------------------------------------------------------
    /**
     * Getter for the username of the user
     * 
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the name of the channel of the user
     * 
     * @return the channel
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the country of the user
     * 
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Getter for number of posts
     * 
     * @return the number of posts
     */
    public int getPosts()
    {
        return numPosts;
    }


    // ----------------------------------------------------------
    /**
     * Getter for engagementSets
     * 
     * @return the engagementSets
     */
    public EngagementSet getEngagementSet()
    {
        return engagement;
    }


    // ----------------------------------------------------------
    /**
     * Compares two users by comparing their name. eg.) A>B
     * 
     * @return A positive number if name is greater than object compared to,
     *             negative is less, and 0 ifequal.
     */
    public int compareTo(User other)
    {
        String name1 = this.getUsername();
        String name2 = other.getUsername();

        return name1.compareTo(name2);
    }
}

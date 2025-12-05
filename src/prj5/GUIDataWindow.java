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

package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import java.awt.*;

// -------------------------------------------------------------------------
/**
 * The data GUI tht displays each channel name and engagements with sorting
 * 
 * @author mjseo
 * @version Dec 4, 2025
 */
public class GUIDataWindow
{
    private InputFileReader reader;
    private Window window;

    private String currentMonth = "Q1";
    private boolean sortByEngagement = false;
    private boolean useTraditional = true;

    private static Color[] colors = new Color[4];
    private static final double DISPLAY_FACTOR = 1.5;

    // ----------------------------------------------------------
    /**
     * Creation of a new Window and Buttons
     * 
     * @param reader
     *            the file read and sorted
     */
    public GUIDataWindow(InputFileReader reader)
    {
        this.reader = reader;
        window = new Window("mjseo tim0thy gavinworkman wbovatsek29");
        window
            .setSize((int)(700 * DISPLAY_FACTOR), (int)(400 * DISPLAY_FACTOR));

        Button sortChannel = new Button("Sort by Channel Name");
        window.addButton(sortChannel, WindowSide.NORTH);
        sortChannel.onClick(this, "clickedSortChannel");

        Button sortEngagement = new Button("Sort by Engagement Rate");
        window.addButton(sortEngagement, WindowSide.NORTH);
        sortEngagement.onClick(this, "clickedSortEngagement");

        Button quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        Button jan = new Button("January");
        window.addButton(jan, WindowSide.SOUTH);
        jan.onClick(this, "clickedJan");

        Button feb = new Button("Febuary");
        window.addButton(feb, WindowSide.SOUTH);
        feb.onClick(this, "clickedFeb");

        Button mar = new Button("March");
        window.addButton(mar, WindowSide.SOUTH);
        mar.onClick(this, "clickedMar");

        Button quarter = new Button("First Quarter (Jan - March)");
        window.addButton(quarter, WindowSide.SOUTH);
        quarter.onClick(this, "clickedQuarter");

        Button traditionalEngagement =
            new Button("Traditional Engagement Rate");
        window.addButton(traditionalEngagement, WindowSide.WEST);
        traditionalEngagement.onClick(this, "clickedTraditionalEngagement");

        Button reachEngagement = new Button("Reach Engagement Rate");
        window.addButton(reachEngagement, WindowSide.WEST);
        reachEngagement.onClick(this, "clickedReachEngagement");

        colors[0] = new Color(255, 150, 0); // orange
        colors[1] = new Color(51, 92, 103); // blue
        colors[2] = new Color(64, 64, 64); // dark gray
        colors[3] = new Color(34, 84, 44); // green

        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method to sort by name
     * 
     * @param button
     *            the button pressed
     */
    public void clickedSortChannel(Button button)
    {
        sortByEngagement = false;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method to sort by engagement rate
     * 
     * @param button
     *            the button pressed
     */
    public void clickedSortEngagement(Button button)
    {
        sortByEngagement = true;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method to display and sort by traditional engagement
     * 
     * @param button
     *            the button pressed
     */
    public void clickedTraditionalEngagement(Button button)
    {
        useTraditional = true;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method to display and sort by reach engagement
     * 
     * @param button
     *            the button pressed
     */
    public void clickedReachEngagement(Button button)
    {
        useTraditional = false;
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method to kill the program
     * 
     * @param button
     *            the button pressed
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Handler method for January to display January statistics
     * 
     * @param button
     *            the button pressed
     */
    public void clickedJan(Button button)
    {
        currentMonth = "January";
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method for February to display February statistics
     * 
     * @param button
     *            the button pressed
     */
    public void clickedFeb(Button button)
    {
        currentMonth = "February";
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method for March to display March statistics
     * 
     * @param button
     *            the button pressed
     */
    public void clickedMar(Button button)
    {
        currentMonth = "March";
        update();
    }


    // ----------------------------------------------------------
    /**
     * Handler method for First Quarter to display first quarter statistics
     * 
     * @param button
     *            the button pressed
     */
    public void clickedQuarter(Button button)
    {
        currentMonth = "Q1";
        update();
    }


    // ----------------------------------------------------------
    /**
     * Removes all shapes and then redraws all shapes based on new input values
     */
    private void update()
    {
        window.removeAllShapes();
        drawShapes();
    }


    // ----------------------------------------------------------
    /**
     * Returns respective strings for each time period buttons on the GUI
     * 
     * @param String
     *            the month
     * @return the repsective stirng for each month button
     */
    private String months(String month)
    {
        switch (month)
        {
            case "January":
                return "January";
            case "February":
                return "February";
            case "March":
                return "March";
            default:
                return "First Quarter (Jan-March)";
        }

    }


    // ----------------------------------------------------------
    /**
     * Makes and adds all shapes on the GUI using updated input values
     */
    private void drawShapes()
    {
        TextShape month = new TextShape(20, 20, months(currentMonth));

        TextShape engagement = new TextShape(
            20,
            40,
            useTraditional
                ? "Traditional Engagement Rate"
                : "Reach Engagement Rate");

        TextShape sorting = new TextShape(
            20,
            60,
            sortByEngagement
                ? "Sorting by Engagement Rate"
                : "Sorting by Channel Name");

        window.addShape(month);
        window.addShape(engagement);
        window.addShape(sorting);

        Month monthUsers = reader.getMonth(currentMonth);

        SinglyLinkedList<User> currDisplay;

        if (sortByEngagement)
        {
            if (useTraditional)
            {
                currDisplay = monthUsers.getTraditional();
            }
            else
            {
                currDisplay = monthUsers.getReach();
            }
        }
        else
        {
            currDisplay = monthUsers.getNames();
        }

        // Setup for sizing and spacing
        int size = currDisplay.size();

        int windowWidth = window.getWidth() - 150;
        int windowHeight = window.getHeight() - 150;

        int bottomMargin = 50;
        int maxBarHeight = (int)(windowHeight * 0.65);

        int availableWidth = windowWidth - 40;

        int barWidth = availableWidth / (size * 2);
        if (barWidth < 20)
        {
            barWidth = 20;
        }

        int spacing = Math.max(barWidth / 3, 8);

        int totalWidthNeeded = size * barWidth + (size + 1) * spacing;
        if (totalWidthNeeded > availableWidth)
        {
            barWidth = (availableWidth - (size + 1) * spacing) / size;
            barWidth = Math.max(barWidth, 20);
        }

        Node<User> head = currDisplay.getHead();
        int i = 0; // index
        int x = (windowWidth - (size * barWidth + (size - 1) * spacing)) / 2;

        while (head != null)
        {
            User user = head.getData();

            int barHeight;
            if (useTraditional)
            {
                barHeight = Math.min(
                    (int)(user.getEngagementSet()
                        .calculateTraditionalEngagement() * 2),
                    maxBarHeight);
            }
            else
            {
                barHeight = Math.min(
                    (int)(user.getEngagementSet().calculateReachEngagement() *15),
                    maxBarHeight);
            }

            int y = windowHeight - bottomMargin - barHeight;

            Color color = colors[i % colors.length];

            Shape bar = new Shape(x, y, barWidth, barHeight, color);
            window.addShape(bar);

            TextShape channel = new TextShape(
                x,
                windowHeight - bottomMargin + 10,
                user.getChannelName());
            window.addShape(channel);

            if (useTraditional)
            {
                TextShape engagementRate = new TextShape(
                    x,
                    windowHeight - bottomMargin + 30,
                    Double.toString(
                        user.getEngagementSet()
                            .calculateTraditionalEngagement()));
                window.addShape(engagementRate);
            }
            else
            {
                TextShape engagementRate = new TextShape(
                    x,
                    windowHeight - bottomMargin + 30,
                    Double.toString(
                        user.getEngagementSet().calculateReachEngagement()));
                window.addShape(engagementRate);
            }

            x += barWidth + spacing;
            i++;
            head = head.getNext();
        }
    }
}

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

// -------------------------------------------------------------------------
/**
 * The data GUI tht displays each channel name and engagements with sorting
 * 
 * @author mjseo
 * @version Dec 4, 2025
 */
public class DataWindow
{
    private InputFileReader reader;
    private Window window;

    private String currentMonth = "All";
    private boolean sortByEngagement = false; // false = alpha sort
    private boolean useTraditional = true;

    private Button sortChannel;
    private Button sortEngagement;

    private Button traditionalEngagement;
    private Button reachEngagement;

    private Button jan;
    private Button feb;
    private Button mar;
    private Button quarter;

    private Button quit;

    public DataWindow(InputFileReader reader)
    {
        this.reader = reader;
        window = new Window("mjseo, tim0thy, gavinworkman, williambovatsek29");
        window.setSize(1600, 900);

        sortChannel = new Button("Sort by Channel Name");
        window.addButton(sortChannel, WindowSide.NORTH);
        sortChannel.onClick(this, "clickedSortChannel");

        sortEngagement = new Button("Sort by Engagement Rate");
        window.addButton(sortEngagement, WindowSide.NORTH);
        sortEngagement.onClick(this, "clickedSortEngagement");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        jan = new Button("January");
        window.addButton(jan, WindowSide.SOUTH);
        jan.onClick(this, "clickedJan");

        feb = new Button("Febuary");
        window.addButton(feb, WindowSide.SOUTH);
        feb.onClick(this, "clickedFeb");

        mar = new Button("March");
        window.addButton(mar, WindowSide.SOUTH);
        mar.onClick(this, "clickedMar");

        quarter = new Button("First Quarter (Jan - March)");
        window.addButton(quarter, WindowSide.SOUTH);
        quarter.onClick(this, "clickedQuarter");

        traditionalEngagement = new Button("Traditional Engagement Rate");
        window.addButton(traditionalEngagement, WindowSide.WEST);
        traditionalEngagement.onClick(this, "clickedTraditionalEngagement");

        reachEngagement = new Button("Reach Engagement Rate");
        window.addButton(reachEngagement, WindowSide.WEST);
        reachEngagement.onClick(this, "clickedReachEngagement");

        update();
    }


    public void clickedSortChannel(Button button)
    {
        sortByEngagement = false;
        update();
    }


    public void clickedSortEngagement(Button button)
    {
        sortByEngagement = true;
        update();
    }


    public void clickedTraditionalEngagement(Button button)
    {
        useTraditional = true;
        update();
    }


    public void clickedReachEngagement(Button button)
    {
        useTraditional = false;
        update();
    }


    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    public void clickedJan(Button button)
    {
        currentMonth = "January";
        update();
    }


    public void clickedFeb(Button button)
    {
        currentMonth = "Febuary";
        update();
    }


    public void clickedMar(Button button)
    {
        currentMonth = "March";
        update();
    }


    public void clickedQuarter(Button button)
    {
        currentMonth = "Quarter";
        update();
    }


    private void update()
    {
        window.removeAllShapes();
        drawShapes();
    }


    private void drawShapes()
    {

    }
}

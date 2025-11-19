package prj5;
// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- William Bovatsek (wbovatsek29)
// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the month class and its methods with multiple test cases.
 * 
 * @author williambovatsek
 * @version Nov 19, 2025
 */
public class MonthTest
    extends TestCase
{
    private Month m1;
    private SinglyLinkedList<User> list1;
    private User u1;
    private User u2;
    private User u3;
    private User u4;

    public void setUp()
    {
        u2 = new User("user2", "channel1", "country1", 100, 100, 100, 200, 100);
        u1 = new User("user1", "channel2", "country1", 100, 100, 200, 100, 100);
        u3 = new User("user3", "channel3", "country1", 100, 100, 300, 300, 100);
        u4 = new User("user4", "channel4", "country1", 100, 100, 50, 50, 100);
        list1 = new SinglyLinkedList<User>();
        list1.add(u1);
        list1.add(u2);
        list1.add(u3);
        list1.add(u4);
        m1 = new Month(list1, "month1");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMonthName method
     */
    public void testGetMonthName()
    {
        assertEquals(m1.getMonthName(), "month1");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getNames method
     */
    public void testGetNames()
    {
        Node<User> curr = m1.getNames().getHead();
        assertEquals(curr.getData(), u2);
        curr = curr.getNext();
        assertEquals(curr.getData(), u1);
        curr = curr.getNext();
        assertEquals(curr.getData(), u3);
        curr = curr.getNext();
        assertEquals(curr.getData(), u4);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getTraditional method
     */
    public void testGetTraditional()
    {
        Node<User> curr = m1.getTraditional().getHead();
        assertEquals(curr.getData(), u4);
        curr = curr.getNext();
        assertEquals(curr.getData(), u2);
        curr = curr.getNext();
        assertEquals(curr.getData(), u1);
        curr = curr.getNext();
        assertEquals(curr.getData(), u3);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getReach method
     */
    public void testGetReach()
    {
        Node<User> curr = m1.getReach().getHead();
        assertEquals(curr.getData(), u4);
        curr = curr.getNext();
        assertEquals(curr.getData(), u1);
        curr = curr.getNext();
        assertEquals(curr.getData(), u2);
        curr = curr.getNext();
        assertEquals(curr.getData(), u3);
    }

}

// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Gavin Workman (gavinworkman)

// LLM Statement:

// During the preparation of this assignment, I, Gavin Workman, used Gemini in
// this file to help achieve 100% code coverage through my tests.
// After using this tool, I reviewed and edited the content as needed to ensure
// its accuracy and take full responsibility for the content in relation to
// grading. I understand that I am responsible for being able to complete this
// work without the use of assistance.

package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the methods of the node class
 * 
 * @author gjwor
 * @version Nov 18, 2025
 */
public class NodeTest
    extends TestCase
{

    private Node<String> test1;
    private Node<String> test2;

    public void setUp()
    {
        test2 = new Node<String>("test2", null);
        test1 = new Node<String>("test1", test2);
    }


    // ----------------------------------------------------------
    /**
     * tests the getNext method
     */
    public void testGetNext()
    {
        assertEquals(test2, test1.getNext());
        assertEquals(null, test2.getNext());
    }


    // ----------------------------------------------------------
    /**
     * tests the getData method
     */
    public void testGetData()
    {
        assertEquals("test1", test1.getData());
        test2.setData(null);
        assertNull(test2.getData());
    }


    // ----------------------------------------------------------
    /**
     * tests the setData method
     */
    public void testSetData()
    {
        test1.setData("different");
        assertEquals("different", test1.getData());
    }


    // ----------------------------------------------------------
    /**
     * tests the setNext method
     */
    public void testSetNext()
    {
        Node<String> test3 = new Node<String>("test3", null);

        test1.setNext(test3);
        assertEquals(test3, test1.getNext());

        test1.setNext(null);
        assertNull(test1.getNext());
    }

}

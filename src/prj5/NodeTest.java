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

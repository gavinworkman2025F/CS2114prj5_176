package prj5;

import student.TestCase;

public class nodeTest
    extends TestCase
{

    private Node<String> test1;
    private Node<String> test2;

    public void setUp()
    {
        test2 = new Node<String>("test2", null);
        test1 = new Node<String>("test1", test2);
    }


    public void testGetNext()
    {
        assertEquals(test2, test1.getNext());
        assertEquals(null, test2.getNext());
    }


    public void testGetData()
    {
        assertEquals("test1", test1.getData());
        test2.setData(null);
        assertNull(test2.getData());
    }


    public void testSetData()
    {
        test1.setData("different");
        assertEquals("different", test1.getData());
    }


    public void testSetNext()
    {
        Node<String> test3 = new Node<String>("test3", null);

        test1.setNext(test3);
        assertEquals(test3, test1.getNext());

        test1.setNext(null);
        assertNull(test1.getNext());
    }

}

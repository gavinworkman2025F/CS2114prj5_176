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
 * Tests the methods of the SinglyLinkedList class
 * 
 * @author gjwor
 * @version Nov 18, 2025
 */
public class SinglyLinkedListTest
    extends TestCase
{

    private SinglyLinkedList<String> test;
    private SinglyLinkedList<String> emptyList;

    /**
     * Sets up the test environment.
     */
    public void setUp()
    {
        // This list will be: head -> "World" -> "Hello" -> null
        test = new SinglyLinkedList<String>();
        test.add("Hello");
        test.add("World");

        emptyList = new SinglyLinkedList<String>();
    }


    /**
     * Tests the size() method.
     */
    public void testSize()
    {
        assertEquals(2, test.size());
        assertEquals(0, emptyList.size());
        test.add("Another");
        assertEquals(3, test.size());
    }


    /**
     * Tests the isEmpty() method.
     */
    public void testIsEmpty()
    {
        assertFalse(test.isEmpty());
        assertTrue(emptyList.isEmpty());
        test.clear();
        assertTrue(test.isEmpty());
    }


    /**
     * Tests the clear() method.
     */
    public void testClear()
    {
        test.clear();
        assertEquals(0, test.size());
        assertNull(test.getHead());
        assertTrue(test.isEmpty());
    }


    /**
     * Tests the getHead() method.
     */
    public void testGetHead()
    {
        assertNull(emptyList.getHead());
        assertNotNull(test.getHead());
        assertEquals("World", test.getHead().getData());
    }


    /**
     * Tests the add(T data) method (add to front).
     */
    public void testAdd()
    {
        test.add("Start");
        assertEquals(3, test.size());
        assertEquals("Start", test.getHead().getData());
        assertEquals("World", test.getHead().getNext().getData());
        assertEquals("Hello", test.getHead().getNext().getNext().getData());
    }


    /**
     * Tests the add(int index, T data) method.
     */
    public void testAddAtInt()
    {
        // List: "World" -> "Hello"
        test.add(0, "Start");
        // New List: "Start" -> "World" -> "Hello"
        assertEquals(3, test.size());
        assertEquals("Start", test.getHead().getData());
        assertEquals("World", test.getHead().getNext().getData());

        // Reset
        setUp();

        // Case 2: Add at index 1
        test.add(1, "Middle");
        // New List: "World" -> "Middle" -> "Hello"
        assertEquals(3, test.size());
        assertEquals("World", test.getHead().getData());
        assertEquals("Middle", test.getHead().getNext().getData());
        assertEquals("Hello", test.getHead().getNext().getNext().getData());

        // Reset
        setUp();

        // Case 3: Add at index 2 (end)
        // List: "World" -> "Hello"
        test.add(2, "End");
        // New List: "World" -> "Hello" -> "End"
        assertEquals(3, test.size());
        assertEquals("World", test.getHead().getData());
        assertEquals("Hello", test.getHead().getNext().getData());
        assertEquals("End", test.getHead().getNext().getNext().getData());
        assertNull(test.getHead().getNext().getNext().getNext()); // Check new
                                                                  // end

        // Case 4: Add to empty list at index 0
        emptyList.add(0, "Only");
        assertEquals(1, emptyList.size());
        assertEquals("Only", emptyList.getHead().getData());
        assertNull(emptyList.getHead().getNext());

        // Case 5: Test out of bounds (should throw exception)
        Exception exception = null;
        try
        {
            // Try to add at index 5 (valid indices are 0, 1, 2)
            test.add(5, "TooFar");
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(
            "add() should throw IndexOutOfBoundsException for index > size",
            exception);

        exception = null;
        try
        {
            // Try to add at index -1
            test.add(-1, "Negative");
        }
        catch (IndexOutOfBoundsException e)
        {
            exception = e;
        }
        assertNotNull(
            "add() should throw IndexOutOfBoundsException for index < 0",
            exception);
    }


    /**
     * Tests the remove(T data) method.
     */
    public void testRemove()
    {
        // Case 1: Remove from empty list
        assertFalse(emptyList.remove("Nope"));
        assertEquals(0, emptyList.size());

        // Case 2: Remove item not in list
        // List: "World" -> "Hello"
        assertFalse(test.remove("Goodbye"));
        assertEquals(2, test.size()); // Size should be unchanged

        // Case 3: Remove the head
        assertTrue(test.remove("World"));
        assertEquals(1, test.size());
        assertEquals("Hello", test.getHead().getData());

        // Reset
        setUp();

        // Case 4: Remove the tail/middle item
        // List: "World" -> "Hello"
        assertTrue(test.remove("Hello"));
        assertEquals(1, test.size());
        assertEquals("World", test.getHead().getData());
        assertNull(test.getHead().getNext()); // Make sure "World" is now the
                                              // end

        // Case 5: Remove all items
        assertTrue(test.remove("World"));
        assertEquals(0, test.size());
        assertNull(test.getHead());
        assertFalse(test.remove("Hello")); // Can't remove from empty list
    }


    /**
     * Tests the contains(T data) method.
     */
    public void testContains()
    {
        // Case 1: Empty list
        assertFalse(emptyList.contains("Hello"));

        // Case 2: Item is present (head)
        assertTrue(test.contains("World"));

        // Case 3: Item is present (not head)
        assertTrue(test.contains("Hello"));

        // Case 4: Item is not present
        assertFalse(test.contains("Goodbye"));

        // Case 5: Check for null
        assertFalse(test.contains(null));
    }
}

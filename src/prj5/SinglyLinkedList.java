// Project 5 Fall 2025
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Gavin Workman (gavinworkman)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

package prj5;

// -------------------------------------------------------------------------
/**
 * Contains the necessary methods for the SinglyLinkedList data structure
 * 
 * @param <T>
 * @author gjwor
 * @version Nov 18, 2025
 */
public class SinglyLinkedList<T>
{

    private Node<T> head;
    private int size;

    // ----------------------------------------------------------
    /**
     * Create a new SinglyLinkedList object.
     */
    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * getter for the size of a list
     * 
     * @return the size of the linked list
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Adds an object at a certain index
     * 
     * @param index
     *            the index to add the data at in the list
     * @param data
     *            the data to add at the specified index
     */
    public void add(int index, T data)
    {

        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + size);
        }

        if (index == 0)
        {
            Node<T> newNode = new Node<T>(data, head);
            head = newNode;
        }

        else
        {

            Node<T> curr = head;
            for (int i = 0; i < index - 1; i++)
            {
                curr = curr.getNext();
            }

            Node<T> newNode = new Node<T>(data, curr.getNext());

            curr.setNext(newNode);
        }

        size++;
    }


    // ----------------------------------------------------------
    /**
     * adds data to the front of a list
     * 
     * @param data
     *            the data to add
     */
    public void add(T data)
    {
        if (head == null)
        {
            Node<T> node = new Node<T>(data, null);
            head = node;

        }
        else
        {
            Node<T> node = new Node<T>(data, head);
            head = node;
        }

        size++;
    }


    // ----------------------------------------------------------
    /**
     * getter for the head field
     * 
     * @return the first node in the list
     */
    public Node<T> getHead()
    {
        return head;
    }


    // ----------------------------------------------------------
    /**
     * checks if the list is empty or not
     * 
     * @return true if its empty, false if now
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    // ----------------------------------------------------------
    /**
     * Iterates through list and removes the first found instance from the list
     * 
     * @param data
     *            the data of the node to be removed from the list
     * @return true if it works, false if not
     */
    public boolean remove(T data)
    {
        if (isEmpty())
        {
            return false;
        }

        // Remove the head
        if (head.getData().equals(data))
        {
            head = head.getNext();
            size--;
            return true;
        }

        // Remove from middle or end
        Node<T> curr = head;

        // Loop while the next node exists and is not the one we want
        while (curr.getNext() != null && !curr.getNext().getData().equals(data))
        {
            curr = curr.getNext();
        }

        // If curr.getNext() is null, we reached the end and didn't find the
        // data
        if (curr.getNext() == null)
        {
            return false;
        }

        curr.setNext(curr.getNext().getNext());
        size--;
        return true;
    }


    // ----------------------------------------------------------
    /**
     * iterates through the list to check if a specified value is present
     * 
     * @param data
     *            the value to look for in the list
     * @return true if found, false if not
     */
    public boolean contains(T data)
    {
        if (data == null)
        {
            return false;
        }

        Node<T> curr = head;

        // Keep looping as long as we haven't fallen off the list
        while (curr != null)
        {
            // Check the current node's data
            if (curr.getData().equals(data))
            {
                return true;
            }
            // Move to the next node
            curr = curr.getNext();
        }

        // If we finished the loop, we never found it
        return false;
    }


    // ----------------------------------------------------------
    /**
     * empties the list
     */
    public void clear()
    {
        head = null;
        size = 0;
    }

}

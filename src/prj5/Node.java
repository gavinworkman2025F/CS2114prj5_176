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
 * Contains the required methods for a node to be used in a singly linked list
 * 
 * @param <T>
 *            the type of node
 * @author gjwor
 * @version Nov 18, 2025
 */
public class Node<T>
{
    private T data;
    private Node<T> next;

    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     */
    public Node()
    {
        data = null;
        next = null;
    }


    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * 
     * @param d
     *            the data in the node
     * @param n
     *            the next node reference in the list
     */
    public Node(T d, Node<T> n)
    {
        data = d;
        next = n;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the next node in the list
     * 
     * @return the next node in the list
     */
    public Node<T> getNext()
    {
        return next;
    }


    // ----------------------------------------------------------
    /**
     * Sets the next variable of a node
     * 
     * @param n
     *            the new next node
     */
    public void setNext(Node<T> n)
    {
        next = n;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the data in a node
     * 
     * @return the data variable in the node
     */
    public T getData()
    {
        return data;
    }


    // ----------------------------------------------------------
    /**
     * Sets the data variable of a node
     * 
     * @param d
     *            the new data for the node
     */
    public void setData(T d)
    {
        data = d;
    }

}

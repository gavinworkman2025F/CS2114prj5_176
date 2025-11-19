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

    public SinglyLinkedList()
    {
        head = null;
        size = 0;
    }


    public int size()
    {
        return size;
    }


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


    public Node<T> getHead()
    {
        return head;
    }


    public boolean isEmpty()
    {
        return size == 0;
    }


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


    public void clear()
    {
        head = null;
        size = 0;
    }

}

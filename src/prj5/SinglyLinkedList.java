package prj5;

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

        if (head == null)
        {
            Node<T> node = new Node<T>(data, null);
            head = node;
            size++;
        }
        else
        {
            Node<T> curr = head;

            for (int i = 0; i < index; i++) // iterate through list to get to
                                            // index
            {
                curr = curr.getNext();
            }

            Node<T> node = new Node<T>(data, curr.getNext());
            size++;
        }
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
        if (head.getData().equals(data))
        {
            head = head.getNext();
            return true;
        }

        Node<T> curr = head;

        while (!curr.getNext().getData().equals(data))
        {
            curr = curr.getNext();
        }

        curr.setNext(curr.getNext().getNext());
        return true;
    }


    public boolean contains(T data)
    {
        if (isEmpty() || data == null)
        {
            return false;
        }

        if (head.getData().equals(data))
        {
            return true;
        }

        Node<T> curr = head;

        while (!curr.getNext().getData().equals(data))
        {
            curr = curr.getNext();
        }

        if (curr.getNext() == null) // we got to end of list w/o finding data
        {
            return false;
        }

        return true; // we aren't at the end of the list, we found the data

    }


    public void clear()
    {
        head = null;
        size = 0;
    }

}

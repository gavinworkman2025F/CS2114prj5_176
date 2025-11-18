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
    
    public T getHead() {
        return head.getData();
    }

}

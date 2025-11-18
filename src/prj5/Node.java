package prj5;
public class Node<T>
{
    private T data;
    private Node<T> next;
    
    public Node()
    {
        data = null;
        next = null;
    }
    
    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> n) {
        next = n;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T d) {
        data = d;
    }

}

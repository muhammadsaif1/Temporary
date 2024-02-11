package Day06;

interface list {
    public int size();
    public void insert(Object data);
    public Object remove(Object data);
}

public class LinkedList {
    public static class Node{
        Object data;
        Node next;
        Node(Object data){
            this.data=data;
        }
    }
   private Node head;

    public int size(){
        Node temp = head;
        int size=0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void insert(Object data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void remove(Object data){
        if (head== null){
            throw new IllegalStateException("List is empty");
        }
        if (head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && current.data != data){
            prev = current;
            current = current.next;
        }
        if (current == null){
            return;
        }
        prev.next=current.next;
    }

    public boolean search(Object data){
        Node temp = head;
        while (temp != null){
            if (temp.data==data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}

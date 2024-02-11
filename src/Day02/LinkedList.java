package Day02;

import Day03.LinkedStack;

import java.util.Arrays;

public class LinkedList {
    public static class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
        }
    }

    private Node head;

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size(){
        int size = 0;
        Node temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public boolean isEmpty(){
        Node temp =head;
        return temp==null;
    }

    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node p = head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = newNode;
    }

    public  void remove(String data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        prev.next = current.next;
    }

    public boolean search(String target){
        Node temp = head;
        if (temp == null){
            return false;
        }
        while (temp != null){
            if (temp.data == target){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node merge(LinkedList l1, LinkedList l2) {
        Node mergedHead;

        if (l1.head == null) {
            mergedHead = l2.head;
        } else if (l2.head == null) {
            mergedHead = l1.head;
        } else {
            Node p = l1.head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = l2.head;
            mergedHead = l1.head;
        }
        return mergedHead;
    }


    public String toString(){

        StringBuffer b1 = new StringBuffer();
        Node p=head;
        while (p != null) {
            b1.append(p.data+", ");
            p=p.next;
        }
        return new String(b1);
    }

    public String sum(){
        Node temp = head;
        StringBuffer sum = new StringBuffer();
        while (temp != null){
            sum.append(temp.data+" ");
            temp=temp.next;
        }
        return new String(sum);
    }


    public String[] mergeToArray(LinkedList l1, LinkedList l2) {
        int totalSize = l1.size() + l2.size();
        String[] mergedArray = new String[totalSize];

        Node current = l1.head;
        int index = 0;

        while (current != null) {
            mergedArray[index++] = current.data;
            current = current.next;
        }

        current = l2.head;

        while (current != null) {
            mergedArray[index++] = current.data;
            current = current.next;
        }

        return mergedArray;
    }

//    public Node subList(Node head, int start, int end) {
//        Node mynewlist = null;
//        int si = 0;
//        Node p = head;
//
//        while (si < start && p.next != null) {
//            p = p.next;
//            si++;
//        }
//
//        while (si <= end && p != null) {
//            mynewlist = insert(p.data);
//            p = p.next;
//            si++;
//        }
//        return mynewlist;
//    }


    public void printReverse() {
        printReverse(head);
        System.out.println();
    }
    private void printReverse(Node node) {
        if (node == null) {
            return;
        }
        printReverse(node.next);
        System.out.print(node.data + " ");
    }





    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList fruits = new LinkedList();
        System.out.println(ll.isEmpty());
        ll.insert("saif");
        ll.insert("Baby");
        System.out.println(ll.sum());
        System.out.println(ll.isEmpty());
        ll.display();
        System.out.println(ll.size());
        ll.remove("saif");
        ll.display();
        System.out.println(ll.search("Baby"));

        fruits.insert("apple");
        fruits.insert("Strawberry");
        fruits.insert("Banana");
        System.out.println(Arrays.toString(ll.mergeToArray(ll,fruits)));
//        System.out.println(ll.mergeToArray(ll,fruits));
        String[] arr = ll.mergeToArray(ll,fruits);
        for (int i =0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println(ll);
        System.out.println("Sum is: "+fruits.sum());

        Node mergedHead = ll.merge(ll,fruits);
        LinkedList mergedList = new LinkedList();
        mergedList.head = mergedHead;
        mergedList.display();


    }

}

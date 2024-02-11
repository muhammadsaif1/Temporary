package Day03;

public class LinkedStack {

   public static class Node{
        Object data;
        Node next;
        Node(Object data,Node next){
        this.data=data;
        this.next=next;}
    }

    private Node top;
    private int size;
    public void push(Object data){
        top = new Node(data,top);
        ++size;
    }

    public int size(){return size;}

    public boolean isEmpty(){
        return size()==0;
    }

    public Object peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public Object pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        Object val = top.data;
        top = top.next;
        --size;
        return val;
    }

    public boolean containsFiveElements(){
        return size()==5;
    }

    public void removeFromBottom(){
        if (top == null){
            throw new IllegalStateException("stack is Empty");
        }
        if (top.next==null){
            top = null;
        }
        Node temp = top;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next=null;
        --size;
    }

    public boolean lastElementsEqual(LinkedStack stack1, LinkedStack stack2) {
        if (stack1.isEmpty() || stack2.isEmpty()) {
            return false;  // One or both of the stacks are empty
        }

        Node p = stack1.top;
        Node q = stack2.top;

        while (p.next != null) {
            p = p.next;
        }

        while (q.next != null) {
            q = q.next;
        }

        return p.data.equals(q.data);
    }

    public Object secondLast(){
        if (top == null){
            throw new IllegalStateException("Stack is Empty");
        }
        Node temp =top;
        while (temp.next.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean search(Object data){
        if (top == null){
            throw new IllegalStateException("Stack is empty");

        }
        Node temp = top;
        while (temp != null){
            if (temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display(){
        Node temp = top;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    // This method is correct just commented it because of unreachable statment this code can be written in exams

//    public static LinkedStack toLinkedStack(LinkedList l2){
//        LinkedStack stack = new LinkedStack();
//        for (Object item: l2){
//            stack.push(item);
//        }
//        return stack;
//    }

    public  LinkedStack merge(LinkedStack list1, LinkedStack list2, LinkedStack list3) {
        Node mergedHead = null;

        // Merging list1
        if (!list1.isEmpty()) {
            Node temp = list1.top;
            while (temp != null) {
                mergedHead = new Node(temp.data, mergedHead);
                temp = temp.next;
            }
        }

        // Merging list2
        if (!list2.isEmpty()) {
            Node temp = list2.top;
            while (temp != null) {
                mergedHead = new Node(temp.data, mergedHead);
                temp = temp.next;
            }
        }

        // Merging list3
        if (!list3.isEmpty()) {
            Node temp = list3.top;
            while (temp != null) {
                mergedHead = new Node(temp.data, mergedHead);
                temp = temp.next;
            }
        }

        // Create a new LinkedStack with the merged head
        LinkedStack mergedStack = new LinkedStack();
        mergedStack.top = mergedHead;

        return mergedStack;
    }


//    public ArrayStack toArrayStack(LinkedStack obj){
//        ArrayStack arr = new ArrayStack(obj.size());
//        Node temp = obj.top;
//        while (temp != null){
//            arr.push(temp.data);
//            temp = temp.next;
//        }
//        ArrayStack a1 = new ArrayStack(obj.size());
//        for (int i = arr.size()-1;i>=0;i--){
//            a1.push(arr.data[i]);
//        }
//        return a1;
//    }

    public void printReverse() {
        printReverse(top);
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
//        LinkedStack candy = new LinkedStack();
//
//        LinkedStack candy2 = new LinkedStack();
//        System.out.println(candy.isEmpty());
//        candy.push("a");
//        candy.push("l");
////        System.out.println(candy.isEmpty());
////        System.out.println(candy.size());
////        System.out.println(candy.containsFiveElements());
//        candy2.push("a");
//        candy2.push("m");
//        candy2.push("s");
//        candy2.push("md");
//        System.out.println(candy.lastElementsEqual(candy2,candy));
//        candy.display();
//        System.out.println(candy2.secondLast());

        LinkedStack firstSem = new LinkedStack();
        firstSem.push("PF");
        LinkedStack secondSem = new LinkedStack();
        secondSem.push("OOP");
        LinkedStack thirdSem = new LinkedStack();
        thirdSem.push("DSA");
LinkedStack mergedStack = firstSem.merge(firstSem,secondSem,thirdSem);
        mergedStack.display();
        System.out.println(mergedStack.peek());
//        System.out.println(mergedStack.peek());

    }

}

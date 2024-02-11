package Day06;

public class LinkedStack<T> {

    public static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top;
    private int size;

    public void push(T data) {
        top = new Node<>(data, top);
        ++size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T val = top.data;
        top = top.next;
        --size;
        return val;
    }

    public boolean containsFiveElements() {
        return size() == 5;
    }

    public void removeFromBottom() {
        if (top == null) {
            throw new IllegalStateException("stack is Empty");
        }
        if (top.next == null) {
            top = null;
        }
        Node<T> temp = top;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        --size;
    }

    public boolean lastElementsEqual(LinkedStack<T> stack1, LinkedStack<T> stack2) {
        if (stack1.isEmpty() || stack2.isEmpty()) {
            return false;  // One or both of the stacks are empty
        }

        Node<T> p = stack1.top;
        Node<T> q = stack2.top;

        while (p.next != null) {
            p = p.next;
        }

        while (q.next != null) {
            q = q.next;
        }

        return p.data.equals(q.data);
    }

    public T secondLast() {
        if (top == null) {
            throw new IllegalStateException("Stack is Empty");
        }
        Node<T> temp = top;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean search(T data) {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        Node<T> temp = top;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void display() {
        Node<T> temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public LinkedStack<T> merge(LinkedStack<T> list1, LinkedStack<T> list2, LinkedStack<T> list3) {
        Node<T> mergedHead = null;

        // Merging list1
        if (!list1.isEmpty()) {
            Node<T> temp = list1.top;
            while (temp != null) {
                mergedHead = new Node<>(temp.data, mergedHead);
                temp = temp.next;
            }
        }

        // Merging list2
        if (!list2.isEmpty()) {
            Node<T> temp = list2.top;
            while (temp != null) {
                mergedHead = new Node<>(temp.data, mergedHead);
                temp = temp.next;
            }
        }

        // Merging list3
        if (!list3.isEmpty()) {
            Node<T> temp = list3.top;
            while (temp != null) {
                mergedHead = new Node<>(temp.data, mergedHead);
                temp = temp.next;
            }
        }

        // Create a new LinkedStack with the merged head
        LinkedStack<T> mergedStack = new LinkedStack<>();
        mergedStack.top = mergedHead;

        return mergedStack;
    }

    public static void main(String[] args) {
        // Example usage with String
        LinkedStack<String> stringStack = new LinkedStack<>();
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");

        System.out.println("Peek: " + stringStack.peek());
        System.out.println("Size: " + stringStack.size());

        // Example usage with Integer
        LinkedStack<Integer> intStack = new LinkedStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("Peek: " + intStack.peek());
        System.out.println("Size: " + intStack.size());

        // Example usage with your merging method
        LinkedStack<String> firstSem = new LinkedStack<>();
        firstSem.push("PF");
        LinkedStack<String> secondSem = new LinkedStack<>();
        secondSem.push("OOP");
        LinkedStack<String> thirdSem = new LinkedStack<>();
        thirdSem.push("DSA");

        LinkedStack<String> mergedStack = firstSem.merge(firstSem, secondSem, thirdSem);
        mergedStack.display();
        System.out.println("Peek: " + mergedStack.peek());

        LinkedStack<Character> ch = new LinkedStack<>();
    }
}


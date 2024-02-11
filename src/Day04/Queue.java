//package Day04;
//
//public class Queue {
//    Object[] a;
//    Object[] b;
//    int size;
//
//
//    Queue(int size) {
//        a = new Object[size];
//        b = new Object[size];
//    }
//
//    public void add(Object obj1, Object obj2) {
//        a[size++] = obj1;
//        b[size] = obj2;
//    }
//
//
//    public void print() {
//        for (int i = 0; i < size; i++) {
//            System.out.println(a[i] + " " + b[i]);
//        }
//    }
//
//    public void remove() {
//        for (int i = 0; i < size-1; i++) {
//            a[i] = a[i+1];
//            b[i] = b[i+1];
//        }
//        size--;
//    }
//
//
//
//    public static void main(String[] args) {
//        Queue queue = new Queue(10);
//        queue.add(1, "AISHA MEMON");
//        queue.add(2, "MUHAMMAD SAIF");
//        queue.add(3, "BABY");
////        queue.remove();
//        queue.print();
// }
//}
//
//

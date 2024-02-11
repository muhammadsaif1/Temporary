package Day04;

public class QueueMultiple implements queue {
    Products[] products;
    int size;

    QueueMultiple(int size) {
        products = new Products[size];
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i+1 + ":");
            products[i].displayItems();
        }
    }

    public void enqueue(Products products) {
        if (isFull()) {
            resize();
        }
        this.products[size++] = products;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("The queue is already empty");
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            this.products[i] = this.products[i + 1];
        }
        size--;
    }

    public Products peek() {
        return products[0];
    }

    public boolean isFull() {
        return size == this.products.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newSize = this.products.length * 2;
        Products[] newArray = new Products[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = this.products[i];
        }
        this.products = newArray;
    }


    public static void main(String[] args) {
        QueueMultiple queue = new QueueMultiple(10);
        queue.enqueue(new Products("product1_1", "product2_1", "product3_1", "product4_1", "product5_1"));
        queue.enqueue(new Products("product1_2", "product2_2", "product3_2", "product4_2", "product5_2"));
        queue.enqueue(new Products("product1_3", "product2_3", "product3_3", "product4_3", "product5_3"));
        queue.enqueue(new Products("product1_4", "product2_4", "product3_4", "product4_4", "product5_4"));
        queue.peek().displayItems();
        queue.display();
    }
}

interface queue {
    public void enqueue(Products products);
    public void dequeue();
    public Object peek();
    public boolean isFull();
    public boolean isEmpty();
}
class Products {
    Object product1;
    Object product2;
    Object product3;
    Object product4;
    Object product5;

    public Products(Object product1, Object product2, Object product3, Object product4, Object product5) {
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
        this.product4 = product4;
        this.product5 = product5;
    }

    public void displayItems() {
        System.out.println(product1 + " " + product2 + " " + product3 + " " + product4 + " " + product5);
    }
}
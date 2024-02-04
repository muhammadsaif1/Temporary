package Day03;

public class ArrayStack {
    Object[] data;
    int size;
    ArrayStack(int capacity){
        data  = new Object[capacity];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Object peek(){
        if (size ==0){
            throw new IllegalStateException("Stack is empty");
        }
        return data[size-1];
    }

    public Object pop(Object value){
        if (size==0){
            throw new IllegalStateException("Stack is Empty");
        }
        Object val = data[--size];
        data[size] =null;
        return val;
    }
    public int size(){
        return size;
    }

    public void resize(){
        size = size*2;
    }

    public void push(Object val){
        if (size == data.length){
            resize();
        }
        data[size++] = val;
    }
}

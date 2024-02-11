package Day05;

class person{
    private String name;
    private String property;
    public void setData(String name,String property){
        this.name=name;
        this.property=property;
    }
    public String getData(){
        return "Name : "+name+"\n"+"Property : "+property;
    }
}
public class ArrayQueue2{
    person[] personQueue;
    int length=0;
    int capacity=0;
    ArrayQueue2(int capacity){
        this.capacity=capacity;
        personQueue = new person[capacity];
    }
    public void enQueue(String name , String property){
        if(isFull()){
            resize();
        }
            personQueue[length] = new person();
            personQueue[length++].setData(name, property);
    }

    public void addFirst(String name, String property) {
        if (isFull()) {
            resize();
        }
        for (int i = length; i > 0; i--) {
            personQueue[i] = personQueue[i - 1];
        }
        personQueue[0] = new person();
        personQueue[0].setData(name, property);
        length++;
    }
    public void display(){
        for(int i=0;i<length;i++){
            System.out.println(personQueue[i].getData());
            System.out.println("_");
        }
    }

    public void reverse(){
        for(int i = length-1; i>=0; i--){
            System.out.println(personQueue[i].getData());
        }
    }
    public person deQueue(){
        if(isEmpty()){
            System.out.println("No data");
            return null;
        }
        else{
            person temp =personQueue[0];
            length--;
            for(int i=0;i<length;i++){
                personQueue[i]=personQueue[i+1];
            }
            return temp;
        }
    }

    public person deleteLast() {
        if (isEmpty()) {
            System.out.println("No data");
            return null;
        } else {
            person temp = personQueue[length - 1];
            length--;
            return temp;
        }
    }




    public boolean isFull(){
        return length==capacity;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public int getSize(){
        return length;
    }
    public void resize(){
        person[] temp=personQueue;
        personQueue = new person[personQueue.length*2];
        for(int i=0;i<temp.length;i++){
            personQueue[i]=temp[i];
        }
    }

    public boolean search(String nameToSearch, String propertyToSearch) {
        for (int i = 0; i < length; i++) {
            person currentPerson = personQueue[i];
            if (currentPerson.getData().contains(nameToSearch) && currentPerson.getData().contains(propertyToSearch)) {
                System.out.println("Found at index: " + i);
                return true;
            }
        }
        System.out.println("Not found");
        return false;
    }

    public person peek(){
        return personQueue[0];
    }

    public person last(){
        return personQueue[length];
    }

    public static void main(String[] args) {
        ArrayQueue2 arr = new ArrayQueue2(10);
        arr.enQueue("Saif", "House");
        arr.enQueue("Saqib", "RR");
        arr.enQueue("Musaib", "Jet");
        System.out.println(arr.deleteLast().getData());
        arr.deQueue();
        System.out.println(arr.peek().getData());
        System.out.println(arr.last().getData());
//
//        System.out.println(arr.deQueue().getData());
//        System.out.println(arr.getSize());
//        System.out.println(arr.search("Saif","House"));
        arr.reverse();
}
}


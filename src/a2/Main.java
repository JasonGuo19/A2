package a2;


public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1);

        list.multiply(4);
        System.out.println(list.toString());
    }
}

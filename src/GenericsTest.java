import java.util.LinkedList;

public class GenericsTest {
    public class Node<E> {
        E item;
        Node next;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
    }

}

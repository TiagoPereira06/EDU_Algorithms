package series.serie2.parte2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    protected Node<T> getFirst() {
        return head;
    }

    public Node<T> addFirst(T e) {
        Node<T> n = new Node<>(e);
        n.link = head;
        head = n;
        ++size;
        return n;
    }

    protected Node<T> removeFirst() {
        Node<T> n = head;
        head = n.link;
        --size;
        return n;
    }

    public Node<T> addLast(Node<T> last, T e) {
        Node<T> n = new Node<>(e);
        if (last == null)
            head = n;
        else
            last.link = n;
        ++size;
        return n;
    }

    public int contains(T value) {
        Iterator<T> iterator = iterator();
        T curr;
        int index = -1;
        while (iterator.hasNext()) {
            curr = iterator.next();
            ++index;
            if (curr.equals(value))
                return index;
        }

        return -1;
    }

    public void sort(Comparator<T> cmp) {
        Node first = this.head;
        Node last = this.head;
        while (last.link != null) {
            last = last.link;
        }
    }

    public void deleteNode(int position) {
        if (head == null)
            return;
        Node temp = head;
        if (position == 0) {
            head = temp.link;
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.link;

        if (temp == null || temp.link == null)
            return;
        Node next = temp.link.link;

        temp.link = next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException("linked list no more elements");
                T value = curr.value;
                curr = curr.link;
                return value;
            }
        };
    }

    static class Node<T> {

        public T value;
        Node<T> link;

        Node(T k) {
            value = k;
        }
    }
}

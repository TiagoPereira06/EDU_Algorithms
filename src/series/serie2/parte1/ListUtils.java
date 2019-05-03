package series.serie2.parte1;
import java.util.Comparator;

public class ListUtils {

    public static <E> Node<E> getMiddle(Node<E> list){
        Node<E> fastJumper=list,slowJumper=list;

        while(fastJumper!=null && fastJumper.next!=null){
            fastJumper=fastJumper.next.next;
            slowJumper=slowJumper.next;
        }

        return slowJumper;
    }

    public static <E>void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp) {
        if (last != null && first != last && first != last.next) {
            Node temp = partition(first, last, cmp);
            if (first != temp) quicksort(first, temp.previous, cmp);

            if (temp != last) quicksort(temp.next, last, cmp);
        }
    }

    public static <E> Node<E> partition(Node<E> first, Node<E>  last, Comparator<E> cmp) {
        E x =  last.value;
        Node<E> i = first.previous;
        for (Node<E> j = first; j != last; j = j.next) {
            if (cmp.compare( j.value, x) <= 0) { //CMP

                if (i == null) i = first;
                else i = i.next;

                E temp =  i.value;
                i.value =  j.value;
                j.value = temp;
            }
        }
        i = (i == null) ? first : i.next;
        E temp =  i.value;
        i.value = last.value;
        last.value = temp;
        return i;
    }

    public static <E> Node<E> merge(Node<E>[] lists, Comparator<E> cmp){
        Comparator<Node> nodeComparator= (Node o1, Node o2) -> {
            Comparator comparator = Comparator.reverseOrder();
            return comparator.compare(o1.value,o2.value);
        };
        Node<E> tail = new Node<>();
        tail.previous= tail;
        tail.next=tail;
        if(lists[0]==null)return tail;
        Node<E>sentinel = tail;
        ListUtilsHeap heap = new ListUtilsHeap(lists.length);

        for (int i = 0; i <lists.length ; i++) {
            heap.insertAndRebuildHeap(i, lists[i],nodeComparator);
        }
        while(heap.getSize()!=0) {
            Node currMin = heap.extractMin(nodeComparator);
            tail.next = currMin;
            tail.next.previous = tail;
            tail = tail.next;
        }
        tail.next=sentinel;
        sentinel.previous=tail;

        return sentinel;
    }
}

package series.serie2.parte1;

import java.util.Comparator;

public class ListUtils {

    private static class Node<E> {
        public Node<E> prev, next;
        public E value;

        public Node() {
            next = prev = this;
        }
        public Node(E k) {
            value = k;
        }
    }

    public static <E>Node<E>getMiddle(Node<E> list){

        Node<E> fastJumper=list,slowJumper=list;

        while(fastJumper!=null && fastJumper.next!=null){
            fastJumper=fastJumper.next.next;
            slowJumper=slowJumper.next;
        }

        return slowJumper;
    }
        /*Pior - O(n^2)
        Médio - O(nlogn)
        Melhor - O(nlogn)*/

    <E> void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp){

      while (cmp.compare(first.value,last.value)<0){
          //Node<E> q = partition()

      }




    }
}

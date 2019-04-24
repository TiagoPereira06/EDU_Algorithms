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

    public static <E>void quicksort(Node<E> first, Node<E> last, Comparator<E> cmp){
        throw new UnsupportedOperationException();
    }



    public static <E> Node<E> merge(Node<E>[] lists, Comparator<E> cmp){
        throw new UnsupportedOperationException();
    }


}

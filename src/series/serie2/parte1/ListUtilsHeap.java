package series.serie2.parte1;
import java.util.Comparator;

public class ListUtilsHeap {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size;
    private Node[] minHeap;

    public ListUtilsHeap(int size){
        this.size=size;
        minHeap=new Node[size];
    }

    public static int parentIndex(int i) {
        return (i - 1) >> 1;
    }

    public static int leftIndex(int i) {
        return (i << 1) + 1;
    }

    public static int rightIndex(int i) {
        return (i << 1) + 2;
    }

    public void heapify(Node[] heap, int heapSize, int i, Comparator<Node> cmp ) {
        int il = leftIndex( i);
        int ir = rightIndex( i );
        int im = i;
        if ( il < heapSize && cmp.compare(heap[il],heap[im]) > 0 )
            im = il;
        if ( ir < heapSize && cmp.compare(heap[ir], heap[im]) > 0 )
            im = ir;
        if ( im != i ) {
            swap(heap, i, im );
            heapify( heap, heapSize, im, cmp);
        }
    }
    public void insertAndRebuildHeap(int indexWhereToAdd, Node valueToAdd, Comparator<Node> cmp ) {
        int p;
        while ( indexWhereToAdd > 0 && cmp.compare(minHeap[p = parentIndex( indexWhereToAdd )], valueToAdd)  < 0 ) {
            minHeap[indexWhereToAdd] = minHeap[p];
            indexWhereToAdd = p;
        }
        minHeap[indexWhereToAdd] = valueToAdd;
    }

    public void swap(Node[] array, int i1, int i2) {
        Node aux = array[i1];
        array[i1] = array[i2];
        array[i2] =aux;
    }

    public Node extractMin(Comparator<Node> cmp) {
        Node min = minHeap[0];
        minHeap[0]=minHeap[0].next==null ? minHeap[--size] : minHeap[0].next;
        heapify( minHeap, size, 0, cmp);
        return min;
    }

}

package series.serie1.parte2.ex2;


import java.util.Comparator;

public class Heap {
    private int size,minHeapSize,maxHeapSize;
    double median;
    private int[] minHeap,maxHeap;



    public Heap(int size){
        this.size=size;
        minHeap=new int[size/2];
        maxHeap=new int[size/2];


    }

    public static int parent(int i) {
        return (i - 1) >> 1;
    }

    public static int left(int i) {
        return (i << 1) + 1;
    }

    public static int right(int i) {
        return (i << 1) + 2;
    }

    public static void maxHeapify(int[] heap, int heapSize, int i,Comparator<Integer> cmp ) {
        int il = left( i);
        int ir = right( i );
        int im = i;
        if ( il < heapSize && cmp.compare(heap[il], heap[im]) > 0 )
            im = il;
        if ( ir < heapSize && cmp.compare(heap[ir], heap[im]) > 0 )
            im = ir;
        if ( im != i ) {
            swap(heap, i, im );
            maxHeapify( heap, heapSize, im, cmp);
        }
    }

    public static void minHeapify(int[] heap, int heapSize, int i) {
        maxHeapify(heap, heapSize, i, Comparator.reverseOrder());
    }

    private static void increase(int[] heap, int i, int v, Comparator<Integer> cmp ) {
        int p;
        while ( i > 0 && cmp.compare(heap[p = parent( i )], v)  < 0 ) {
            heap[i] = heap[p];
            i = p;
        }
        heap[i] = v;
    }



    public static void swap(int[] array, int i1, int i2) {
        int aux = array[i1];
        array[i1] = array[i2];
        array[i2] =aux;
    }

    public void updateSet(int[]a){

        for (int i = 0; i <a.length ; i++) {
            if(i==0&&median==0) median=a[i]+1;

            if(a[i]<median){
                maxHeap=checkSize(maxHeap,++maxHeapSize);
                increase(maxHeap,maxHeapSize-1,a[i],Comparator.naturalOrder());
            }
            else if (a[i]>median){
                minHeap=checkSize(minHeap,++minHeapSize);
                increase(minHeap,minHeapSize-1,a[i],Comparator.reverseOrder());
            }
            getMedian();
        }


    }

    void getMedian() {
        if(maxHeapSize==minHeapSize){
            median =(double)(maxHeap[0]+minHeap[0]) / 2;

        }else if(Math.abs(maxHeapSize-minHeapSize)!=1){
            if(maxHeapSize>minHeapSize){
                int max=extractMax(maxHeap,maxHeapSize--,Comparator.naturalOrder());
                increase(minHeap,minHeapSize++,max,Comparator.reverseOrder());

            }else{
                int max=extractMax(minHeap,minHeapSize--,Comparator.reverseOrder());
                increase(maxHeap,maxHeapSize++,max,Comparator.naturalOrder());

            }

        }else{
            if(maxHeapSize<minHeapSize)
                median=minHeap[0];
            else median=maxHeap[0];
        }
    }

    public static int extractMax(int[] heap, int heapSize, Comparator<Integer> cmp) {
        int max = heap[ 0 ];
        heap[ 0 ] = heap[heapSize-1];
        maxHeapify( heap, heapSize-1, 0, cmp);
        return max;
    }

    public int[] checkSize(int[]src,int size){
        int[] aux = new int[0];
        boolean bool=false;

        if(size==src.length){
            System.arraycopy(src,0,aux=new int[src.length*2],0,src.length);
            bool=true;
        }
        return (bool)? aux:src;
    }
}

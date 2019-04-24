package series.serie1.parte2.ex1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class utilsMedian {

    static Comparator<Integer> cmp = new IntegerComparator();
    private static PriorityQueue<Integer> maxHeapify = new PriorityQueue<>(cmp.reversed());
    private static PriorityQueue<Integer> minHeapify = new PriorityQueue<>(cmp.reversed());
    private static float median;

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println("Enter a valid command ");
        Scanner in = new Scanner(System.in);
        while(true) {
            String s= in.nextLine();
            if(s.equalsIgnoreCase("e")){
                runTime(time);
                System.exit(0);
            }

            else if(s.equalsIgnoreCase("getMedian")){
                 getMedian();
                 System.out.println("Mediana = " + median);
             }
        else{
                 String[] split= s.split(" ");
                 int param = Integer.parseInt(split[1]);
                 updateSet(param);
                 System.out.println(maxHeapify+"    "+minHeapify);
            }
        }
    }
    private static void updateSet(int a) {
        if(minHeapify.size()+maxHeapify.size()==0){
             minHeapify.add(a);
        }

        else if(a > getTopMinHeap()){
           maxHeapify.add(a);
        }
        else if(a < getTopMinHeap()) minHeapify.add(a);

        else if(getTopMaxHeap()< a){
            minHeapify.add(a);
        }
        else if (getTopMaxHeap()>a) maxHeapify.add(a);



        if((minHeapify.size()-maxHeapify.size()>Math.abs(1))){
            if(getMinHeapSize()>getMaxHeapSize()){
                maxHeapify.add(minHeapify.peek());
                minHeapify.remove();
            }
            else{
                minHeapify.add(maxHeapify.peek());
                maxHeapify.remove();
            }
        }


    }



    private static int getMinHeapSize() {
        return minHeapify.size();
    }
    private static int getMaxHeapSize() {
        return maxHeapify.size();
    }


    private static int getTopMinHeap() {
        if(minHeapify.size()<1)return 0;
        return minHeapify.peek();
    }

    private static int getTopMaxHeap() {
        if(maxHeapify.size()<1)return 0;
        return maxHeapify.peek();
    }


    public static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer l1, Integer l2) {
            return  l1.compareTo(l2);
        }
    }
    private static void runTime(long startTime){
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime + "ms");
    }
    private static void getMedian(){
        if(minHeapify.size()==maxHeapify.size()) median= (minHeapify.peek()+maxHeapify.peek())/2;
        else if(minHeapify.size()>maxHeapify.size()) {
            median = minHeapify.peek();
        }
        else median = maxHeapify.peek();

    }
}

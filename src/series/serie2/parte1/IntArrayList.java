package series.serie2.parte1;

public class IntArrayList {
    private int[] array;
    private int k,size,sum;

    public IntArrayList(int k){
        this.k=k;
        array=new int[k];
        size=0;
    }
    public boolean append(int x){
        if(size>=k) return false;
        array[size++] = x-sum;
        return true;
    }
    public int get(int i){
        if(i<k) return array[i]+sum;
        else throw new IndexOutOfBoundsException();
    }
    public void addToAll(int x){
        sum+=x;
    }
}

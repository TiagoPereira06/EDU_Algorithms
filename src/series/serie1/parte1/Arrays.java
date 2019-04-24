package series.serie1.parte1;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Arrays {

    public static int countEquals(int[] v1, int l1, int r1, int[] v2, int l2, int r2){
        int count=0;
        while(l1<=r1 && l2<=r2){
            if(v1[l1]>v2[l2]) l2++;
            else
            if(v1[l1]<v2[l2]) l1++;
            else { count++; l1++; l2++;}
        }
        return count;
    }


    public static int indexOfSmallest(int[]v, int l, int r){
        if(v.length==0) return -1;
        if (r==l) return l;
        if (r<l)  return 0;
        int middlePointer =((r-l)/2+l);
        if ((l<middlePointer) && (v[middlePointer-1]>v[middlePointer])) return middlePointer;
        if ((r>middlePointer) && (v[middlePointer]>v[middlePointer+1])) return middlePointer+1;
        if (v[middlePointer]<v[r])
            return indexOfSmallest(v, l, middlePointer-1);
        return indexOfSmallest(v, middlePointer+1, r);

    }

    public static int numberOfDistinct(int[]v1,int[]v2) {
        int i=0,j=0,n=0,lastI=-1;

        for(;i<v1.length&&j<v2.length;){

            if(lastI!=-1&&(v1[lastI]==v1[i])){
                lastI=i;
                ++i;
            }
            else if(v1[i]==v2[j]){
                    ++n;
                    ++j;
                    lastI=i;
                    ++i;
                }else if (v1[i]>v2[j]){
                    ++j;
                }else {
                lastI=i;
                ++i;
            }

            }
        return n;
    }
        public static int[] squaresSorted(int[]v){
        if(v.length==0) return null;
        int[]temp = new int[v.length];
        int i=0,j=v.length-1,k=temp.length-1;

        for(;k>=0;--k) {
            if ((v[i]* v[i]) < (v[j] * v[j])) {
                temp[k]=v[j]*=v[j];
                --j;
            }else{
                temp[k]=v[i]*v[i];
                ++i;
            }
        }

            return temp;
        }

        public static int countCommonPoints(Point []a, Point[]b) {
            if (a.length == 0 || b.length == 0) return 0;
            int n = 0;

            Comparator<Point> cmp = (p1, p2) -> {
                if (p1.x < p2.x) return -1;
                else if (p1.x == p2.x) {
                    if (p1.y < p2.y) return -1;
                    else if (p1.y == p2.y) return 0;
                    else return +1;
                } else return +1;
            };

            Point[] aux = new Point[a.length + b.length];
            System.arraycopy(a, 0, aux, 0, a.length);
            System.arraycopy(b, 0, aux, a.length, b.length);
            java.util.Arrays.sort(aux, cmp);

            for (int i = 0; i < aux.length - 1; i++) {
                if (cmp.compare(aux[i], aux[i + 1]) == 0) ++n;
            }
            return n;

        }


        public static int lessFrequent(int[]v){
            if(v.length==0)throw new NoSuchElementException();
            if(v.length==1)return v[0];
            int min=v[v.length-1],max=v[0],minIndex=0,tieMinValueIndex,j=0;
            int []freq = new int[max-min+1],tieFreq = new int[max-min+1];
            for (int i = 0; i <v.length ; i++) {
                if(v[i]>max)max=v[i];
                else if (v[i]<min) min=v[i];
            }
            java.util.Arrays.fill(tieFreq,-1);
            for (int i = 0; i <v.length ; i++) {
                freq[v[i]-min]++;
            }
            for (int i = 0; i < freq.length ; i++) {
                if(freq[i]!=0&&freq[i]<freq[minIndex])minIndex=i;
            }
            for (int i = 0; i < freq.length ; i++) {
                if(freq[i]==freq[minIndex]) {
                    tieFreq[j] = i;
                    ++j;
                }
            }
            if(j==1) return minIndex+min;//EXISTE APENAS UMA CELULA COM O VALOR MINIMO
            else{//EMPATE DETECTADO
                int []freqIndex = new int[max-min+1];
                java.util.Arrays.fill(freqIndex,-1);
                for (int i = 0; i <v.length ; i++) {
                    if(freqIndex[v[i]-min]==-1) freqIndex[v[i]-min]=i;
                }
                tieMinValueIndex=0;
                for (int i = 0; i <j;i++) {
                    if(freqIndex[tieFreq[tieMinValueIndex]]>freqIndex[tieFreq[i]]) {
                        tieMinValueIndex = i;
                    }
                }
                return tieFreq[tieMinValueIndex]+min;
            }
        }
}





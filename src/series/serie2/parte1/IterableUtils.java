package series.serie2.parte1;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiPredicate;

public class IterableUtils {


    public static <K,U> Iterable<K> filterBy(Iterable<K> src1, Iterable<U> src2, BiPredicate<K,U> predicate){

        return () -> new Iterator<K>() {
            Iterator<K> src1Iterator=src1.iterator();
            Iterator<U> src2Iterator=src2.iterator();
            K currK;
            boolean found=false;
            @Override
            public boolean hasNext() {
                if(found)return true;
                while (src1Iterator.hasNext()&&src2Iterator.hasNext()) {
                    currK=src1Iterator.next();
                    U currU=src2Iterator.next();
                    if (predicate.test(currK, currU)) {
                        found=true;
                        return true;
                    }
                }
                return false;
            }
            @Override
            public K next() {
                if (!hasNext()) throw new NoSuchElementException("");
                found=false;
                return currK;
            }
        };
    }

    public static <K,V> Iterable<V> filterByMap(Iterable<K> src, Map<K,V> map){
        return () -> new Iterator<V>() {
            Iterator<K> srcIterator = src.iterator();
            boolean found=false;
            K currK;
            @Override
            public boolean hasNext() {
                if(found)return true;
                while(srcIterator.hasNext()){
                    currK=srcIterator.next();
                    if(map.containsKey(currK)){
                        found=true;
                        return true;
                    }
                }
                return false;
            }
            @Override
            public V next() {
                if (!hasNext()) throw new NoSuchElementException("");
                found=false;
                return map.get(currK);
            }
        };
    }

}

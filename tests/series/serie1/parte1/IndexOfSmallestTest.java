package series.serie1.parte1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static series.serie1.parte1.Arrays.indexOfSmallest;


public class IndexOfSmallestTest {

    @Test
    public void test_indexOfSmallest_with_none() {
        int[] array = new int[]{ };
        assertEquals(-1,indexOfSmallest(array, 1, 0));}

    @Test
    public void test_indexOfSmallest_with_one() {
        int[] array = new int[]{ 55};
        assertEquals(0,indexOfSmallest(array, 0, 0));}

    @Test
    public void test_indexOfSmallest_with_two() {
        int[] array = new int[]{40, 55};
        assertEquals(0,indexOfSmallest(array, 0, 1));
        array = new int[]{60, 55};
        assertEquals(1,indexOfSmallest(array, 0, 1));
    }

    @Test
    public void test_indexOfSmallest_with_three(){
        int[] array = new int[]{57, 60, 55};
        assertEquals(2,indexOfSmallest(array, 0, 2));
        array = new int[]{60, 51, 54};
        assertEquals(1,indexOfSmallest(array, 0, 2));
        array = new int[]{60, 65, 70};
        assertEquals(0,indexOfSmallest(array, 0, 2));
    }

    @Test
    public void test_indexOfSmallest_without_shifted_positions() {
        int[] array = {7, 22, 35, 42, 47, 55};
        assertEquals(0, indexOfSmallest(array, 0, 5));
        array = new int[]{55, 0, 1, 2, 3, 7, 22, 35, 42, 47, 48, 60, 63};
        assertEquals(1, indexOfSmallest(array, 1, 10));
    }

    @Test
    public void test_indexOfSmallest_with_one_shifted_positions(){
        int[] array = { 55, 7, 22, 35, 42, 47 };
        assertEquals(1,indexOfSmallest(array, 0, 5));
        array = new int[]{ 55, 0, 1, 2, 3, 7, 22, 35, 42, 47, 48, 60, 63};
        assertEquals(1,indexOfSmallest(array, 0, 10));
    }

    @Test
    public void test_indexOfSmallest_with_two_shifted_positions(){
        int[] array = { 60, 35, 42, 5, 15, 27, 29 };
        assertEquals(3,indexOfSmallest(array, 1, 6));
    }

    @Test
    public void test_indexOfSmallest_with_four_shifted_positions(){
        int[] array = { 27, 29, 35, 42, 5, 15, 18 };
        assertEquals(4,indexOfSmallest(array, 0, 6));
    }

    @Test
    public void test_indexOfSmallest_with_also_four_shifted_positions(){
        int[] array = { 55, 57, 59, 60, 1, 7, 22, 35, 42, 47, 48, 50,53};
        assertEquals(4,indexOfSmallest(array, 0, 12));

    }

}

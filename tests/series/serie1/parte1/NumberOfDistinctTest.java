package series.serie1.parte1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static series.serie1.parte1.Arrays.numberOfDistinct;

public class NumberOfDistinctTest {

    @Test
    public void numberOfDistinct_onArraysWithNoElements(){
        int[] v1={},v2={};
        assertEquals(0,numberOfDistinct(v1,v2));
        assertEquals(0,numberOfDistinct(v2,v1));
        assertEquals(0,numberOfDistinct(v2,v2));
    }

    @Test
    public void numberOfDistinct_onSingletonArraysWithDistinctElements(){
        int[] v1={1},v2={3};
        assertEquals(0,numberOfDistinct(v1,v2));
        assertEquals(0,numberOfDistinct(v2,v1));
    }

    @Test
    public void numberOfDistinct_onSingletonArraysWithEqualElements(){
        int[] v1={1},v2={1};
        assertEquals(1,numberOfDistinct(v1,v2));
        assertEquals(1,numberOfDistinct(v2,v1));
    }

    @Test
    public void numberOfDistinct_onArraysWithDistinctElements(){
        int[] v1={1,2,3,7,8},v2={4,6,9};
        assertEquals(0,numberOfDistinct(v1,v2));
        assertEquals(0,numberOfDistinct(v2,v1));
    }

    @Test
    public void numberOfDistinct_onSampleArrays() {
        int[] v1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] v2 = {2, 2, 2, 5, 5};
        assertEquals(2, numberOfDistinct(v1, v2));
        assertEquals(2, numberOfDistinct(v2, v1));
    }

    @Test
    public void numberOfDistinct_onDisjointArrays() {
        int[] v1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int[] v2 = {7, 7, 8, 8, 9};
        assertEquals(0, numberOfDistinct(v1, v2));
        assertEquals(0, numberOfDistinct(v2, v1));
    }

    @Test
    public void numberOfDistinct_onSameArray() {
        int[] v1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        assertEquals(5, numberOfDistinct(v1, v1));
    }
}

package series.serie1.parte1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static series.serie1.parte1.Arrays.countCommonPoints;

public class CountCommonPointsTest {
    @Test
    public void countCommonPoint_onBothArrayWithNoElements() {
        assertEquals(0, countCommonPoints(new Point[0], new Point[0]));
    }

    @Test
    public void countCommonPoint_onOneArrayWithNoElements() {
        Point[] v = {new Point(2, 3), new Point(4, 5)};
        assertEquals(0, countCommonPoints(new Point[0], v));
        assertEquals(0, countCommonPoints(v, new Point[0]));
    }

    @Test
    public void countCommonPoint_onArraysWithDistinctElements() {
        Point[] v1 = {new Point(2, 3), new Point(4, 5)};
        Point[] v2 = {new Point(6, 3), new Point(4, 6)};
        assertEquals(0, countCommonPoints(v1, v2));
        assertEquals(0, countCommonPoints(v2, v1));
    }


    @Test
    public void countCommonPoint_onArraysWithEqualElements() {
        Point[] v1 = {new Point(4, 6),new Point(2, 3), new Point(4, 5),new Point(6, 3)};
        Point[] v2 = {new Point(6, 3), new Point(4, 6),new Point(2, 3),new Point(4, 5)};
        assertEquals(4, countCommonPoints(v1, v2));
        assertEquals(4, countCommonPoints(v2, v1));
        assertEquals(4, countCommonPoints(v1, v1));
    }




    @Test
    public void countCommonPoint_onArraysWithDisjointIntervalElements() {
        Point[] v1 = {new Point(4, 6),new Point(2, 3), new Point(4, 5),new Point(6, 3)};
        Point[] v2 = {new Point(10, 3), new Point(9, 6),new Point(15, 3),new Point(14, 5)};
        assertEquals(0, countCommonPoints(v1, v2));
        assertEquals(0, countCommonPoints(v2, v1));
    }


    @Test
    public void countCommonPoint_onArraysWithSomeEqualElements() {
        Point[] v1 = {new Point(2, 3),new Point(5, 5),new Point(4, 5),new Point(6, 3)};
        Point[] v2 = {new Point(6, 3), new Point(4, 6),new Point(2, 3),new Point(6, 6)};
        assertEquals(2, countCommonPoints(v1, v2));
        assertEquals(2, countCommonPoints(v2, v1));
    }



}

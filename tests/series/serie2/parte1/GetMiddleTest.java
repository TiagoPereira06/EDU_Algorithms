package series.serie2.parte1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static series.serie2.parte1.ListUtilTest.getRandomList;
import static series.serie2.parte1.ListUtils.getMiddle;

public class GetMiddleTest {

    @Test
    public void getMiddle_empty_list() {
        Node<Integer> list = ListUtilTest.emptyListWithoutSentinel();
        assertEquals(null,getMiddle(list));
    }

    @Test
    public void getMiddle_singleton_list() {
        Node<Integer> list = getRandomList(1);
        assertEquals(list,getMiddle(list));
    }

    @Test
    public void getMiddle_list_with_odd_dimension() {
        Node<Integer> list = ListUtilTest.getListWithoutSentinel(1, 20, 1);
        assertEquals(10,getMiddle(list).value);
    }

    @Test
    public void getMiddle_list_with_even_dimension() {
        Node<Integer> list = ListUtilTest.getListWithoutSentinel(0, 20, 1);
        assertEquals(10,getMiddle(list).value);
    }

}

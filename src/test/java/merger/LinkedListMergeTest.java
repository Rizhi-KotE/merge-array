package merger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class LinkedListMergeTest {

    private final LinkedList<Integer> a;
    private final LinkedList<Integer> expected;
    private final LinkedList<Integer> b;

    public LinkedListMergeTest(Integer[] a, Integer[] b, Integer[] expected) {
        this.a = new LinkedList<>(Arrays.asList(a));
        this.b = new LinkedList<>(Arrays.asList(b));
        this.expected = new LinkedList<>(Arrays.asList(expected));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Integer[][][] objects = {
                {
                        {}, {1}, {1}
                },
                {
                        {1}, {}, {1}
                },
                {
                        {1}, {1}, {1, 1}
                },
                {
                        {4}, {1, 2}, {1, 2, 4}
                },
                {
                        {4}, {5, 6}, {4, 5, 6}
                },
                {
                        {4}, {1, 2, 5, 6}, {1, 2, 4, 5, 6}
                },
                {
                        {4}, {1, 2, 2, 5, 5, 6}, {1, 2, 2, 4, 5, 5, 6}
                },
                {
                        {4, 6}, {1, 2, 4, 4, 5, 7, 8}, {1, 2, 4, 4, 4, 5, 6, 7, 8}
                },
                {
                        {4, 6, 6}, {1, 2, 3, 5, 5}, {1, 2, 3, 4, 5, 5, 6, 6}
                }
        };
        return Arrays.asList(objects);
    }

    @Test
    public void linkedListMerge() throws Exception {
        Main.merge(a, b);
        assertEquals(expected, a);
    }
}

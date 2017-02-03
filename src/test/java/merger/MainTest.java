package merger;

import merger.Main;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MainTest {

    @Test
    public void name() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList b = new ArrayList(Arrays.asList(2, 4, 5));
        Main.merge(a, b);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5}, a.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void name1() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        ArrayList b = new ArrayList(Arrays.asList(1, 3, 5));
        Main.merge(a, b);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 5, 7, 8, 9}, a.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void name2() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList b = new ArrayList(Arrays.asList(2, 4, 5, 5, 6));
        Main.merge(a, b);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5, 5, 6}, a.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void name3() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList b = new ArrayList(Arrays.asList(2, 4, 5, 5, 6));
        Main.merge(a, b);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5, 5, 6}, a.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void Valicname() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList b = new ArrayList(Arrays.asList(2, 4, 5));
        Main.ValicMerge(a, b);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5}, a.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void Valicname1() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        ArrayList b = new ArrayList(Arrays.asList(1, 3, 5));
        Main.ValicMerge(a, b);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 5, 7, 8, 9}, a.stream().mapToInt(Integer::intValue).toArray());
    }

    @Test
    public void Valicname2() throws Exception {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList b = new ArrayList(Arrays.asList(2, 4, 5, 5, 6));
        Main.ValicMerge(a, b);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4, 5, 5, 6}, a.stream().mapToInt(Integer::intValue).toArray());
    }
}
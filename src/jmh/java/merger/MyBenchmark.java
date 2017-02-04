package merger;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

    private ArrayList b;
    private ArrayList<Integer> a;


    @Param(value = {"10", "100", "1000"})
    private long aLimit;

    @Setup
    public void onStart() {
        Random random = new Random();
        a = Stream.generate(random::nextInt)
                .limit(aLimit)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        b = Stream.generate(random::nextInt)
                .limit(aLimit)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }


    @Benchmark
    public List justSort() {
        ArrayList<Integer> integers = new ArrayList<>(a);
        integers.addAll(b);
        Collections.sort(integers);
        return integers;
    }

    @Benchmark
    public List treeSort() {
        ArrayList<Integer> integers = new ArrayList<>(a);
        TreeSet<Integer> objects = new TreeSet<>();
        objects.addAll(a);
        objects.addAll(b);
        integers.removeIf(x -> true);
        integers.addAll(objects);
        return integers;
    }
}

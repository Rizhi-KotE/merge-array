package merger;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

    private ArrayList b;
    private ArrayList<Integer> a;


    private long aLimit = 1000;
    private long bLimit = 1000;

    @Setup
    public void onStart() {
        Random random = new Random();
        a = Stream.generate(random::nextInt)
                .limit(aLimit)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        b = Stream.generate(random::nextInt)
                .limit(bLimit)
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }


    @Benchmark
    public List<Integer> valik() {
        ArrayList<Integer> a = new ArrayList<>(this.a);
        Main.ValicMerge(a, b);
        return a;
    }

    @Benchmark
    public List<Integer> my() {
        ArrayList<Integer> a = new ArrayList<>(this.a);
        Main.merge(a, b);
        return a;
    }
}

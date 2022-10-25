package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    List<Integer> list;
    @BeforeEach
    public void test1(){
        list = Arrays.asList(1,2,4,2,5);
    }
    public void init_max_bug_7263(){
        list = Arrays.asList(-1, -4, -5);
    }

    public void init_distinct_bug_8726(){
        list = Arrays.asList(1, 2, 4, 2);
    }


    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void max_bug_7263() {
        init_max_bug_7263();
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class DedublicatorStub implements GenericListDeduplicator{

            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4, 5);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, new DedublicatorStub());

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        class DedublicatorStub implements GenericListDeduplicator{

            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4);
            }
        }

        init_distinct_bug_8726();
        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list, new DedublicatorStub());

        Assertions.assertEquals(3, distinct);
    }
}

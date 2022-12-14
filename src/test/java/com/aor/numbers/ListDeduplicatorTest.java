package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    List<Integer> list;
    public void init_distinct_bug_8726(){
        list = Arrays.asList(1, 2, 4, 2);
    }
    @Test
    public void deduplicate() {
        class StubListSorter implements GenericListSorter{
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4,5);
            }
        }
        list = Arrays.asList(1,2,4,2,5);
        StubListSorter sorter = new StubListSorter();

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);
        List<Integer> expected = Arrays.asList(1,2,4,5);

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void bug_deduplicate_8726() {
        init_distinct_bug_8726();
        List<Integer> expected = Arrays.asList(1,2,4);
        class StubListSorter implements GenericListSorter{
            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4);
            }
        }

        StubListSorter sorter = new StubListSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
}

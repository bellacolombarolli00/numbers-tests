package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {
    @Test
    public void positive() {
        PositiveFilter filter = new PositiveFilter();
        boolean test = filter.accept(1);
        Assertions.assertEquals(true, test);
    }
    @Test
    public void negative() {
        PositiveFilter filter = new PositiveFilter();
        boolean test = filter.accept(-1);
        Assertions.assertEquals(false, test);
    }
    @Test
    public void zero() {
        PositiveFilter filter = new PositiveFilter();
        boolean test = filter.accept(0);
        Assertions.assertEquals(true, test);
    }
}

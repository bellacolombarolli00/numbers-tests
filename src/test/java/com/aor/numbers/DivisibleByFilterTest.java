package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {
    @Test
    public void isDivisiblePositivePositive(){
        DivisibleByFilter filter = new DivisibleByFilter(2);
        boolean test = filter.accept(4);
        Assertions.assertEquals(true, test);
    }
    @Test
    public void isDivisiblePositiveNegative(){
        DivisibleByFilter filter = new DivisibleByFilter(2);
        boolean test = filter.accept(-44);
        Assertions.assertEquals(true, test);
    }
    @Test
    public void isDivisiblePositiveEquals(){
        DivisibleByFilter filter = new DivisibleByFilter(2);
        boolean test = filter.accept(2);
        Assertions.assertEquals(true, test);
    }
    @Test
    public void isDivisibleNegativePositive(){
        DivisibleByFilter filter = new DivisibleByFilter(-2);
        boolean test = filter.accept(-4);
        Assertions.assertEquals(true, test);
    }
    @Test
    public void isNotDivisible(){
        DivisibleByFilter filter = new DivisibleByFilter(2);
        boolean test = filter.accept(-1);
        Assertions.assertEquals(false, test);
    }
}

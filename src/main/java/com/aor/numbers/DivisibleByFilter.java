package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    Integer divide;
    DivisibleByFilter(Integer divide){
        this.divide = divide;
    }
    @Override
    public boolean accept(Integer number) {
        if(number%divide == 0) return true;
        return false;
    }
}

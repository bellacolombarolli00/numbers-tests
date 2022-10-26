package com.aor.numbers;

import java.util.List;

public class ListFilter {
    GenericListFilter filter;
    public ListFilter(GenericListFilter filter) {
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(filter.accept(list.get(i))==false){
                list.remove(i);
            }
        }
        return list;
    }
}

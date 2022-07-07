package com.example.tffsjavarestapi.utils.crud;

import javax.persistence.criteria.CriteriaBuilder;

public interface ReadOne<T, TKey>{
    T findOne(TKey id);
}

package com.example.tffsjavarestapi.utils.crud;

import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ReadAll<T, TKey> {
    static final int DEFAULT_SIZE = 20;
    List<T> findAll();
    Page<T> findAll(int page);
    Page<T> findAll(int page, int size);
    List<T> findAllByIds(List<TKey> ids);
    Page<T> findAllByIds(List<TKey> ids, int page);
    Page<T> findAllByIds(List<TKey> ids, int page, int size);
}

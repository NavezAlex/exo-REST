package com.example.tffsjavarestapi.utils.crud;

public interface Update<T, TKey> {
    T update(TKey id, T element);
}

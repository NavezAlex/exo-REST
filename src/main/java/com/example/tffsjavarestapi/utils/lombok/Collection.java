package com.example.tffsjavarestapi.utils.lombok;

public interface Collection<T> {
    boolean add(T e);
    boolean addAll(Collection<? extends T> c);
    boolean remove(T e);
    boolean clear();
    T get(int index);
}

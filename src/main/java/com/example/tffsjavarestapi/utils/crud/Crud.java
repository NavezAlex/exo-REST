package com.example.tffsjavarestapi.utils.crud;

public interface Crud<T, TKey> extends Create<T>, Read<T, TKey>, Update<T, TKey>, Delete<TKey> {
}

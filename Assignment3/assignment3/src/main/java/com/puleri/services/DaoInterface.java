package com.puleri.services;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface<T, Id extends Serializable> {
    List<T> all();
    T get(Id id);
    T create(T t);
    void delete(T t);
    T update(T t);
    List<T> search(String field, String value);
}

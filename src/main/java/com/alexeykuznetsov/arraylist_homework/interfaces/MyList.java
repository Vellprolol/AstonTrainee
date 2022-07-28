package com.alexeykuznetsov.arraylist_homework.interfaces;

import java.util.Collection;
import java.util.function.UnaryOperator;

public interface MyList<E> {
    boolean add(E e);

    E add(int index, E e);

    boolean remove(Object o);

    E remove(int index);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index, Collection<? extends E> c);

    boolean clear();

    E get(int index);

    int indexOf(Object o);

    boolean isEmpty();

//    boolean removeAll(Collection<?> c);

    void replaceAll(UnaryOperator<E> operator);

    E set(int index, E element);

    int size();
}

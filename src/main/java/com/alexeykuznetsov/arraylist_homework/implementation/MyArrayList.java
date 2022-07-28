package com.alexeykuznetsov.arraylist_homework.implementation;

import com.alexeykuznetsov.arraylist_homework.interfaces.MyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.UnaryOperator;

public class MyArrayList<E> implements MyList<E>, Iterator<E> {

    private final int INIT_SIZE = 10;
    private final int CUT_RATE = 2;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;
    private int currentIndex = 0;

    @Override
    public boolean add(E e) {
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        array[pointer++] = e;
        return true;
    }

    @Override
    public E add(int index, E e) {
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        for (int i = index; i < pointer; i++) {
            array[i + 1] = array[i];
        }
        array[index] = e;
        return (E) array[index];
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] toAdd = c.toArray();
        if (toAdd.length == 0) {
            return false;
        }
        int tmp = pointer;
        pointer = pointer + toAdd.length;
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        for (int i = 0; i < toAdd.length; i++) {
            array[tmp++] = toAdd[i];
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] toAdd = c.toArray();
        if (toAdd.length == 0) {
            return false;
        }
        pointer = pointer + toAdd.length;
        if (pointer == array.length - 1) {
            resize(array.length * 2);
        }
        for (int i = pointer; i > index; i--) {
            array[i] = array[i - toAdd.length];
        }
        for (int i = 0; i < toAdd.length; i++) {
            array[index++] = toAdd[i];
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int tmp = 0;
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(o)) {
                array[i] = null;
                tmp = i;
                break;
            }
        }
        if (tmp != 0) {
            for (int i = tmp; i < pointer; i++) {
                array[i] = array[i + 1];
            }
            pointer--;
            if (!(array[tmp].equals(o))) {
                return true;
            }
        }
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
            resize(array.length / 2);
        }
        return false;
    }

    @Override
    public E remove(int index) {
        E oldValue = (E) array[index];
        for (int i = index; i < pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
            resize(array.length / 2);
        }
        return oldValue;
    }

    @Override
    public boolean clear() {
        int tmp = pointer;
        for (int i = 0; i < tmp; i++) {
            array[i] = null;
            pointer--;
        }
        if (array.length > INIT_SIZE) {
            resize(INIT_SIZE);
        }
        if (pointer != 0) {
            return false;
        }
        return true;
    }

    @Override
    public E get(int index) {
        if (index >= pointer || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (pointer == 0) {
            return true;
        }
        return false;
    }

//    @Override
//    public boolean removeAll(Collection<?> c) {
//        Object[] toRemove = c.toArray();
//        if (toRemove.length == 0) {
//            return false;
//        }
//        outer:
//        for (int i = 0; i < pointer; i++) {
//            inner:
//            for (int j = 0; j < toRemove.length; j++) {
//                if (array[i].equals(toRemove[j])) {
//                    array[i] = null;
//                    break inner;
//                }
//            }
//        }
//        for (int i = 0; i < pointer; i++) {
//            for (int j = 0; j < pointer; j++) {
//                if (array[i] == null) {
//                    array[i] = array[i + 1];
//                }
//            }
//        }
//        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE) {
//            resize(array.length / 2);
//        }
//        return true;
//    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        for (int i = 0; i < pointer; i++) {
            array[i] = operator.apply((E) array[i]);
        }
    }

    @Override
    public E set(int index, E element) {
        if (index >= pointer || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = element;
        return (E) array[index];
    }

    @Override
    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        for (int i = 0; i < pointer; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < pointer && array[currentIndex] != null;
    }

    @Override
    public E next() {
        return (E) array[currentIndex++];
    }
}

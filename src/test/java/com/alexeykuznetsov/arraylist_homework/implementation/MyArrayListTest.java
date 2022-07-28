package com.alexeykuznetsov.arraylist_homework.implementation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<String> actual = new MyArrayList<>();
    List<String> subList = new ArrayList<>();

    public void init() {
        actual.add("Hello");
        actual.add("This");
        actual.add("Is");
        actual.add("Tests");
        actual.add("For");
        actual.add("My");
        actual.add("ArrayList");
        actual.add("Hello");
        actual.add("This");
        actual.add("Is");
        actual.add("Tests");
        actual.add("For");
        actual.add("My");
        actual.add("ArrayList");
    }

    public void initSubList() {
        subList.add("Homework");
        subList.add("Aston");
    }

    @Test
    void addElementAtTheEndTest() {
        assertTrue(actual.add("Homework"));
        assertEquals("Homework", actual.get(actual.size() - 1));
    }

    @Test
    void addWithIndexTest1() {
        init();
        assertEquals("JUnit", actual.add(4, "JUnit"));
    }

    @Test
    void addWithIndexTest2() {
        init();
        assertEquals("Friends", actual.add(1, "Friends"));
    }

    @Test
    void addAllTrueTest() {
        init();
        initSubList();
        assertTrue(actual.addAll(subList));
    }

    @Test
    void addAllFalseTest() {
        init();
        assertFalse(actual.addAll(subList));
    }

    @Test
    void addAllWithIndexTrueTest() {
        init();
        initSubList();
        assertTrue(actual.addAll(4, subList));
    }

    @Test
    void addAllWithIndexFalseTest() {
        init();
        assertFalse(actual.addAll(4, subList));
    }

    @Test
    void removeObjectTest() {
        init();
        assertTrue(actual.remove("Is"));
        assertFalse(actual.remove("Homework"));
    }

    @Test
    void removeWithIndexTest() {
        init();
        assertEquals("Tests", actual.remove(3));
        assertEquals("For", actual.get(3));
    }

    @Test
    void clearTest() {
        init();
        assertTrue(actual.clear());
    }

    @Test
    void getListElementTest() {
        init();
        assertEquals("Is", actual.get(2));
    }

    @Test
    void getElementWithWrongIndex() {
        init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            actual.get(20);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            actual.get(-1);
        });
    }

    @Test
    void indexOfElementInTheList() {
        init();
        assertEquals(0, actual.indexOf("Hello"));
    }

    @Test
    void indexOfElementNotFromList() {
        init();
        assertEquals(-1, actual.indexOf("Some"));
    }

    @Test
    void isEmptyTest1() {
        assertTrue(actual.isEmpty());
    }

    @Test
    void isEmptyTest2() {
        init();
        assertFalse(actual.isEmpty());
    }

    //    @Test
//    void removeAll() {
//    }
//
    @Test
    void setTest() {
        init();
        assertEquals("Correct", actual.set(2, "Correct"));
    }

    @Test
    void setTestOutOfBound() {
        init();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            actual.set(20, "Broken");
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            actual.set(-1, "Broken");
        });
    }

    @Test
    void sizeTest() {
        init();
        assertEquals(14, actual.size());
    }

    @Test
    void sizeTestWithAdd() {
        init();
        actual.add("Aston");
        assertEquals(15, actual.size());
    }

    @Test
    void sizeTestWithAddAll() {
        init();
        initSubList();
        actual.addAll(subList);
        assertEquals(16, actual.size());
    }

    @Test
    void sizeTestWithRemove() {
        init();
        actual.remove("Is");
        assertEquals(13, actual.size());
    }
//    @Test
//    void sizeTestWithRemoveAll() {
//        init();
//        assertEquals(7, actual.size());
//    }


    @Test
    void emptyListSizeTest() {
        assertEquals(0, actual.size());
    }
}
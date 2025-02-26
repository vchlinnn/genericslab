/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.grinnell.csc207.genericslab;

/**
 * A linked implementation of the list ADT.
 *
 * @param <T>
 */
public class LinkedList<T> {

    private static class Node<T> {

        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     *
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        if (first == null) {
            first = new Node<T>(value, null);
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node<T>(value, null);
        }
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = (T) cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
    
    public void intersperse(T sep) {
        if (first == null) {
            return;
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                Node<T> newNode = new Node<>(sep, cur.next);
                cur = newNode;
                cur = cur.next;
            } 
        }
    }
    
    /* We cannot implement this because there is no way to compare the value with T 
    without knowing what type is T
    */
    public T maximum() {
//        if (first == null) {
//            return null;
//        } else {
//            T max = first.value;
//            Node<T> cur = first;
//            while (cur.next != null) {
//                if (cur.value > max) {
//                    max = cur.value;
//                    cur = cur.next;
//                }
//            } 
//        }
        throw new UnsupportedOperationException();
    }
    
    /* We cannot implement this because there is no way to convert T to a string
    without knowing what type is T
    */
    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
    
    /* We cannot implement this because there is no way to compare the value of  T 
    without knowing what type is T
    */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }
}

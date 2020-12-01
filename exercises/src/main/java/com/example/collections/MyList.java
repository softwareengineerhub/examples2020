package com.example.collections;

import java.util.EmptyStackException;

public class MyList<T> {

    protected static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

    }

    Node<T> first;

    public MyList() {
    }

    public int size() {
        if (first == null) return 0;
        else {
            int counter = 1;
            Node<T> index = first;
            while (index.next != null) {
                index = index.next;
                counter++;
            }
            return counter;
        }
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        Node<T> index = first;
        if (first == null) first = newNode;
        else {
            while (index.next != null) index = index.next;
            index.next = newNode;
        }
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (first != null) newNode.next = first;
        first = newNode;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T get(int index) {
        if (first == null || index >= size() || index < 0) throw new IndexOutOfBoundsException();
        Node<T> nodeIndex = first;
        for (int i = 0; i < index; i++) {
            nodeIndex = nodeIndex.next;
        }
        return nodeIndex.element;
    }

    public boolean set(int index, T element) {
        if (first == null || index >= size() || index < 0) return false;
        Node<T> nodeIndex = first;
        for (int i = 0; i < index; i++) {
            nodeIndex = nodeIndex.next;
        }
        nodeIndex.element = element;
        return true;
    }

    public T remove(int index) {
        if (first == null || index >= size() || index < 0) throw new IndexOutOfBoundsException();
        Node<T> nodeIndex = first;
        Node<T> prevIndex = first;
        for (int i = 0; i < index; i++) {
            prevIndex = nodeIndex;
            nodeIndex = nodeIndex.next;
        }
        prevIndex.next = nodeIndex.next;
        return nodeIndex.element;
    }

    public T removeFirst() {
        if (first==null) throw new EmptyStackException();
        T element = first.element;
        first = first.next;
        return element;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (first != null) {
            Node<T> nodeIndex = first;
            while (nodeIndex != null) {
                sb.append(nodeIndex.element.toString());
                nodeIndex = nodeIndex.next;
                if (nodeIndex != null) sb.append(",");
            }

        }
        return sb.append("]").toString();
    }

}

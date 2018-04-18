package com.beibei.homework.graph.collection;

public class Node<T extends Object> {

    private T value;
    private boolean deleted = false;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return this.value.equals(((Node) obj).getValue());
        }
        return false;
    }
}

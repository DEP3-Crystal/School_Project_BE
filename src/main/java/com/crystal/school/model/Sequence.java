package com.crystal.school.model;

public class Sequence {
    private int id;

    public Sequence() {
        id = 0;
    }

    public synchronized Integer nextId() {
        return ++id;
    }
}

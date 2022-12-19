package com.crystal.school.excption;

public class InvalidLength extends RuntimeException {
    public InvalidLength(String s) {
        super(s);
    }
}
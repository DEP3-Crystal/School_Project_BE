package com.crystal.school.model.enums;

public enum Role {
    ADMIN("a"),
    TEACHER("t"),
    ORGANIZER("o");

    private final String value;

    Role(String value) {
        this.value = value;
    }


    public static Role getEnum(String name) {
        switch (name) {
            case "a", "ADMIN" -> {
                return ADMIN;
            }
            case "o", "ORGANIZER" -> {
                return ORGANIZER;
            }
            case "t","TEACHER" -> {
                return TEACHER;
            }
            default -> throw new EnumConstantNotPresentException(Role.class, "couldn't find correct enum name: " + name);
        }
    }
}


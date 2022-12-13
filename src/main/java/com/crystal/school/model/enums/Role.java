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
        switch (name.toLowerCase()) {
            case "a", "admin" -> {
                return ADMIN;
            }
            case "o", "organizer" -> {
                return ORGANIZER;
            }
            case "t","teacher" -> {
                return TEACHER;
            }
            default -> throw new EnumConstantNotPresentException(Role.class, "couldn't find correct enum name: " + name);
        }
    }
}


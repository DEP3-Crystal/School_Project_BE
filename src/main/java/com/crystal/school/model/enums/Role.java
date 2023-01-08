package com.crystal.school.model.enums;

public enum Role {
    STUDENT,
    EMPLOYEE,
    ADMIN,
    TEACHER,
    ORGANIZER;

//    private final String value;

//    Role(String value) {
//        this.value = value;
//    }


    public static Role getEnum(String name) {
        switch (name.toLowerCase()) {
            case "a", "admin" -> {
                return ADMIN;
            }
            case "o", "organizer" -> {
                return ORGANIZER;
            }
            case "t", "teacher" -> {
                return TEACHER;
            }
            case "s", "student" -> {
                return STUDENT;
            }
            case "e", "employee" -> {
                return EMPLOYEE;
            }
            default ->
                    throw new EnumConstantNotPresentException(Role.class, "couldn't find correct enum name: " + name);
        }
    }
}


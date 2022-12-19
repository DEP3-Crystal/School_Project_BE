package com.crystal.school.dao;

import com.crystal.school.model.School;

import java.util.List;

public interface DataAccess {
    List<School> getSchools();

    void saveSchools(List<School> schools);
}

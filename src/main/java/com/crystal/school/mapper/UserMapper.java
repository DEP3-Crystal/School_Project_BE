package com.crystal.school.mapper;

import com.crystal.school.dto_old.UserInfoDto;
import com.crystal.school.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper Instance = Mappers.getMapper(UserMapper.class);

    User toUser(UserInfoDto userInfoDto);

    UserInfoDto toUserDto(User user);
}

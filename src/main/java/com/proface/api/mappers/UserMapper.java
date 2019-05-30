package com.proface.api.mappers;

import com.proface.api.entities.User;
import com.proface.api.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends IProfaceMapper<UserModel, User> {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
}
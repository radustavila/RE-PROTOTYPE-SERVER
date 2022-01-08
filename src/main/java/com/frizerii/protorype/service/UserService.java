package com.frizerii.protorype.service;


import com.frizerii.protorype.dto.TokenDto;
import com.frizerii.protorype.dto.UserLoginDto;
import com.frizerii.protorype.entity.UsersEntity;
import com.frizerii.protorype.helper.exception.UserException;

public interface UserService {

    UsersEntity registerUser(UsersEntity userEntity) throws UserException;

    TokenDto loginUser(UserLoginDto userLoginDto) throws UserException;

}

package com.frizerii.protorype.service;

import com.frizerii.protorype.dto.TokenDto;
import com.frizerii.protorype.dto.UserLoginDto;
import com.frizerii.protorype.entity.UsersEntity;
import com.frizerii.protorype.helper.exception.UserException;
import com.frizerii.protorype.helper.jwt.JwtTokenProvider;
import com.frizerii.protorype.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UsersEntity registerUser(UsersEntity userEntity) throws UserException {
        validateNewUser(userEntity);

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        UsersEntity usersEntity = userRepository.save(userEntity);

        return userRepository.save(usersEntity);
    }

    @Override
    public TokenDto loginUser(UserLoginDto userLogin) throws UserException {

        UsersEntity user = validateUserLogin(userLogin);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(jwtTokenProvider
                .createJwt(user.getId(), user.getEmail()));

//        TokensDto tokensDto = new TokensDto();
//        tokensDto.setAuthToken(jwtTokenProvider
//                .createJwt(user.getId(), user.getEmail()));
//        tokensDto.setInstaToken(user.getAccessTokenInstagram() != null ? user.getAccessTokenInstagram() : "");

//        return tokensDto;
        return tokenDto;
    }


    private UsersEntity validateUserLogin(UserLoginDto user) throws UserException {
        UsersEntity usersEntity = userRepository.findByEmail(user.getEmail());
        if (usersEntity == null) {
            throw new UserException("Invalid credentials!");
        }

        if (!passwordEncoder.matches(user.getPassword(), usersEntity.getPassword()) && !user.getWithFacebook()) {
            throw new UserException("Wrong password!");
        }

        return usersEntity;
    }

    private void validateNewUser(UsersEntity usersEntity) throws UserException {
        String errors = "";

        UsersEntity usersEntity1 = userRepository.findByEmail(usersEntity.getEmail());
        if (usersEntity1 != null) {
            errors += "This email is already taken! ";
        }

        if (!errors.equals("")) {
            throw new UserException(errors);
        }
    }
}

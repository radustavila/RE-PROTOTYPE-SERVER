package com.frizerii.protorype.dto;

import lombok.Data;

@Data
public class UserLoginDto {

    private String email;
    private String password;
    private Boolean withFacebook;

}

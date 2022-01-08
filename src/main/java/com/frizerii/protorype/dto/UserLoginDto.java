package com.frizerii.protorype.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserLoginDto {

    private String email;
    private String password;
    private Boolean withFacebook;

}

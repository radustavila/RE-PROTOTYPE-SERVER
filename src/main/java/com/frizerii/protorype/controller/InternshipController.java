package com.frizerii.protorype.controller;

import com.frizerii.protorype.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InternshipController {

    private final UserService userService;

    @GetMapping("")
    public String test() {
        return "OK";
    }

}

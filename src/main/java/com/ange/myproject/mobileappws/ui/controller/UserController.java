package com.ange.myproject.mobileappws.ui.controller;

import com.ange.myproject.mobileappws.service.UserService;
import com.ange.myproject.mobileappws.shared.dto.UserDto;
import com.ange.myproject.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.ange.myproject.mobileappws.ui.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://loaclhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, createUser);

        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}

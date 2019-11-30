package yq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yq.service.UserService;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/get")
    public Map<String,String> getUser(){
        return  this.userService.getUser();
    }
}

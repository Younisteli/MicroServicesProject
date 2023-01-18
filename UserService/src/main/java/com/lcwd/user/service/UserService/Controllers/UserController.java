package com.lcwd.user.service.UserService.Controllers;
import com.lcwd.user.service.UserService.Model.User;
import com.lcwd.user.service.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser =  userService.saveUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User findUser = userService.getUser(userId);
        return new ResponseEntity<>(findUser,HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<List<User>> AllUsers(){

        List<User> alluserslist = userService.getAllUser();
        return new ResponseEntity<>(alluserslist,HttpStatus.OK);
    }

}

package com.ikub.jdbc.springbootjdbc.controller;

import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.User;
import com.ikub.jdbc.springbootjdbc.service.CategoryService;
import com.ikub.jdbc.springbootjdbc.service.PostService;
import com.ikub.jdbc.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable long userId) {
        User theUser = userService.getUserById(userId);

        return theUser;
    }

    @PostMapping
    public ResponseEntity<Boolean> addUser(@RequestBody User newUser){
        newUser.setId(0);
     boolean u= userService.createUser(newUser);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    //update user
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable Long id, @RequestBody User newUser){
        newUser.setId(0);
        boolean userUpdated= userService.updateUser(id, newUser);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
        boolean userDeleted= userService.deleteUser(id);
        return new ResponseEntity<>(userDeleted, HttpStatus.OK);
    }


}

package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsers();
    Users getUserById(Long id);
    Boolean createUser(Users user);
    Boolean updateUser(Long id, Users user);
    Boolean deleteUser(Long id);
}

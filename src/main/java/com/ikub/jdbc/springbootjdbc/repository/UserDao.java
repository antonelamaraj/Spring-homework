package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Users;

import java.util.List;

public interface UserDao {

    List<Users> getUsers();
    Users getUserById(Long id);
    Boolean createUser(Users user);
    Boolean updateUser(Long id, Users user);
    Boolean deleteUser(Long id);

}

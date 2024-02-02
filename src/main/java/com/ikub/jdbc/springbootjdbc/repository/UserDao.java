package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    User getUserById(Long id);
    Boolean createUser(User user);
    Boolean updateUser(Long id, User user);
    Boolean deleteUser(Long id);

}

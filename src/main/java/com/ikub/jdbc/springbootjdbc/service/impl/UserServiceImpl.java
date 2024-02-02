package com.ikub.jdbc.springbootjdbc.service.impl;

import com.ikub.jdbc.springbootjdbc.entity.User;
import com.ikub.jdbc.springbootjdbc.repository.UserDao;
import com.ikub.jdbc.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Boolean createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        return userDao.updateUser(id, user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}

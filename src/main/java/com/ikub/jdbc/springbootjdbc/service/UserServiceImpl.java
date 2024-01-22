package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.Users;
import com.ikub.jdbc.springbootjdbc.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<Users> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public Users getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public Boolean createUser(Users user) {
        return userDao.createUser(user);
    }

    @Override
    public Boolean updateUser(Long id, Users user) {
        return userDao.updateUser(id, user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}

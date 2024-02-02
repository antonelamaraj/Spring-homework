package com.ikub.jdbc.springbootjdbc.repository.impl;

import com.ikub.jdbc.springbootjdbc.exception.UserAlreadyExistsException;
import com.ikub.jdbc.springbootjdbc.exception.UserNotFoungException;
import com.ikub.jdbc.springbootjdbc.mapper.UserMapper;
import com.ikub.jdbc.springbootjdbc.entity.User;
import com.ikub.jdbc.springbootjdbc.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    private static final String GET_USERS_Q = "SELECT * FROM users";
    private static final String GET_USER_BY_ID_Q = "SELECT * FROM users WHERE id=?";
    private static final String CREATE_USER_Q = "INSERT INTO users(username,email,password,date_created,date_modified) VALUES(?,?,?,?,?)";
    private static final String UPDATE_USER_Q = "UPDATE users SET username = ?, email = ?, password = ?,date_created=?, date_modified = ? WHERE id = ?";
    private static final String DELETE_USER_Q = "DELETE FROM users WHERE id = ?";


    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query(GET_USERS_Q, new UserMapper());
    }

    @Override
    public User getUserById(Long id) {
        try {
            return jdbcTemplate.queryForObject(GET_USER_BY_ID_Q, new UserMapper(), id);
        }catch (EmptyResultDataAccessException ex){
            throw new UserNotFoungException("User with id: " + id + " does not exists");
        }
    }

    @Override
    public Boolean createUser(User user) {
        try {
         jdbcTemplate.update(CREATE_USER_Q, new Object[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getDateCreated(), user.getDateModified()}, new GeneratedKeyHolder());
            return true;
        } catch (DuplicateKeyException dl) {
            throw new UserAlreadyExistsException("User already exists");
        }
    }
    @Override
    public Boolean updateUser(Long id, User user) {
        var userUpdated = jdbcTemplate.update(UPDATE_USER_Q, new Object[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getDateCreated(), user.getDateModified(), id});
        if (userUpdated < 0){
            throw new UserNotFoungException("User with id " + id + " is not found/Cannot be updated");
        }
        return userUpdated == -1 ? false : true;
    }

    @Override
    public Boolean deleteUser(Long id) {
        var userDeleted = jdbcTemplate.update(DELETE_USER_Q, new Object[]{id});
        if (userDeleted < 0 ){
            throw new UserNotFoungException("User with id " + id + " is not found/CannotBe deleted");
        }
        return userDeleted == -1 ? false : true;
    }
}

package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static String GET_ALL_USERS_U = "SELECT * from users";
    public static String GET_USER_By_ID = "SELECT * from users where id=?";

    public static String INSERT_USER_U = "INSERT INTO users(username, email,password,date_created, date_modified) VALUES (?,?,?,?,?)";

    public static String UPDATE_USER_U = "UPDATE users SET username=?, email=?, password=?, date_created=?, date_modified=? where ID =?";
    public static String DELETE_USER_BY_ID = "DELETE from users where id=?";

    @Override
    public List<Users> getUsers() {
        return jdbcTemplate.query(GET_ALL_USERS_U, new BeanPropertyRowMapper<>(Users.class));
    }

    @Override
    public Users getUserById(Long id) {
        return jdbcTemplate.queryForObject(GET_USER_By_ID, new BeanPropertyRowMapper<>(Users.class),id);
    }

    @Override
    public Boolean createUser(Users user) {
       var userCreated =  jdbcTemplate.update(INSERT_USER_U, new Object[]{ user.getUsername(), user.getEmail(), user.getPassword(),
                user.getDateCreated(), user.getDateModified()});
        return userCreated !=-1? true:false;
    }

    @Override
    public Boolean updateUser(Long id, Users user) {
        int updateUser = jdbcTemplate.update(UPDATE_USER_U, new Object[]{
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getDateCreated(),
                user.getDateModified(),
                id
        });
        return updateUser == -1 ? false: true;
    }

    @Override
    public Boolean deleteUser(Long id) {
        int deleteUser = jdbcTemplate.update(DELETE_USER_BY_ID, new Object[]{id});

        return deleteUser == -1? false : true;
    }
}

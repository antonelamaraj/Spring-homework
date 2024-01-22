package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PostDaoImpl implements PostDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static String GET_ALL_POSTS ="SELECT * FROM POSTS";
    public static String GET_POST_BY_ID ="SELECT * FROM POSTS WHERE ID=?";
    public static String GET_ALL_USER_POSTS_BY_ID = "SELECT * from POSTS p INNER JOIN USERS u ON u.id=p.user_id where u.id=?";

    public static String INSERT_INTO_POST = "INSERT INTO POSTS(title, body, user_id, date_created, date_modified) VALUES(?,?,?,?,?)";
    public static String UPDATE_POST_BY_ID="UPDATE POSTS SET title=?, body=?, user_id=?, date_created=?, date_modified=? where ID=?";

    @Override
    public List<Post> getPosts() {
        return jdbcTemplate.query(GET_ALL_POSTS, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public Post getPostsById(Long id) {
        return jdbcTemplate.queryForObject(GET_POST_BY_ID, new BeanPropertyRowMapper<>(Post.class), id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return jdbcTemplate.query(GET_ALL_USER_POSTS_BY_ID, new BeanPropertyRowMapper<>(Post.class), userId);
    }

    @Override
    public Boolean createPost(Post post) {
        var postCreated = jdbcTemplate.update(INSERT_INTO_POST, new Object[]{  post.getTitle(), post.getBody(), post.getUserId(), post.getDateCreated(), post.getDateModified()});
        return postCreated !=-1 ? true:false;
    }

    @Override
    public Boolean updatePost(Long id, Post post) {
        int postUpdated = jdbcTemplate.update(UPDATE_POST_BY_ID, new Object[]{
                post.getTitle(),
                post.getBody(),
                post.getUserId(),
                post.getDateCreated(),
                post.getDateModified(),
                id
        });
        return postUpdated ==-1 ? false: true;
    }
}

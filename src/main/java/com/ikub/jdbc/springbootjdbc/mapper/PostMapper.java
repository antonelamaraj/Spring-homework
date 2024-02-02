package com.ikub.jdbc.springbootjdbc.mapper;

import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {
//    @Override
//    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
//        var post = new Post();
//        post.setId(rs.getInt("id")); // Assuming 1st column is post ID
//        post.setTitle(rs.getString("title")); // Assuming 2nd column is post title
//        post.setBody(rs.getString("body")); // Assuming 3rd column is post body
//        post.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null); // Assuming 10th column is post's date created
//        post.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null); // Assuming 11th column is post's date modified
//
//        User user = new UserMapper().mapRow(rs, rowNum);
//        post.setUserId(user);
//        return post;
//    }

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("title"));
        post.setBody(rs.getString("body"));
        post.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        post.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);

        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setDateCreated(rs.getDate("date_created") != null ? rs.getDate("date_created").toLocalDate() : null);
        user.setDateModified(rs.getDate("date_modified") != null ? rs.getDate("date_modified").toLocalDate() : null);

        post.setUser(user);

        return post;
    }
}

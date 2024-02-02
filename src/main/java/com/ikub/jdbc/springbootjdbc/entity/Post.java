package com.ikub.jdbc.springbootjdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Post {

    private Integer id;
    private String title;
    private String body;
    private User user;
    private LocalDate dateCreated;
    private LocalDate dateModified;

}

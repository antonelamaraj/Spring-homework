package com.ikub.jdbc.springbootjdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PostCategory {

    private Integer id;
    private Post post;
    private Category category;
    private LocalDate dateCreated;
    private LocalDate dateModified;

}

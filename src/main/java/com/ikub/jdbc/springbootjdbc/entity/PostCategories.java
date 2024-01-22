package com.ikub.jdbc.springbootjdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PostCategories {

    private Integer id;
    private Integer postId;
    private Integer categoryId;
    private LocalDate dateCreated;
    private LocalDate dateModified;

}

package com.ikub.jdbc.springbootjdbc.entity;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalDate dateCreated;
    private LocalDate dateModified;

}

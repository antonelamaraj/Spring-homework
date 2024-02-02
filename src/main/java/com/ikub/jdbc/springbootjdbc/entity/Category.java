package com.ikub.jdbc.springbootjdbc.entity;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Category {

    private Integer id;
    private String name;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}

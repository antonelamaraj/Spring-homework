package com.ikub.jdbc.springbootjdbc.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {

    private LocalDateTime timstamp;
    private String message;
    private String path;
    private Integer errorCode;
}

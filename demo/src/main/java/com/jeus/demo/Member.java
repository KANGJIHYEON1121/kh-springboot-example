package com.jeus.demo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// lombok annotation
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
// @EqualsAndHashCode(of = {"boardNo","title"})
@Data
public class Member {
    private String userId;
    private String password;

    @Valid
    private User user;

    private String gender;
    // Date 타입 필드 변환처리
    @DateTimeFormat(pattern = "yyyyMMdd")
    private Date dateOfBirth;
    private List<String> nationality;

    private Board board;
}

package com.kh.springjdbcmember.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int no;
    private String id;
    private String pwd;
    private String name;
    private Date regDate;
}

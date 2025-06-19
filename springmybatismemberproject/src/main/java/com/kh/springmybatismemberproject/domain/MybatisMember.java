package com.kh.springmybatismemberproject.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MybatisMember {
    private int no;
    private String id;
    private String pwd;
    private String name;
    private Date regDate;
}

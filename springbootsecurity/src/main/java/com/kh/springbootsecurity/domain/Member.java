package com.kh.springbootsecurity.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int no;
    private String id;
    private String pw;
    private int coin;
    private String name;
    private Date regDate;
    private Date updDate;
    private String enabled;

    // 1 : N 방식
    private List<MemberAuth> authList;
}
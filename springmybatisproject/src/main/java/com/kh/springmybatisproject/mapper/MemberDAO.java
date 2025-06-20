package com.kh.springmybatisproject.mapper;

import com.kh.springmybatisproject.domain.Member;
import com.kh.springmybatisproject.domain.MemberAuth;

public interface MemberDAO {

    // 회원 삽입
    public void insert(Member member) throws Exception;

    // 회원 권한 삽입
    public void insertAuth(MemberAuth memberAuth) throws Exception;
}

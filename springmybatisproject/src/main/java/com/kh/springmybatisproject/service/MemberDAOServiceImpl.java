package com.kh.springmybatisproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springmybatisproject.domain.Member;
import com.kh.springmybatisproject.domain.MemberAuth;
import com.kh.springmybatisproject.mapper.MemberDAO;

@Service
public class MemberDAOServiceImpl implements MemberDAOService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        // 회원등록처리
        memberDAO.insert(member);
        // 회원권한객체 생성
        MemberAuth memberAuth = new MemberAuth();
        // 회원권한 설정
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");
        // 회원권한 처리
        memberDAO.insertAuth(memberAuth);

    }

    @Override
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        memberDAO.insertAuth(memberAuth);
    }

}

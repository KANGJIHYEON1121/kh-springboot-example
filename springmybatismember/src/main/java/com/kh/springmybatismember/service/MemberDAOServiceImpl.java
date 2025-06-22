package com.kh.springmybatismember.service;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springmybatismember.domain.Member;
import com.kh.springmybatismember.domain.MemberAuth;
import com.kh.springmybatismember.domain.MemberEmail;
import com.kh.springmybatismember.mapper.MemberDAO;

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
        MemberEmail memberEmail = new MemberEmail();
        // 회원권한 설정
        memberAuth.setNo(member.getNo());
        memberAuth.setAuth("ROLE_USER");
        memberEmail.setNo(member.getNo());
        memberEmail.setEmail("USER_EMAIL");
        // 회원권한 처리
        memberDAO.insertAuth(memberAuth);
        memberDAO.insertEmail(memberEmail);
    }

    @Override
    @Transactional
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        memberDAO.insertAuth(memberAuth);
    }

    @Override
    @Transactional
    public void insertEmail(MemberEmail memberEmail) throws Exception {
        memberDAO.insertEmail(memberEmail);
    }

    @Override
    public List<Member> selectAll() throws Exception {
        return memberDAO.selectAll();
    }

    @Override
    public Member selectJoin(Member member) throws Exception {
        return memberDAO.selectJoin(member);
    }

    @Override
    @Transactional
    public void update(Member member) throws Exception {
        // 회원정보 수정 입력
        memberDAO.update(member);
        // 회원정보 권한 삭제
        memberDAO.deleteAuth(member);
        // 이메일 삭제
        memberDAO.deleteEmail(member);

        // 수정된 회원권한 입력
        List<MemberAuth> authList = member.getAuthList();
        for (int i = 0; i < authList.size(); i++) {
            MemberAuth memberAuth = authList.get(i);
            String auth = memberAuth.getAuth();
            if (auth == null) {
                continue;
            }
            if (auth.trim().length() == 0) {
                continue;
            }
            memberAuth.setNo(member.getNo());
            memberDAO.insertAuth(memberAuth);
        }

        // 수정된 회원권한 입력
        List<MemberEmail> emailList = member.getEmailList();
        for (int i = 0; i < emailList.size(); i++) {
            MemberEmail memberEmail = emailList.get(i);
            String email = memberEmail.getEmail();
            if (email == null) {
                continue;
            }
            if (email.trim().length() == 0) {
                continue;
            }
            memberEmail.setNo(member.getNo());
            memberDAO.insertEmail(memberEmail);
        }
    }

    @Override
    @Transactional
    public void delete(Member member) throws Exception {
        memberDAO.deleteAuth(member);
        memberDAO.deleteEmail(member);
        memberDAO.delete(member);
    }

    @Override
    public void deleteAuth(Member member) throws Exception {
        memberDAO.deleteAuth(member);
    }

    @Override
    public void deleteEmail(Member member) throws Exception {
        memberDAO.deleteEmail(member);
    }

}

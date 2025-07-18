package com.kh.springmybatisproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springmybatisproject.domain.Member;
import com.kh.springmybatisproject.domain.MemberAuth;
import com.kh.springmybatisproject.mapper.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    @Transactional
    // 회원정보 권한 설정
    public void insertAuth(MemberAuth memberAuth) throws Exception {
        memberDAO.insertAuth(memberAuth);
    }

    @Override
    // 회원정보 전체 출력
    public List<Member> selectAll() throws Exception {
        return memberDAO.selectAll();
    }

    @Override
    // 회원 정보 출력 (회원, 권한 조인)
    public Member selectJoin(Member member) throws Exception {
        return memberDAO.selectJoin(member);
    }

    @Override
    @Transactional
    // 회원정보 수정
    public void update(Member member) throws Exception {
        // 회원정보 수정 입력
        memberDAO.update(member);
        // 회원정보 권한 삭제
        memberDAO.deleteAuth(member);

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
    }

    @Override
    @Transactional
    // 회원정보 삭제
    public void delete(Member member) throws Exception {
        memberDAO.deleteAuth(member);
        memberDAO.delete(member);
    }

    @Override
    @Transactional
    // 회원정보 권한 삭제
    public void deleteAuth(Member member) throws Exception {
        memberDAO.deleteAuth(member);
    }

}

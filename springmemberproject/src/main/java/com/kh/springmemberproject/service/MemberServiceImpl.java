package com.kh.springmemberproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springmemberproject.domain.Member;
import com.kh.springmemberproject.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO md;

    @Override
    @Transactional
    public void insert(Member member) throws Exception {
        md.insert(member);
    }

    @Override
    public Member select(Member member) throws Exception {
        return md.select(member);
    }

    @Override
    public List<Member> selectAll() throws Exception {
        return md.selectAll();
    }

    @Override
    @Transactional
    public void update(Member member) throws Exception {
        md.update(member);
    }

    @Override
    @Transactional
    public void delete(Member member) throws Exception {
        md.delete(member);
    }
}

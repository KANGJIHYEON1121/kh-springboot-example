package com.kh.springmybatismemberproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springmybatismemberproject.domain.MybatisMember;
import com.kh.springmybatismemberproject.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper mm;

    @Override
    public void insert(MybatisMember member) throws Exception {
        mm.insert(member);
    }

    @Override
    public MybatisMember select(MybatisMember member) throws Exception {
        return mm.select(member);
    }

    @Override
    public void update(MybatisMember member) throws Exception {
        mm.update(member);
    }

    @Override
    public void delete(MybatisMember member) throws Exception {
        mm.delete(member);
    }

    @Override
    public List<MybatisMember> selectAll() throws Exception {
        return mm.selectAll();
    }

}

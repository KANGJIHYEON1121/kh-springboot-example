package com.kh.springmybatisproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springmybatisproject.domain.MybatisBoard;
import com.kh.springmybatisproject.exception.BoardRecordNotFoundException;
import com.kh.springmybatisproject.mapper.BoardDAO;

import lombok.val;

@Service
public class BoardDAOServiceImpl implements BoardDAOService {
    @Autowired
    private BoardDAO bd;

    @Override
    public void insert(MybatisBoard board) throws Exception {
        bd.insert(board);
    }

    @Override
    public MybatisBoard select(MybatisBoard board) throws Exception {
        MybatisBoard _board = bd.select(board);
        if (_board == null) {
            throw new BoardRecordNotFoundException(board.getNo() + " 번 게시글은 없는 게시글입니다.");
        }
        return _board;
    }

    @Override
    public List<MybatisBoard> selectAll() throws Exception {
        return bd.selectAll();
    }

    @Override
    public void update(MybatisBoard board) throws Exception {
        bd.update(board);
    }

    @Override
    public void delete(MybatisBoard board) throws Exception {
        bd.delete(board);
    }

}

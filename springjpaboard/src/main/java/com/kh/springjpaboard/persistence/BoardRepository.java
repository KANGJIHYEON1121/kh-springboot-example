package com.kh.springjpaboard.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springjpaboard.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}

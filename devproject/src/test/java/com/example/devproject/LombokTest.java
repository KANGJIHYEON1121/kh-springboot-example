package com.example.devproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Board;

@SpringBootTest
public class LombokTest {
    @Test
    public void testNoArgsCOnstructor() {
        Board board = new Board();
        System.out.println(board);
        System.out.println(board.getTitle());
    }

    // @Test
    // public void testSetter() {
    // Board board = new Board("테스트내용");
    // System.out.println(board);
    // System.out.println(board.getTitle());
    // }

    @Test
    public void testGetter() {
        Board board = new Board();
        System.out.println(board.getTitle());
    }

    @Test
    public void testSetter() {
        Board board = new Board();
        board.setTitle("TITLE");
        System.out.println(board.getTitle());
    }
}

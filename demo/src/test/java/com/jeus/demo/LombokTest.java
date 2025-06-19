package com.jeus.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LombokTest {
    @Test
    public void testGetter() {
        Board board = new Board();
        System.out.println(board.toString());
    }
}

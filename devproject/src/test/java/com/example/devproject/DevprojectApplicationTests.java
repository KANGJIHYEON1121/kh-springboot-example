package com.example.devproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.domain.Board;

@SpringBootTest
class DevprojectApplicationTests {

	@Test
	void contextLoads() {
		Board board = new Board();
		System.out.println(board.toString());
	}

}

package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.Direction.*;
import static com.example.demo.PlayMaze.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Maze maze = new Maze("*******" + "*..*..*" + "*S**.**" + "*.....*" + "*****.*" + "*G....*" + "*******", 7);
		Piece piece = new Piece(maze);
		while (!piece.isAtGoal()) {
			piece.turnLeft();
			while (!piece.tryStepForward()) {
				piece.turnRight();
			}
		}
		List<Direction> actualHistory = piece.getHistory();
		for (int i = 1; i < actualHistory.size(); i++) {
			if (actualHistory.get(i - 1) == actualHistory.get(i).left().left()) {
				actualHistory.remove(i - 1);
				actualHistory.remove(i - 1);
				i = 1 < 2 ? 0 : i - 2;
			}
		}
		List<Direction> expectedHistory = new ArrayList<>(Arrays.asList(SOUTH,EAST, EAST, EAST, EAST, SOUTH, SOUTH, WEST, WEST, WEST, WEST));
		assertEquals(expectedHistory, actualHistory);

	}

}

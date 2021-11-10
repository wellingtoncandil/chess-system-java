package application;

import boardgame.Board;
import boardgame.Position;

public class Program {
	public static void main(String[] args) {
		System.out.println("Chess system starts");

		Position pos = new Position(1, 4);
		System.out.println(pos);
		Board board = new Board(8, 2);
		
	}
}

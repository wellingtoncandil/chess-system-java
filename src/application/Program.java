package application;

import java.util.Scanner;

import boardgame.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("Chess system starts");

		ChessMatch chessMatch = new ChessMatch();
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(tec);
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(tec);
				ChessPiece capturedChessPiece = chessMatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				tec.nextLine();
			}
			
		}
		
		
	}
}

package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		super();
		this.board = new Board(8, 8); // a classe chessMatch é a responsavel por saber a dimensão do tabuleiro
		// e inicia-lo da maneira correta
		initialSetup();
	}

	public Board getBoard() {
		return board;
	}
		
	public ChessPiece[][] getPieces(){ //retorna a matriz de peças da partida
		ChessPiece[][] mat = new ChessPiece[board.getRows()] [board.getColumns()];
	    for(int i=0; i<board.getRows(); i++) {
	    	for(int j=0; j<board.getColumns(); j++) {
	    		mat[i][j] = (ChessPiece) board.piece(i, j);
	    	}
	    }
	    return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(6, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(3, 1));
		board.placePiece(new King(board, Color.WHITE), new Position(3, 2));
	}
}

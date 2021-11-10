package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		super();
		this.board = new Board(8, 8); // a classe chessMatch é a responsavel por saber a dimensão do tabuleiro
		// e inicia-lo da maneira correta
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
}

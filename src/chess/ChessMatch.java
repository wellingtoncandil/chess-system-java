package chess;

import boardgame.Board;
import boardgame.ChessException;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece) capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if(!board.piece(position).isThereAnyPossibleMove()) {//se não houver nenhum movimento possivel
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(6, 1));
		board.placePiece(new King(board, Color.WHITE), new Position(3, 2));
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
        
	}
}

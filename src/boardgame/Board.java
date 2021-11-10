package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces; //matriz que receber� as pe�as da classe Piece
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there mus be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece (Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece (Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position "+ position);
		}
		pieces[position.getRow()][position.getColumn()]=piece;
		piece.position = position;
	}
	
	//testa se a posi��o no tabuleiro existe informando a linha e coluna
	private boolean positionExists(int row, int column) {
		return row >=0 && row < rows && column >=0 && column < columns;
	}
	
	// testa se a posi��o existe informando a posi��o
	public boolean positionExists(Position pos) {
		return positionExists(pos.getRow(), pos.getColumn());
	}
	
	public boolean thereIsAPiece(Position pos) {
		if(!positionExists(pos)) {
			throw new BoardException("Position not on the board");
		}
		return piece(pos) != null;//
	}
}

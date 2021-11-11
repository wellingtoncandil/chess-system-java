package boardgame;

public abstract class Piece {

	protected Position position; //protected pois apenas as classes da camada de tabuleiro (boardgame) poderão ver a posição da peça
	public Board board;
	
	public Piece(Board board) {// inicia a peça informando um tabuleiro
		this.board = board;
		position = null;
	}

	protected Board getBoard() { //somente classes do mesmo pacote e subclasses poderão acessar o tabuleiro de uma peça
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
    public boolean isThereAnyPossibleMove() {
    	boolean[][] mat = possibleMoves();
    	for(int i =0; i<mat.length; i++) {
    		for (int j=0; j<mat.length; j++) {
    			if (mat[i][j] == true) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}

package boardgame;

public abstract class Piece {

	protected Position position; //protected pois apenas as classes da camada de tabuleiro (boardgame) poder�o ver a posi��o da pe�a
	public Board board;
	
	public Piece(Board board) {// inicia a pe�a informando um tabuleiro
		this.board = board;
		position = null;
	}

	protected Board getBoard() { //somente classes do mesmo pacote e subclasses poder�o acessar o tabuleiro de uma pe�a
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

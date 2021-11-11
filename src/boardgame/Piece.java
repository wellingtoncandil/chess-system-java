package boardgame;

public class Piece {

	protected Position position; //protected pois apenas as classes da camada de tabuleiro (boardgame) poder�o ver a posi��o da pe�a
	public Board board;
	
	public Piece(Board board) {// inicia a pe�a informando um tabuleiro
		this.board = board;
		position = null;
	}

	protected Board getBoard() { //somente classes do mesmo pacote e subclasses poder�o acessar o tabuleiro de uma pe�a
		return board;
	}

}

package boardgame;

public class Piece {

	protected Position position; //protected pois apenas as classes da camada de tabuleiro (boardgame) poderão ver a posição da peça
	public Board board;
	
	public Piece(Board board) {// inicia a peça informando um tabuleiro
		this.board = board;
		position = null;
	}

	protected Board getBoard() { //somente classes do mesmo pacote e subclasses poderão acessar o tabuleiro de uma peça
		return board;
	}

}

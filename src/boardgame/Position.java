package boardgame;

public class Position { //classe responsavel por instanciar e informar
	//posi��o da pe�a no tabuleiro. Somente ser� acessada pela classe Piece

	private int row;
	private int column;
	
	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return row+", "+column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	
}

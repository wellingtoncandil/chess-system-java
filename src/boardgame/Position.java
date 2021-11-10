package boardgame;

public class Position {

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
}

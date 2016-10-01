
import java.lang.StringBuffer;

public class Board{
	Cell[][] board;
	int size;
	
	//generate a board with size n*n
	public Board(int n){
		this.size = n;
		board = new Cell[n][n];
		//assign id to each cell
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				int[] tempId = {i, j};
				board[i][j].setId(tempId);
			}
			
		}
	}
	
	public Cell getAt(int i, int j){
		//check for parameters
		//board[0..n-1][0..n-1]
		if (i >= size || j >= size){
			//System.out.println("Can't found cell at position ("+ i + ", "+ j+ ");");
			return new Cell();
		}		
		//if parameters are valid
		return board[i][j];
	}
	
	public boolean setObstacleAt(int i, int j){
		Cell target = getAt(i, j);
		if (target.getId()[0] == -1)
				return false;
		
		board[i][j].setObstacle(true);
		return true;
	}
	public boolean setDirt(int i, int j){
		Cell target = getAt(i, j);
		if (target.getId()[0] == -1)
				return false;
		
		board[i][j].setDirt(true);;
		return true;
	}
	
	
}






















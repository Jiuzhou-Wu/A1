
import java.lang.StringBuffer;

public class Board{
	private Cell[][] board;
	private int size;
	
	private Cell robot;
	private char robotDirection;
	
	private int[][] dirtPositions;
	private int[][] obstaclePositions;
	
	//Constructor **************************************************
	//generate a board with size*size
	public Board(int size, int robX, int robY, char direction){
		
		switch(direction){
		case 'w':
			break;
		case 'e':
			break;
		case 'n':
			break;
		case 's':
			break;
		default:
			System.out.println("Invalid direction to initialize the board");
			System.exit(-1);
		}
		robotDirection = direction;
		
		this.size = size;
		board = new Cell[size][size];
		//assign id to each cell
		for(int i = 0; i < this.size; i++){
			for(int j = 0; j < this.size; j++){
				//int[] tempId = {i, j};
				board[i][j] = new Cell();
				board[i][j].setId(i, j);
			}
		}
		robot = new Cell();
		robot.setId(robX, robY);
	}
	
	//Functions ******************************************************
	
	public int[][] getDirts(){
		return dirtPositions;
	}
	
	public int[][] getObstacles(){
		return obstaclePositions;
	}
	
	public int[] getRobotPosition(){
		return robot.getId();
	}
	
	public char getRobotDirection(){
		return this.robotDirection;
	}
	
	public Cell getAt(int i, int j){
		//check for parameters
		//board[0..n-1][0..n-1]
//		if (i >= size || j >= size){
//			//System.out.println("Can't found cell at position ("+ i + ", "+ j+ ");");
//			return new Cell();
//		}		
		//if parameters are valid
		return board[i][j];
	}

	public int moveTo(char action, char robDirection){
		//verify actions
		int numChangeDirection = 0;
		switch(action){
		case 'w'://to left
			if (robot.getId()[1] == 0)
				return 0;
			else{
				switch(robDirection){
				case 'w': numChangeDirection = 0;
				break;
				case 'e': numChangeDirection = 2;
				break;
				case 'n': numChangeDirection = 1;
				break;
				case 's': numChangeDirection = 1;
				break;
				default: return 0;
				}
				robot.setId(robot.getId()[0], robot.getId()[1]-1);
			}
			break;
		case 'e'://to right
			if (robot.getId()[1] == this.size-1)
				return 0;
			else{
				switch(robDirection){
				case 'w': numChangeDirection = 2;
				break;
				case 'e': numChangeDirection = 0;
				break;
				case 'n': numChangeDirection = 1;
				break;
				case 's': numChangeDirection = 1;
				break;
				default: return 0;
				}
				robot.setId(robot.getId()[0], robot.getId()[1]+1);
			}
			break;
		case 'n'://to upper
			if (robot.getId()[0] == 0)
				return 0;
			else{
				switch(robDirection){
				case 'w': numChangeDirection = 1;
				break;
				case 'e': numChangeDirection = 1;
				break;
				case 'n': numChangeDirection = 0;
				break;
				case 's': numChangeDirection = 2;
				break;
				default: return 0;
				}
				robot.setId(robot.getId()[0]-1, robot.getId()[1]);
			}
			break;
		case 's'://to lower
			if (robot.getId()[0] == this.size-1)
				return 0;
			else{
				switch(robDirection){
				case 'w': numChangeDirection = 1;
				break;
				case 'e': numChangeDirection = 1;
				break;
				case 'n': numChangeDirection = 2;
				break;
				case 's': numChangeDirection = 0;
				break;
				default: return 0;
				}
				robot.setId(robot.getId()[0]+1, robot.getId()[1]);
			}
			break;
		default: return 0;
		}
		
		//change direction cost 20 energy
		//move forward cost 50 energy
		return 50 + 20*numChangeDirection;
	}

	public int suck(){
		Cell robPosition = this.getAt(robot.getId()[0], robot.getId()[1]);
		if(robPosition.isDirt()){
			return 10;
		}else{
			return 0;
		}
	}
	
	public void randomSetDirt(int numOfDirt){
		this.dirtPositions = getRandomPosition(numOfDirt);
		for(int i = 0; i < numOfDirt; i++){
			setDirtAt(dirtPositions[i][0], dirtPositions[i][1]);
		}
	}
	public void randomSetObstacle(int numOfObstacle){
		this.obstaclePositions = getRandomPosition(numOfObstacle);
		for(int i = 0; i < numOfObstacle; i++){
			setObstacleAt(obstaclePositions[i][0], obstaclePositions[i][1]);
		}
	}
	public boolean setObstacleAt(int i, int j){
		Cell target = getAt(i, j);
		if (target.getId()[0] == -1)
				return false;
		
		board[i][j].setObstacle(true);
		return true;
	}
	public boolean setDirtAt(int i, int j){
		Cell target = getAt(i, j);
		if (target.getId()[0] == -1)
				return false;
		
		board[i][j].setDirt(true);;
		return true;
	}
	public int[][] getRandomPosition(int num){
		int[][] positions = new int[num][2];
		for(int i = 0; i < num; i++){
			//random generate a position, int[2], int[0] < size && int[1] < size
			
			int[] position = new int[2];
			
			position[0] = (int)(Math.random()*size);
			position[1] = (int)(Math.random()*size);
			//check for duplicate
			boolean duplicate = false;
			for(int j = 0; j < i; j++){
				if(positions[j][0] == position[0] && positions[j][1] == position[1]){
					i--;
					duplicate = true;
					break;
				}
			}
			if(duplicate){
				break;
			}else 
				if(this.getAt(position[0], position[1]).isDirt() 
					|| this.getAt(position[0], position[1]).isObstacle()
					|| (this.robot.getId()[0] == position[0] && this.robot.getId()[1] == position[1])){
				i--;
			}else{
				positions[i] = position;
			}
			
		}
		
		return positions;
	}
}























import java.lang.StringBuffer;
import java.util.Scanner;

public class Board{
	private Cell[][] board;
	private int size;
	
	private Cell robot;
	private char robotDirection;
	
	private int numOfDirt;
	private int numOfObstacle;
	private int[][] dirtPositions;
	private int[][] obstaclePositions;
	
	//Constructor **************************************************
	//generate a board with size*size
	public Board(int size, int robX, int robY, char direction){
		numOfDirt = 0;
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
	public int getNumOfDirt(){
		return this.numOfDirt;
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
		//if parameters are valid
		return board[i][j];
	}

	public int moveTo(char action){
		//verify actions
		int numChangeDirection = 0;
		switch(action){
		case 'w'://to left
			if (robot.getId()[1] == 0)
				return 0;
			else{
				switch(robotDirection){
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
				if(this.getAt(robot.getId()[0], robot.getId()[1]-1).isObstacle()){
					return 0;
				}
				robot.setId(robot.getId()[0], robot.getId()[1]-1);
			}
			break;
		case 'e'://to right
			if (robot.getId()[1] == this.size-1)
				return 0;
			else{
				switch(robotDirection){
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
				if(this.getAt(robot.getId()[0], robot.getId()[1]+1).isObstacle()){
					return 0;
				}
				robot.setId(robot.getId()[0], robot.getId()[1]+1);
			}
			break;
		case 'n'://to upper
			if (robot.getId()[0] == 0)
				return 0;
			else{
				switch(robotDirection){
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
				if(this.getAt(robot.getId()[0]-1, robot.getId()[1]).isObstacle()){
					return 0;
				}
				robot.setId(robot.getId()[0]-1, robot.getId()[1]);
			}
			break;
		case 's'://to lower
			if (robot.getId()[0] == this.size-1)
				return 0;
			else{
				switch(robotDirection){
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
				if(this.getAt(robot.getId()[0]+1, robot.getId()[1]).isObstacle()){
					return 0;
				}
				robot.setId(robot.getId()[0]+1, robot.getId()[1]);
			}
			break;
		default: return 0;
		}
		
		//change direction cost 20 energy
		//move forward cost 50 energy
		robotDirection = action;
		return 50 + 20*numChangeDirection;
	}

	public int suck(){
		Cell robPosition = this.getAt(robot.getId()[0], robot.getId()[1]);
		
		int index = 0;
		if(robPosition.isDirt()){
//			System.out.println("we are here");
			for(int i = 0; i < this.numOfDirt; i++){
				if(dirtPositions[i][0] == robPosition.getId()[0] && dirtPositions[i][1] == robPosition.getId()[1]){
					index = i;
					break;
				}
			}
			while(index<this.numOfDirt-1){
				dirtPositions[index] = dirtPositions[index+1];
				index++;
			}
			this.numOfDirt--;
			return 10;
		}else{
			return 0;
		}
	}
	
	public void randomSetDirt(int numOfDirt){
		if(this.numOfDirt == 0){
			this.numOfDirt = numOfDirt;
			this.dirtPositions = getRandomPosition(numOfDirt);
			for(int i = 0; i < this.numOfDirt; i++){
				this.setDirtAt(this.dirtPositions[i][0], this.dirtPositions[i][0]);
			}
		}else{
			int[][] newPositions = new int[this.numOfDirt+numOfDirt][2];
			for(int i = 0; i < this.numOfDirt; i++){
				newPositions[i] = this.dirtPositions[i];
			}
			int[][] tempPositions = getRandomPosition(numOfDirt);
			for(int i = this.numOfDirt; i < this.numOfDirt+numOfDirt; i++){
				newPositions[i] = tempPositions[i-this.numOfDirt];
				setDirtAt(tempPositions[i-this.numOfDirt][0], tempPositions[i-this.numOfDirt][1]);
			}
			
			this.dirtPositions = newPositions;
			
			this.numOfDirt += numOfDirt;
		}
		
	}
	public void randomSetObstacle(int numOfObstacle){
		
		if(this.numOfObstacle == 0){
			this.numOfObstacle = numOfObstacle;
			this.obstaclePositions = getRandomPosition(this.numOfObstacle);
			for(int i = 0; i < this.numOfObstacle; i++){
				this.setObstacleAt(this.obstaclePositions[i][0], this.obstaclePositions[i][1]);
			}
		}else{
			
			int[][] newPositions = new int[this.numOfObstacle+numOfObstacle][2];
			for(int i = 0; i < this.numOfObstacle; i++){
				newPositions[i] = this.obstaclePositions[i];
			}
			int[][] tempPositions = getRandomPosition(numOfObstacle);
			for(int i = this.numOfObstacle; i < this.numOfObstacle+numOfObstacle; i++){
				newPositions[i] = tempPositions[i-this.numOfObstacle];
				setObstacleAt(tempPositions[i-this.numOfObstacle][0], tempPositions[i-this.numOfObstacle][1]);
			}
			
			this.obstaclePositions = newPositions;
			
			this.numOfObstacle += numOfObstacle;
		}
	}
	/**
	 * helper function for randomSetObstacle(int)
	 * @param i, index for row
	 * @param j, index for col
	 * @return always returns true means set successfully 
	 */
	private boolean setObstacleAt(int i, int j){
		
		board[i][j].setObstacle(true);
		return true;
	}
	/**
	 * helper function for randomSetDirt(int)
	 * @param i, index for row
	 * @param j, index for col
	 * @return always returns true means set successfully 
	 */
	private boolean setDirtAt(int i, int j){
		Cell target = getAt(i, j);
		if (target.getId()[0] == -1)
				return false;
		
		board[i][j].setDirt(true);
		return true;
	}
	
	public boolean setDirt(int i, int j){
		
		for(int index = 0; index < this.numOfDirt; index++){
			if(this.dirtPositions[index][0] == getAt(i, j).getId()[0] && this.dirtPositions[index][1] == getAt(i, j).getId()[1]){
				System.out.println("Tried to add a dirt. This position already has a dirt. No new dirt added.");
				return false;
			}
			
		}
		for(int index = 0; index < this.numOfObstacle; index++){
			if(this.obstaclePositions[index][0] == getAt(i, j).getId()[0] && this.obstaclePositions[index][1] == getAt(i, j).getId()[1]){
				System.out.println("Tried to add a dirt. This position already has a obstacle. No new dirt added.");
				return false;
			}
			
		}
		
		
		
		int[] position = {i, j};
		board[i][j].setDirt(true);
		if(this.numOfDirt == 0){
			dirtPositions = new int[1][2];
			dirtPositions[0] = position;
			this.numOfDirt ++;
			return true;
		}
			
		int[][] newPositions = new int[++this.numOfDirt][2];
		
		newPositions[this.numOfDirt-1] = position; 
		
		for(int index = 0; index < this.numOfDirt-1; index++){
			newPositions[index] = this.dirtPositions[index];
		}
		this.dirtPositions = newPositions;
		
		//this.numOfDirt ++;
		
		return true;
	}
	
	public boolean setObstacle(int i, int j){
		
		for(int index = 0; index < this.numOfDirt; index++){
			if(this.dirtPositions[index][0] == getAt(i, j).getId()[0] && this.dirtPositions[index][1] == getAt(i, j).getId()[1]){
				System.out.println("Tried to add a obstacle. This position already has a dirt. No new obstacle added.");
				return false;
			}
			
		}
		
		
		for(int index = 0; index < this.numOfObstacle; index++){
			if(this.obstaclePositions[index][0] == getAt(i, j).getId()[0] && this.obstaclePositions[index][1] == getAt(i, j).getId()[1]){
				System.out.println("Tried to add a obstacle. This position already has a obstacle. No new obstacle added.");
				return false;
			}
			
		}
		
		int[] position = {i, j};
		
		if(this.robot.getId()[0] == position[0] && this.robot.getId()[1] == position[1]){
			System.out.println("Robot is on this position, please try some other cells. No new obstacle added.");
			return false;
		}
		
		board[i][j].setObstacle(true);
		if(this.numOfObstacle == 0){
			obstaclePositions = new int[1][2];
			obstaclePositions[0] = position;
			this.numOfObstacle ++;
			return true;
		}
			
		int[][] newPositions = new int[++this.numOfObstacle][2];
		
		newPositions[this.numOfObstacle-1] = position; 
		
		for(int index = 0; index < this.numOfObstacle-1; index++){
			newPositions[index] = this.obstaclePositions[index];
		}
		this.obstaclePositions = newPositions;
		
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
					duplicate = true;
					break;
				}
			}
			if(duplicate 
					|| this.getAt(position[0], position[1]).isDirt() 
					|| this.getAt(position[0], position[1]).isObstacle()
					|| (this.robot.getId()[0] == position[0] && this.robot.getId()[1] == position[1])){
				i--;
			}else{
				positions[i] = position;
			}
			
		}
		
		return positions;
	}

	public State children(State cur, char action ){
		
		//save board state as initialized
		int tempNumOfDirt = this.numOfDirt;
		
		int[] tempRobotPosition = new int[2];
		tempRobotPosition[0] = this.robot.getId()[0]; 
		tempRobotPosition[1] = this.robot.getId()[1];		
		
		char tempDirection = this.robotDirection;
		
		int[][] tempDirtPositions = new int[this.dirtPositions.length][2];
		for(int i = 0; i < this.dirtPositions.length; i++){
			tempDirtPositions[i][0] = this.dirtPositions[i][0];
			tempDirtPositions[i][1] = this.dirtPositions[i][1];
		}
		
		//put cur state on the board
		this.numOfDirt = cur.getNumDirt();
		this.robot.setId(cur.getRobot()[0], cur.getRobot()[1]);
		this.robotDirection = cur.getRobotDir();
		this.dirtPositions = new int[numOfDirt][2];
		
		for(int i = 0; i < this.dirtPositions.length; i++){
			this.dirtPositions[i][0] = cur.getDirtPos()[i][0];
			this.dirtPositions[i][1] = cur.getDirtPos()[i][1];
		}
		
		int cost = moveTo(action);
		//boolean valid = true;
		if(cost == 0){
			this.numOfDirt = tempNumOfDirt;
			this.robot.setId(tempRobotPosition[0], tempRobotPosition[1]);
			this.robotDirection = tempDirection;
			this.dirtPositions = tempDirtPositions;
			return null;
		}
			
		//check for dirt
			cost += suck();
		State childState = new State(cur, this.numOfDirt, this.dirtPositions, cur.getEnergyCost()+cost, this.robot.getId(), this.robotDirection);
		
		this.numOfDirt = tempNumOfDirt;
		this.robot.setId(tempRobotPosition[0], tempRobotPosition[1]);
		this.robotDirection = tempDirection;
		this.dirtPositions = tempDirtPositions;
		//
			return childState;
	}
	
	public int getSize(){
		return this.size;
	}
}























public class State {
	int numDirt;
	int energyCost; 
	int[] robot = new int[2];
	char robDirection;	
	//save the coming position(for each position can have 'w,e,n,s')
	char moveInDirection;
	
	public State(int numDirt, int energyCost, Cell robot, char robDirection, char moveInDirection){
		this.numDirt = numDirt;
		this.energyCost = energyCost;
		this.robot[0] = robot.getId()[0];
		this.robot[1] = robot.getId()[1];
		this.robDirection = robDirection;
		this.moveInDirection = moveInDirection;
	}
	
	//getters
	public int getNumDirt(){
		return numDirt;
	}
	public int getEnergyCost(){
		return energyCost;
	}
	public int[] getRobot(){
		return robot;
	}
	public char getRobotDir(){
		return robDirection;
	}
	public char getMoveInDir(){
		return moveInDirection;
	}
	//setters
	public void setNumDirt(int num){
		this.numDirt = num;
	}
	public void setEnergyCost(int cost){
		this.energyCost = cost;
	}
	public void setRobot(Cell robot, char direction){
		this.robot[0] = robot.getId()[0];
		this.robot[1] = robot.getId()[1];
		this.robDirection = direction;
	}
	public void setMoveIn(char moveIn){
		this.moveInDirection = moveIn;
	}
}

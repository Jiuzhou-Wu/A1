
public class State {
	int numDirt;
	int energyCost; 
	Cell robot;
	char robDirection;	
	//save the coming position(for each position can have 'w,e,n,s')
	char moveInDirection;
	
	public State(int numDirt, int energyCost, Cell robot, char robDirection, char moveInDirection){
		this.numDirt = numDirt;
		this.energyCost = energyCost;
		this.robot = robot;
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
	public Cell getRobot(){
		return robot;
	}
	public char getRobotDir(){
		return robDirection;
	}
	public char getMoveInDir(){
		return moveInDirection;
	}
}

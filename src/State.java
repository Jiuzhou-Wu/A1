
public class State {
	int numDirt;
	int energyCost; 
	int[] robot = new int[2];
	char robDirection;	
	//save the coming position(for each position can have 'w,e,n,s')
	char moveInDirection;
	
	public State(int numDirt, int energyCost, int[] robot, char robDirection, char moveInDirection){
		this.numDirt = numDirt;
		this.energyCost = energyCost;
		this.robot[0] = robot[0];
		this.robot[1] = robot[1];
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
	
	//Comparison
	public boolean isTheSame(State other){
		boolean flag = true;
		if(this.numDirt != other.getNumDirt()){
			flag = false;
		}
		if(this.energyCost != other.getEnergyCost()){
			flag = false;
		}
		if(this.robot[0] != other.getRobot()[0] || this.robot[1] != other.getRobot()[1]){
			flag = false;
		}
		if(this.robDirection != other.getRobotDir()){
			flag = false;
		}
		if(this.moveInDirection != other.getMoveInDir()){
			flag = false;
		}
		return flag;
	}
}


public class State {
	State pre;
	int numDirt;
	int energyCost; 
	int[] robot = new int[2];
	int[][] dirtPos;
	char robDirection;	

	
	public State(State pre,int numDirt, int[][] dirtPos, int energyCost, int[] robot, char robDirection){
		this.pre = pre;
		this.numDirt = numDirt;
		this.dirtPos = new int[this.numDirt][2];
		for(int i=0;i<numDirt;i++){
			this.dirtPos[i][0] = dirtPos[i][0];
			this.dirtPos[i][1] = dirtPos[i][1];
		}
		this.energyCost = energyCost;
		this.robot[0] = robot[0];
		this.robot[1] = robot[1];
		this.robDirection = robDirection;
	}
	
	//getters
	public State getPre(){
		return pre;
	}
	public int getNumDirt(){
		return numDirt;
	}
	public int[][] getDirtPos(){
		return dirtPos;
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

	//setters
	public void setPre(State pre){
		this.pre = pre;
	}
	public void setDirtPos(int[][] pos){
		for(int i=0; i<pos.length;i++){
			this.dirtPos[i][0]= pos[i][0];
			this.dirtPos[i][1]= pos[i][1];
		}
	}
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

	
	//Comparison
	public boolean isTheSame(State other){
		boolean flag = true;
		if(pre !=null && other.getPre() != null){
			if(this.pre.getRobot()[0] != other.pre.getRobot()[0] ||this.pre.getRobot()[1] != other.pre.getRobot()[1]){
				flag = false;
			}
		}
		else if(pre==null && other.getPre()==null){	
		}
		else{
			flag = false;
		}
		if(this.robot[0] != other.getRobot()[0] || this.robot[1] != other.getRobot()[1]){
			flag = false;
		}
		if(this.robDirection != other.getRobotDir()){
			flag = false;
		}
		if(this.numDirt != other.getNumDirt()){
			flag = false;
		}
		else{
			for(int i=0;i<this.numDirt;i++){
				if(this.dirtPos[i][0] != other.getDirtPos()[i][0] || this.dirtPos[i][1] != other.getDirtPos()[i][1]){
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer();
		s=s.append("Num of dirs: ");
		s=s.append(getNumDirt());
		s=s.append(" Energy cost: ");
		s=s.append(getEnergyCost());
		s=s.append(" Pos(");
		s=s.append(getRobot()[0]);
		s=s.append(getRobot()[1]);
		s=s.append(") Direction: ");
		s=s.append(getRobotDir());
		s=s.append("\n");
		return s.toString();
	}
}

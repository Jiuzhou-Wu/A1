
public class RobotApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I am a Robot");
		
		//take user's input for gird size
		
		//take user's input for number of dirt
			//cant be greater than gird size
		
		//take user's input for obstacle
			//cant be greater than gird size
		
		//generator
		//
		int boradSize = 10;
		int robotInitializeX = 0;
		int robotInitializeY = 0;
		char robotInitializeDirection = 'w';
	
		Board boardTest = new Board(boradSize, robotInitializeX, robotInitializeY, robotInitializeDirection);
		boardTest.randomSetDirt(3);
		boardTest.randomSetObstacle(5);
		///*
		int[][] dirtPositions = boardTest.getDirts();
		int[][] obstaclePositions = boardTest.getObstacles();
		for(int i = 0; i < dirtPositions.length; i++){
			
			System.out.print("dirt at: ");
			System.out.println(dirtPositions[i][0] + " " + dirtPositions[i][1]);
		}
		for(int i = 0; i < obstaclePositions.length; i++){
			System.out.print("obstacle at: ");
			System.out.println(obstaclePositions[i][0] + " " + obstaclePositions[i][1]);
		}
		//*/
	//search
		
	//print 
		
	
		//state: (# of dirt, robotPosition) 
		//solution: path of states
		
		
		/* moveTo test case
		Board robotTest = new Board(boradSize, robotInitializeX, robotInitializeY, robotInitializeDirection);
		int[] robotPosition = new int[2];
	
		robotPosition = robotTest.getRobotPosition();
		System.out.println(robotPosition[0]+" "+ robotPosition[1]);
	
		robotTest.moveTo('w', robotTest.getRobotDirection());
	//
		
		robotPosition = robotTest.getRobotPosition();
		System.out.println(robotPosition[0]+" "+ robotPosition[1]);
	
		int energyCost = 0;
		energyCost = robotTest.moveTo('w', robotTest.getRobotDirection());
		if(energyCost == 0){
			System.out.println("Invalid move");
		}
		else{
			System.out.println(robotPosition[0]+" "+ robotPosition[1]);
		}
	
		System.out.println(robotPosition[0]+" "+ robotPosition[1]);
		//*/
	}
	
}

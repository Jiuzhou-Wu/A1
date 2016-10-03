
public class RobotApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I am a Robot");
		
		//take user's input for gird size
		//take user's input for number of dirt
		//take user's input for obstacle
		//generator
		//
		int boradSize = 3;
		int robotInitializeX = 1;
		int robotInitializeY = 1;
		char robotInitializeDirection = 'w';
		
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
	//search
		
	//print 
		
	
		//state: (# of dirt, robotPosition) 
		//solution: path of states
		
	}
	
}


//this is used to for open list or close list
public class DoublyLinkedList {
	
	private static class StateNode{
		int numDirt;
		int energyCost;
		Cell robot;
		char robDirection;
		
		StateNode previous;
		StateNode next;
		
		//used for initial the first state in open list
		StateNode(int _numDirt, Cell _robot, char _robDirection){
			/*
			 * we may need check for robDirection
			 */
			numDirt = _numDirt;
			robot = _robot;
			robDirection = _robDirection;
		}
		//used for generate a normal state
		StateNode(int numDirt, int energyCost, Cell robot, char robDirection){
			this.numDirt = numDirt;
			this.energyCost = energyCost;
			this.robot = robot;
			this.robDirection = robDirection;
		}
	}
	
	StateNode front;
	StateNode end;
	
	int length;
	
	
}












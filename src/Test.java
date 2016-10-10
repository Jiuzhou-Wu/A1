
public class Test {

	public static void main(String[] args) {
		//generate board
		int boradSize = 10;
		int robotInitializeX = 0;
		int robotInitializeY = 0;
		char robotInitializeDirection = 'w';
	
		Board boardTest = new Board(boradSize, robotInitializeX, robotInitializeY, robotInitializeDirection);
		
		boardTest.setDirt(0, 0);		
		boardTest.randomSetDirt(3);
		boardTest.randomSetObstacle(5);
		
		//search
		//DFS
		State solution = DFS(boardTest);			
		
//		// TODO Auto-generated method stub
//		DoublyLinkedList l= new DoublyLinkedList();
//		int[] pos = {1,1};
//		int[][] dirtPos = {{1,2},{2,3},{2,2}};
//		State s1 = new State(null, 3,dirtPos, 0, pos,'w');
//		pos[1] = 2;
//		Cell robot2 = new Cell(false,false,pos);
//		State s2 = new State(null, 2,dirtPos, 10, pos,'n');
//		pos[0] = 2;
//		Cell robot3 = new Cell(false,false,pos);
//		State s3 = new State(null, 0,dirtPos, 30, pos,'e');
//		
//		l.addFirst(s1);
//		l.addLast(s2);
//		l.addLast(s3);
//		
//		System.out.println(l.onList(new State(null, 3,dirtPos, 0, pos,'s')));
		
	}

	public static State DFS(Board board){
		Stack open = new Stack();
		Stack closed = new Stack();
		State initial = new State(null,board.numOfDirt, board.getDirts(), 0, board.getRobotPosition(), board.getRobotDirection());
		open.addLast(initial);
		while(!open.isEmpty()){
			State temp = open.pop();
			if(temp.getNumDirt()==0){
				return temp;
			}
			else{
				State child1 = children(temp,'w');
				State child2 = children(temp,'e');
				State child3 = children(temp,'n');
				State child4 = children(temp,'s');
				closed.push(temp);
				if(child1 != null && !open.onList(child1) && !closed.onList(child1)){
					open.push(child1);
				}
				if(child2 != null && !open.onList(child2) && !closed.onList(child2)){
					open.push(child2);
				}
				if(child3 != null && !open.onList(child3) && !closed.onList(child3)){
					open.push(child3);
				}
				if(child4 != null && !open.onList(child4) && !closed.onList(child4)){
					open.push(child4);
				}
			}
		}
		return null;
	}

}

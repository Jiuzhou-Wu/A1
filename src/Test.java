
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
		
		// TODO Auto-generated method stub
		DoublyLinkedList l= new DoublyLinkedList();
		int[] pos = {1,1};

		State s1 = new State(3,0, pos,'w','e');
		pos[1] = 2;
		Cell robot2 = new Cell(false,false,pos);
		State s2 = new State(2,10, pos,'n','s');
		pos[0] = 2;
		Cell robot3 = new Cell(false,false,pos);
		State s3 = new State(0,30, pos,'e','n');
		
		l.addFirst(s1);
		l.addLast(s2);
		l.addLast(s3);
		
		System.out.println(l.toString());
		
	}

}

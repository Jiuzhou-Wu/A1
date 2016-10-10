
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList l= new DoublyLinkedList();
		int[] pos = {1,1};
		System.out.println(pos[0]);
		Cell robot1 = new Cell(false,false,pos);
		State s1 = new State(3,0, robot1,'w','e');
		pos[1] = 2;
		Cell robot2 = new Cell(false,false,pos);
		State s2 = new State(2,10, robot1,'w','e');
		pos[0] = 2;
		Cell robot3 = new Cell(false,false,pos);
		State s3 = new State(0,30, robot1,'w','e');
		
		l.addFirst(s1);
		l.addLast(s2);
		l.addLast(s3);
		
		
		
	}

}

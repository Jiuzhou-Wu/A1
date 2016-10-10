
public class Queue extends DoublyLinkedList{
	Queue(){
		super();
	}
	public State dequeue(){
		return super.removeFirst();
	}
	
	public void enqueue(State cur){
		super.addLast(cur);
	}
	public State first(){
		return super.getHeader();
	}
}

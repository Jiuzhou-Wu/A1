
public class Stack extends DoublyLinkedList{
	Stack(){
		super();
	}
	
	public void push(State cur){
		super.addLast(cur);
	}
	
	public State top(){
		return super.getTail();
	}
	
	public State pop(){
		return super.removeLast();
	}
}

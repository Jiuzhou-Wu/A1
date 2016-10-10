
//this is used to for open list or close list
public class DoublyLinkedList {
	
	private static class StateNode{
		//make a double linked list
		State ele;
		StateNode previous;
		StateNode next;
		
		//Constructor
		public StateNode(State current, StateNode pre, StateNode next){
			this.ele = current;
			this.next = next;
			this.previous = pre;
		}
		//getters 
		public State getCur(){
			return ele;
		}
		public StateNode getPreNode(){
			return previous;
		}
		public StateNode getNextNode(){
			return next;
		}
		
		//setters
		public void setCur(State cur){
			this.ele = cur;
		}
		public void setPre(StateNode pre){
			this.previous = pre;
		}
		public void setNext(StateNode next){
			this.next = next;
		}
	}
	//End of the nested StateNode Class
	
	StateNode header;
	StateNode tail;
	int size = 0;
	
	//Constructor
	public DoublyLinkedList(){
		header = new StateNode(null, null, null);      // create header
	    tail = new StateNode(null, header, null);   // trailer is preceded by header
	    header.setNext(tail); 
	}
	
	//getters
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public State getHeader(){
		if(isEmpty()){
			return null;
		}
		else{
			return header.getNextNode().getCur();
		}
	}
	
	public State getTail(){
		if(isEmpty()){
			return null;
		}
		else{
			return tail.getPreNode().getCur();
		}
	}
	
	//setters
	//adding nodes
	public void addBetween(State cur, StateNode pre, StateNode next){
		StateNode newState = new StateNode(cur,pre,next);
		pre.setNext(newState);
		next.setPre(newState);
		size++;
	}
	
	public void addLast(State cur){
		addBetween(cur, this.tail.getPreNode(), this.tail);
	}
	
	public void addFirst(State cur){
		addBetween(cur, this.header, this.header.getNextNode());
	}
	//removing nodes
	public State remove(StateNode cur){		
		cur.getPreNode().setNext(cur.getNextNode());
		cur.getNextNode().setPre(cur.getPreNode());
		size--;
		return cur.getCur();
	}
	
	public State removeFirst(){
		if(isEmpty()){
			return null;
		}
		else{
			return remove(this.header.getNextNode());
		}
	}
	
	public State removeLast(){
		if(isEmpty()){
			return null;
		}
		else{
			return remove(this.tail.getPreNode());
		}
	}
	
	//Comparison
	public boolean onList(State other){
		if(isEmpty()){
			return false;
		}
		else{
			boolean flag = false;
			StateNode temp = header;
			while(temp.getNextNode()!=tail){
				temp = temp.getNextNode();
				if(temp.getCur().isTheSame(other)){
					flag = true;
					break;
				}
			}
			return flag;
		}
	}	
	
	public String toString(){
		if(isEmpty()){
			return "";
		}
		else{
			StringBuffer s = new StringBuffer();
			StateNode temp = header;
			while(temp.getNextNode()!=tail){
				temp = temp.getNextNode();
				s=s.append("Num of dirs: ");
				s=s.append(temp.getCur().getNumDirt());
				s=s.append(" Energy cost: ");
				s=s.append(temp.getCur().getEnergyCost());
				s=s.append(" Pos(");
				s=s.append(temp.getCur().getRobot()[0]);
				s=s.append(temp.getCur().getRobot()[1]);
				s=s.append(") Direction: ");
				s=s.append(temp.getCur().getRobotDir());
				s=s.append("\n");
			}		
			return s.toString();
		}
	}
}












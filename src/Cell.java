import java.lang.StringBuffer;

public class Cell {
	private boolean isObstacle;
	private boolean hasDirt;
	private int[] id;
	
	public Cell(){
		id = new int[2];
		id[0] = -1;
		id[1] = -1;
		isObstacle = false;
		hasDirt = false;
	}
	
	//we should never use this constructor 
	public Cell(boolean ob, boolean dirt){
		this.setObstacle(ob);
		this.setDirt(hasDirt);
	}
	
	public int[] getId(){
		return id;
	}
	
	public void setId(int x, int y){
		id[0] = x;
		id[1] = y;
		return;
	}
	public boolean isDirt() {
		return hasDirt;
	}

	public void setDirt(boolean hasDirt) {
		this.hasDirt = hasDirt;
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}
	
//	public String toString(){
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("+-+\n");
//		buffer.append("+");
//		if (isObstacle){
//			buffer.append("*");
//		} else {
//			buffer.append(" ");
//		}
//		buffer.append("+\n");
//		buffer.append("+-+");
//		
//		return buffer.toString();
//	}
	
	
}

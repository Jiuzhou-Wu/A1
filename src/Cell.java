
public class Cell {
	private boolean obstacle;
	private boolean dirt;
	
	public Cell(){
		obstacle = false;
		dirt = false;
	}
	
	public Cell(boolean ob, boolean dirt){
		this.setObstacle(ob);
		this.setDirt(dirt);
	}
	
	public boolean isDirt() {
		return dirt;
	}

	public void setDirt(boolean dirt) {
		this.dirt = dirt;
	}

	public boolean isObstacle() {
		return obstacle;
	}

	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
	}
	
}

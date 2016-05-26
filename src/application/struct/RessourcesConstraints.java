package application.struct;

public class RessourcesConstraints {
	
	int tableId;
	int capacity;
	@Override
	public String toString() {
		return "tableId=" + tableId + ",capacity=" + capacity + ",matchfield=" + matchfield
				;
	}
	public RessourcesConstraints() {
		super();
	}
	String matchfield;
	public RessourcesConstraints(int tableId, int capacity, String matchfield) {
		super();
		this.tableId = tableId;
		this.capacity = capacity;
		this.matchfield = matchfield;
	}
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getMatchfield() {
		return matchfield;
	}
	public void setMatchfield(String matchfield) {
		this.matchfield = matchfield;
	}
	

}

package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface {
	private Hashtable<VertexInterface,Double> hashTable;
	
	public Pi() {
		this.hashTable = new Hashtable<VertexInterface,Double>();
	}

	@Override
	public void setPi(VertexInterface v, double Pi) {
		hashTable.put(v, Pi);
	}

	@Override
	public double getPi(VertexInterface v) {
		return hashTable.get(v);
	}
	
	
}

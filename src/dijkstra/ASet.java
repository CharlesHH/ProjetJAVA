package dijkstra;

import java.util.HashSet;

public class ASet implements ASetInterface {
	private HashSet<VertexInterface> hashSet;
	
	public ASet() {
		this.hashSet = new HashSet<VertexInterface>();
	}

	@Override
	public boolean isInA(VertexInterface v) {
		return hashSet.contains(v);
	}

	@Override
	public void add(VertexInterface v) {
		hashSet.add(v);
	}

}

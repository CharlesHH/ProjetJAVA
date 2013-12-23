package dijkstra;

public interface ASetInterface {
	//Check if a vertex is in A
	public boolean isInA(VertexInterface v);
	
	//add a vertex to A
	public void add(VertexInterface v);
}

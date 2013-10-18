import java.util.ArrayList;
public interface GraphInterface {
	//Return the length of the arch between two vertices. Infinity if there is none direct.
	public double p(VertexInterface v1,VertexInterface v2);
	
	//Return a list of all vertices
	public ArrayList<VertexInterface> getAllVertices() ;
	
	//Return all the successors of a Vertex
	public ArrayList<VertexInterface> getSuccessors(VertexInterface v) ;
}

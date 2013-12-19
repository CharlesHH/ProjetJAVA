package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	//Set the father of a vertex
	public void setPrevious(VertexInterface v,VertexInterface father);
	
	//Return the father of a vertex
	public VertexInterface getPrevious(VertexInterface v);
	
	//Return a list of vertices constituting the shortest path to the vertex v
	public ArrayList<VertexInterface> shortPath(VertexInterface v);
}

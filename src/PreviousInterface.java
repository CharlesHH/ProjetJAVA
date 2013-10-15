
public interface PreviousInterface {
	//Set the father of a vertex
	public void setPrevious(VertexInterface v,VertexInterface father);
	
	//Return the father of a vertex
	public VertexInterface getPrevious(VertexInterface v);
}

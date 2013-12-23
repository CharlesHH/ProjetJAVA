package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous implements PreviousInterface {
	private Hashtable<VertexInterface,VertexInterface> hashTable;
	
	public Previous() {
		this.hashTable = new Hashtable<VertexInterface,VertexInterface>();
	}

	@Override
	public void setPrevious(VertexInterface v, VertexInterface father) {
		hashTable.put(v,father);
	}

	@Override
	public VertexInterface getPrevious(VertexInterface v) {
		return hashTable.get(v);
	}

	@Override
	public ArrayList<VertexInterface> shortPath(VertexInterface v) {  //le sommet racine n'est pas ajouté à la liste, mais v si
		ArrayList<VertexInterface> list = new ArrayList<VertexInterface>();
		VertexInterface current = v;
		
		while(hashTable.containsKey(current)){
			list.add(current);
			current = hashTable.get(current);
		}
		return list;
	}

}

package dijkstra;
import java.util.ArrayList;


public class Dijkstra {
	private PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		a.Add(r);
		VertexInterface pivot;
		pivot = r;
		pi.setPi(r,0.0);
		
		ArrayList<VertexInterface> VerticesList = g.getAllVertices();
		for(VertexInterface ver : VerticesList){
			if (ver != r) pi.setPi(ver,Double.POSITIVE_INFINITY);
		}
		
		int VLsize = VerticesList.size();
		for(int j=1; j < VLsize ; j++){
			
			ArrayList<VertexInterface> SuccessorsList = g.getSuccessors(pivot);
			for(VertexInterface y : SuccessorsList){
				if (a.IsInA(y)==false) {
					if ( pi.getPi(pivot) + g.p(pivot, y)<pi.getPi(y) ) {
						pi.setPi(y, pi.getPi(pivot) + g.p(pivot, y));
						previous.setPrevious(y, pivot);
					}
				}
			}
			
			double PiTest = Double.POSITIVE_INFINITY;
			VertexInterface VertexTest = null;
			for(VertexInterface y : VerticesList){
				if (a.IsInA(y)==false) {
					if (PiTest >= pi.getPi(y)) {
						VertexTest = y;
						PiTest = pi.getPi(y);
					}
				}
			}
			pivot = VertexTest;
			a.Add(pivot);
		}
		
		return previous;
	}
	
}

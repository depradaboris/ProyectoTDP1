package TDAGrafo;

public class testing {

	public static void main(String[] args) {
		
		GrafoDirigido grafo=new GrafoDirigido();
		grafo.addNode(1);
		
		grafo.addNode(2);
		grafo.addEdge(1,2);
		
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addEdge(3,4);
		grafo.addNode(5);
		grafo.addNode(6);
		grafo.addEdge(5,6);
		grafo.removeNode(5);
		grafo.addNode(3);
		
	}

}

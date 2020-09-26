package TDAGrafo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;

public class GrafoDirigido {
	private List<Integer> Vertices;
	private List<Arco<Integer,Integer>> listArcos;
	private static Logger logger;
	
	public GrafoDirigido() {
		Vertices=new LinkedList<Integer>();
		listArcos=new LinkedList<Arco<Integer,Integer>>();

		if(logger==null) {
			logger=Logger.getLogger(GrafoDirigido.class.getName());
			Handler hdn=new ConsoleHandler();
			hdn.setLevel(Level.FINE);
			logger.addHandler(hdn);
			logger.setLevel(Level.FINE);

			Logger rootLogger=logger.getParent();

			for(Handler h: rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}

		}
	}

	/*addNode(int node): void. Agrega el nodo “node” al 
	 * grafo, si aún no pertenecía a la
		estructura.*/
	public void addNode(int node){
		if(!Vertices.contains(node)) {
			Vertices.add(node);
			logger.info("Nodo"+node+"se agrego a la lista de vertices");
		}else {
			logger.warning("El nodo"+node+"ya se encuentra en la lista de vertices");
		}

	}

	/*addEdge(int node1, int node2):void. agrega un arco entre el nodo “node1” y el nodo
	“node2”, si aún no existía el arco y ambos parámetros son nodos pertenecientes a la
	estructura.*/

	public void addEdge(int node1, int node2) {
		if(Vertices.contains(node1)&&Vertices.contains(node2)) {
			Arco<Integer,Integer> arco;
			boolean encontro=false;
			for(int i=0;i<listArcos.size() && !encontro;i++) {
				arco=listArcos.get(i);
				if((arco.getAnterior()==node1)&&(arco.getSiguiente()==node2)) {
					encontro=true;
				}
			}
			if(!encontro) {
				arco=new Arco<Integer,Integer>(node1,node2);
				listArcos.add(arco);
				logger.info("El arco se ingreso correctamente");
			}else {
				logger.warning("Ya existe un arco entre los vertices");
			}
		}else{
			logger.warning("No existen alguno de los vertices ingresados");
		}
	}
	/*
	 removeNode(int node):void. remueve el nodo “node” del grafo, si el parámetro es un
	nodo de la estructura
	 * */
	public void remove(int node) {
		boolean encontro=false;
		for(int i=0;i<Vertices.size() && !encontro; i++) {
			if(Vertices.get(i)==node) {
				Vertices.remove(i);
				encontro=true;
			}
		}
		Iterator<Arco<Integer,Integer>> it=listArcos.iterator();
		Arco<Integer,Integer> cursor;
		while(it.hasNext()) {
			cursor=it.next();
			if(cursor.getAnterior()==node || cursor.getSiguiente()==node) {
				listArcos.remove(cursor);
			}
		}
		if(encontro) {
			logger.info("El vertice y sus arcos se han eliminado correctamente");
		}else {
			logger.warning("El vertice que desea eliminar no existe");
		}
	}
	/* remueve el arco entre el nodo “node1” y el
		nodo “node2”, si el arco formado por los parámetros pertenecen a la estructura.
	 */
	public void removeEdge(int node1,int node2) {
		boolean encontre=false;
		Iterator<Arco<Integer,Integer>> it=listArcos.iterator();
		Arco<Integer,Integer> cursor;
		while(it.hasNext()) {
			cursor=it.next();
			if(cursor.getAnterior()==node1 && cursor.getSiguiente()==node2) {
				listArcos.remove(cursor);
				encontre=true;
			}
		}
		if(encontre) {
			logger.info("El arco entre los vertices se ha eliminado correctamente");
		}else {
			logger.warning("El arco que usted desea eliminar no existe");
		}
	}
}



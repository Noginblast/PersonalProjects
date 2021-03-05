
public class Dijk {
	String src = "";
	String dst = "";
	HashTable ht = new HashTable();
	int airptAmnt;
	
	public Dijk (HashTable ht, int airptAmnt) {
		this.ht = ht;
		this.airptAmnt = airptAmnt;
	}
	
	public void dijkstra(String src, String dst) {
		this.src = src;
		this.dst = dst;
		
		
		Heap hp = new Heap(airptAmnt);
		
		hp.insert(ht.getItem(src, dest, timeDep));
		
	}
	

}

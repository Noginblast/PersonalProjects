
import java.util.LinkedList;
 
public class HashTable {
	

	public static class HTObject {
		public String src;
        public String dest;
        public int timeDep;
        public int timeArr;
        public int heapIndex;
        
    }
 
    public static final int ARR_SIZE = 1000;
    private LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];
 
    public HashTable() {
        for(int i=0; i<ARR_SIZE; i++) {
            arr[i] = null;
        }
    }
    
    private int myHash(String src) {
    	char[] c = new char[src.length()];
    	
    	for(int i = 0; i < src.length(); i++) {
    		c[i] = (char) src.charAt(i);
    	}
    	
    	int p0 = (int) c[0] - 'A' +1;
    	int p1 = (int) c[1] - 'A' +1;
    	int p2 = (int) c[2] - 'A' +1;
    	
    	int p3 = p0*467*467 + p1*467 + p2;
    	int p4 = p3 % 7193;
    	
    	return p4;
    }
 
    private HTObject getObj(String src, String dest, int timeDep) {
        if(src == null)
            return null;
 
        int index = myHash(src) % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null)
            return null;
 
        for(HTObject item : items) {
            if(item.src.equals(src) && item.dest.equals(dest) && (item.timeDep == timeDep))
                return item;
        }
 
        return null;
    }
    
    private HTObject getObjPos(String src) {
        if(src == null)
            return null;
 
        int index = myHash(src) % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null)
            return null;
 
        for(HTObject item : items) {
            if(item.src.equals(src))
                return item;
        }
 
        return null;
    }
    
    public int getArr(String src, String dest, int timeDep) {
        HTObject item = getObj(src, dest, timeDep);
 
        if(item == null)
            return -1;
        else
            return
            item.timeArr;
    }
    
    public int getDep(String src, String dest, int timeDep) {
        HTObject item = getObj(src, dest, timeDep);
 
        if(item == null)
            return -1;
        else
            return
            item.timeDep;
    }
    
    public int getPos(String src) {
        HTObject item = getObjPos(src);
 
        if(item == null)
            return -1;
        else
            return
            item.heapIndex;
    }
    
    
    public HashTable.HTObject getItem(String src, String dest, int timeDep) {
        HTObject item = getObj(src, dest, timeDep);
 
        if(item == null)
            return null;
        else
            return
            item;
    }
 
    public void put(String src, String dest, int timeDep, int timeArr) {
        int index = myHash(src) % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null) {
            items = new LinkedList<HTObject>();
 
            HTObject item = new HTObject();
            item.src = src;
            item.dest = dest;
            item.timeDep = timeDep;
            item.timeArr = timeArr;
 
            items.add(item);
 
            arr[index] = items;
        }
        else {
            for(HTObject item : items) {
                if(item.src.equals(src) && item.dest.equals(dest) && (item.timeDep == timeDep)) {
                    item.dest = dest;
                    item.timeDep = timeDep;
                    item.timeArr = timeArr;
                    return;
                }
            }
 
            HTObject item = new HTObject();
            item.src = src;
            item.dest = dest;
            item.timeDep = timeDep;
            item.timeArr = timeArr;
 
            items.add(item);
        }
    }
  
    public void putPos(String src, int heapIndex) {
        int index = myHash(src) % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null) {
            items = new LinkedList<HTObject>();
 
            HTObject item = new HTObject();
            item.src = src;
            item.heapIndex = heapIndex;
 
            items.add(item);
 
            arr[index] = items;
        }
        else {
            for(HTObject item : items) {
                if(item.src.equals(src)) {
                	item.heapIndex = heapIndex;
                    return;
                }
            }
 
            HTObject item = new HTObject();
            item.src = src;
            item.heapIndex = heapIndex;
 
            items.add(item);
        }
    }
 
    public void delete(String src, String dest, int timeDep) {
        int index = myHash(src) % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
 
        if(items == null)
            return;
 
        for(HTObject item : items) {
            if (item.src.equals(src) && item.dest.equals(dest) && (item.timeDep == timeDep)) {
                items.remove(item);
                return;
            }
        }
    }
    
    
    public static HashTable.HTObject inf() {
    	HTObject item = new HTObject();
        item.src = "NaN";
        item.dest = "NaN";
        item.timeDep = Integer.MAX_VALUE;
        item.timeArr = Integer.MAX_VALUE;
        
        return item;
    }
 
}
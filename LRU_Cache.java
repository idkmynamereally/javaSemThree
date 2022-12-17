import java.util.Iterator;
import java.util.LinkedHashSet;

public class MyMain {
    public static void main(String [] args){
        MyCache LRU_Cache = new MyCache();
        Process p1 = new Process();
        Process p2 = new Process();
        Process p3 = new Process();
        Process p4 = new Process();
        
        LRU_Cache.addProcess(p1);
        LRU_Cache.addProcess(p2);
        LRU_Cache.addProcess(p3);
        LRU_Cache.addProcess(p4);
        LRU_Cache.addProcess(p1);
        LRU_Cache.printCache();
    }
}

class MyCache{
    int CACHE_SIZE = 4;
    LinkedHashSet<Process> hs = new LinkedHashSet<>();
    
    public void addProcess(Process p) {
        if (hs.size() < CACHE_SIZE) {
            if (hs.contains(p)) {
                hs.remove(p);
                hs.add(p);
            }
            else
                hs.add(p);
        }
        else {
            hs.remove(p);
            hs.add(p);
        }
    }
    
    public void printCache() {
        
        Iterator <Process> itr = hs.iterator();
        int printCount = 0;
        for (int i = 0; i < hs.size(); i++) {         
            printCount++;
            System.out.println("\t---------------\n\t| Process : " + itr.next().PROCESS_ID + " |\n\t---------------\n");
        }
        
        
        while (printCount != CACHE_SIZE) {
            printCount++;
            System.out.println("\t---------------\n\t|  EMPTY SLOT |\n\t---------------\n");
        }
        itr = hs.iterator();
        System.out.println("    LRU Process --> Process " + itr.next().PROCESS_ID);
    }
    
    public Iterator<Process> getIterator(){
        return hs.iterator();
    }
}

class Process{
    static int processCount = 0;
    final int PROCESS_ID;
    {
        processCount++;
        PROCESS_ID = processCount;
    }
}

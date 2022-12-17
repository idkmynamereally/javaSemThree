import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMain {
    public static void main(String [] args){
        List<MyInt> arr = new ArrayList<>();
        arr.add(new MyInt(1));
        arr.add(new MyInt(2));
        arr.add(new MyInt(3));
        arr.add(new MyInt(4));
        Collections.sort(arr);
        for (int i = 0; i < 4; i++) {
            System.out.println(arr.get(i));
        }
    }
}

class MyInt implements Comparable<MyInt>{
    Integer value;
    MyInt(int value){
        this.value = value;
    }
    public int compareTo(MyInt i2) {
        return i2.value.compareTo(value);
    }    
    public String toString() {
        return value.toString();
    }
}

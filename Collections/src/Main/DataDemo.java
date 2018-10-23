package Main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDemo {
    public static List<Integer> getAll(Data data) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }
}

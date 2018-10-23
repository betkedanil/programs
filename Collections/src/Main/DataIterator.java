package Main;

import java.util.Iterator;

public class DataIterator implements Iterator<Integer> {
    private Data data;
    private int[] dataIntegers;
    private int index;

    public DataIterator(Data data) {
        this.data = data;
        this.index = -1;
        int dataIntegersLength = 0;
        int counter = 0;
        for (Group group: data.getData()) {
            dataIntegersLength += group.getLength();
        }
        dataIntegers = new int[dataIntegersLength];
        for (Group group: data.getData()) {
            for (int integer: group.getData()) {
                dataIntegers[counter++] = integer;
            }
        }
    }

    public boolean hasNext() {
        return index + 1 < dataIntegers.length;
    }

    public Integer next() {
        return dataIntegers[++index];
    }
}

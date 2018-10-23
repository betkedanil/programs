package Main;

import java.util.Iterator;

public class Data implements Iterable<Integer> {
    private String name;
    private Group[] data;

    public Data(String name, Group ... data) {
        setName(name);
        setData(data);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getData() {
        return data;
    }

    public void setData(Group[] data) {
        this.data = data;
    }

    public int getLength() {
        return getData().length;
    }

    public Iterator<Integer> iterator() {
        return new DataIterator(this);
    }
}

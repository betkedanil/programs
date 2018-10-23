package Main;

public class Group {
    private int identifier;
    private int[] data;

    public Group(int identifier, int ... data) {
        setIdentifier(identifier);
        setData(data);
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getLength() {
        return getData().length;
    }
}

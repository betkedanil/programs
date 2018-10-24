package Matrix.src.main.java;

public interface IMatrix {
    double getElem(int i, int j);
    void setElem(int i, int j, double elem);
    double determinant();
}

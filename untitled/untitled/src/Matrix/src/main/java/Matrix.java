package Matrix.src.main.java;

import java.util.Arrays;

public class Matrix implements IMatrix {
    private double[] data;
    private int size;
    private double det;
    private boolean detActual;

    public Matrix() {
        super();
    }

    public Matrix(int size) {
        this();
        setSize(size);
        setData(new double[size*size]);
        setDet(0);
        setDetActual(false);
    }

    private double[] getData() {
        return data;
    }

    private void setData(double[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.size = size;
    }

    public double getDet() {
        return det;
    }

    public void setDet(double det) {
        this.det = det;
    }

    public boolean isDetActual() {
        return detActual;
    }

    public void setDetActual(boolean detActual) {
        this.detActual = detActual;
    }

    public double getElem(int i, int j) {
        return getData()[i*size + j];
    }

    public void setElem(int i, int j, double elem) {
        getData()[i*size + j] = elem;
        setDetActual(false);
    }

    public double determinant() {
        if (isDetActual()) {
            return getDet();
        }

        Double determ = null;

        if (getSize() == 1) {
            determ = getElem(0, 0);
        } else if (getSize() > 1) {
            Matrix matrixCopy = new Matrix(getSize());
            for (int i = 0; i < getSize(); i++) {
                for (int j = 0; j < getSize(); j++) {
                    matrixCopy.setElem(i, j, getElem(i, j));
                }
            }

            for (int k = 0; k < matrixCopy.getSize(); k++) {
                if (matrixCopy.getElem(k, k) == 0) {
                    for (int i = 1+k; i < matrixCopy.getSize(); i++) {
                        if (matrixCopy.getElem(i, k) != 0) {
                            for (int j = k; j < matrixCopy.getSize(); j++) {
                                matrixCopy.setElem(k, j, matrixCopy.getElem(k, j) + matrixCopy.getElem(i, j));
                            }
                            break;
                        }
                    }
                    if (matrixCopy.getElem(k, k) == 0) {
                        determ = 0.0;
                        break;
                    }
                }
                for (int i = 1+k; i < matrixCopy.getSize(); i++) {
                    double coeff = -matrixCopy.getElem(i, k) / matrixCopy.getElem(k, k);
                    for (int j = k; j < matrixCopy.getSize(); j++) {
                        matrixCopy.setElem(i, j, matrixCopy.getElem(i, j) + matrixCopy.getElem(k, j)*coeff);
                    }
                }
            }
            if (determ == null) {
                double d = 1.0;
                for (int i = 0; i < matrixCopy.getSize(); i++) {
                    d *= matrixCopy.getElem(i, i);
                }
                determ = d;
            }
        }

        setDet(determ);
        setDetActual(true);
        return determ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix = (Matrix) o;

        if (size != matrix.size) return false;
        return Arrays.equals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }
}

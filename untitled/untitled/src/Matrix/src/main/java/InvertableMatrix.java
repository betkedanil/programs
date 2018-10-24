package Matrix.src.main.java;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {
    public InvertableMatrix(int size) {
        super(size);
    }

    public InvertableMatrix(Matrix matrix) {
        this(matrix.getSize());
        if (matrix.determinant() == 0) {
            throw new IllegalArgumentException("matrix determinant is equal to 0");
        }
        setDet(matrix.getDet());
        setDetActual(matrix.isDetActual());
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                setElem(i, j, matrix.getElem(i, j));
            }
        }
    }

    public Matrix getInverseMatrix() {
        Matrix inverseMatrix = new Matrix(getSize());
        Matrix determMatrix = new Matrix(getSize()-1);
        int determMatrixElemCount;

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                determMatrixElemCount = 0;
                for (int k = 0; k < getSize(); k++) {
                    for (int l = 0; l < getSize(); l++) {
                        if (k != i && l != j) {
                            determMatrix.setElem(determMatrixElemCount / determMatrix.getSize(), determMatrixElemCount % determMatrix.getSize(), getElem(k, l));
                            determMatrixElemCount++;
                        }
                    }
                }
                inverseMatrix.setElem(j, i, ((i+j) % 2 == 0 ? 1 : -1 )*determMatrix.determinant() / determinant());
            }
        }
        return inverseMatrix;
    }
}

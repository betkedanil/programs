import myPrDir.interfaces.MatrixException;
import myPrDir.matrixes.InvertableMatrix;
import myPrDir.matrixes.Matrix;
import org.testng.annotations.Test;
import java.util.*;

import static myPrDir.matrixes.DemoMatrix.setUnitMatrix;
import static myPrDir.matrixes.DemoMatrix.setZeroMatrix;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestDemoMatrix {
    private double doubArr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    private Matrix  testArr = new Matrix(3, doubArr);

    @Test
    public void determTest() throws MatrixException {
         assertEquals(testArr.determinant(),0, 0.00001);
        testArr.setElem(0,0,-1);
         assertEquals(testArr.determinant(),6, 0.00001);
        testArr.setElem(0,0,8);
         assertEquals(testArr.determinant(),-21, 0.00001);
        setZeroMatrix(testArr);
         assertEquals(testArr.determinant(),0, 0.00001);
        setUnitMatrix(testArr);
         assertEquals(testArr.determinant(),1, 0.00001);
    }

    //@Test(expectedExceptions = MatrixException.class)
    @Test
    public void invertMatrTest() throws MatrixException {
        InvertableMatrix mtr = new InvertableMatrix(2);
        mtr.setElem(0,0,1);
        mtr.setElem(0,1,1);
        mtr.setElem(1,0,2);
        mtr.setElem(1,1,3);
        InvertableMatrix invMtr = new InvertableMatrix(2);
        invMtr.setElem(0,0,3);
        invMtr.setElem(0,1,-1);
        invMtr.setElem(1,0,-2);
        invMtr.setElem(1,1,1);

        assertTrue(invMtr.equals(mtr.getInverseMatrix()));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)    //тест исключения
    public void exceptionTest() throws MatrixException{
        setZeroMatrix(testArr);
        InvertableMatrix invArr = new InvertableMatrix(testArr);
        Matrix inverseArr = invArr.getInverseMatrix();
    }
}

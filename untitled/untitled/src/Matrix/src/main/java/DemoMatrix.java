package Matrix.src.main.java;

import com.google.gson.Gson;

import java.io.*;

public class DemoMatrix {
    public static void writeMatrix(Matrix matrix, OutputStream os) throws IOException {
        if (!os.equals(System.out)) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(Integer.toString(matrix.getSize()));
            bw.newLine();

            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    bw.write(String.format("%.2f ", matrix.getElem(i, j)));
                }
                bw.newLine();
            }
            bw.close();
        } else {
            System.out.println(Integer.toString(matrix.getSize()));
            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    System.out.print(String.format("%.2f ", matrix.getElem(i, j)));
                }
                System.out.println();
            }
        }
    }

    public static Matrix readMatrix(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Matrix matrix = new Matrix(Integer.parseInt(br.readLine()));
        for (int i = 0; i < matrix.getSize(); i++) {
            String[] mrow = br.readLine().split(" ");
            for (int j = 0; j < matrix.getSize(); j++) {
                matrix.setElem(i, j, Double.parseDouble(mrow[j].replace(',', '.')));
            }
        }
        br.close();
        return matrix;
    }

    public static double sumMatrix(Matrix matrix) {
        double sum = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                sum += matrix.getElem(i, j);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        try {
            Matrix matrix = readMatrix(new FileInputStream(new File("" +
                    "C:\\Users\\umdim\\IdeaProjects\\untitled\\src/matrix.txt")));
            writeMatrix(matrix, System.out);
            System.out.printf("Определитель = %.2f\n", matrix.determinant());

            matrix.setElem(2, 2, 26);
            writeMatrix(matrix, System.out);
            System.out.printf("Определитель = %.2f\n", matrix.determinant());

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("" +
                    "C:\\Users\\umdim\\IdeaProjects\\untitled\\src/serialize.txt")));
            new Gson().toJson(matrix, bw);
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(new File("" +
                    "C:\\Users\\umdim\\IdeaProjects\\untitled\\src/serialize.txt")));
            Matrix deserializedMatrix = new Gson().fromJson(br, Matrix.class);
            br.close();
            writeMatrix(deserializedMatrix, System.out);

           InvertableMatrix invmatrix = new InvertableMatrix(readMatrix(new FileInputStream(new File("" +
                    "C:\\Users\\umdim\\IdeaProjects\\untitled\\src/invmatrix.txt"))));
            System.out.println("\n:"); //*****//
           writeMatrix(invmatrix, System.out);
            Matrix inverseMatrix = invmatrix.getInverseMatrix();
            System.out.println("\nОбратная матрица:");
            writeMatrix(inverseMatrix, System.out);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

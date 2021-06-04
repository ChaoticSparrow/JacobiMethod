import java.util.Stack;

public class JacobiMethod {

    public static boolean isDiagonallyDominant(double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            double dia = Math.abs(matrix[i][i]);
            double nondia = 0;
            for(int j = 0; j < matrix[i].length; j++){
                if(j != i){
                    nondia += Math.abs(matrix[i][j]);
                }
            }
            if(nondia > dia){
                return false;
            }
        }

        return true;
    }

    public static Stack<double[][]> solveFor(double[][] matrix, double[][] b, double[][] x, int iterations) {
        Stack<double[][]> result = new Stack<>();
        double[][] inverseOfD = new double[matrix.length][matrix.length];
        double[][] nonDiagonal = new double[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    inverseOfD[i][j] = 1 / matrix[i][j];
                    nonDiagonal[i][j] = 0;
                } else {
                    inverseOfD[i][j] = 0;
                    nonDiagonal[i][j] = matrix[i][j];
                }
            }
        }

        result.push(x);

        for (int i = 0; i < iterations; i++) {
            double[][] NxX = matrixMultiplication(nonDiagonal, result.peek());
            double[][] bMinusNxX = matrixSubtraction(b, NxX);
            double[][] newX = matrixMultiplication(inverseOfD, bMinusNxX);

            result.push(newX);
        }

        return result;
    }

    public static double[][] matrixSubtraction(double[][] minuend, double[][] subtrahen) {
        double[][] result = new double[minuend.length][minuend[0].length];

        for (int i = 0; i < minuend.length; i++) {

            for (int j = 0; j < minuend[i].length; j++) {
                result[i][j] = minuend[i][j] - subtrahen[i][j];
            }
        }

        return result;
    }


    public static double[][] matrixMultiplication(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix2[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(matrix1, matrix2, row, col);
            }
        }

        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }
}

package cc.xpbootcamp.warmup.fibonacci;

class Matrix {
    private int length;
    long[][] matrix;

    Matrix(int length) {
        this.length = length;
        matrix = new long[length][length];
    }

    Matrix crossProduct(Matrix matrix) {
        Matrix resultMatrix = new Matrix(length);

        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    resultMatrix.matrix[i][j] += this.matrix[i][k] * matrix.matrix[k][j];
                }
            }
        }

        return resultMatrix;
    }

    static Matrix pow(Matrix matrix, int time) {
        Matrix resultMatrix = getUnitMatrix(matrix.length);

        for (; time > 0; time >>= 1) {
            if (time % 2 == 1) {
                resultMatrix = resultMatrix.crossProduct(matrix);
            }
            matrix = matrix.crossProduct(matrix);
        }
        return resultMatrix;
    }

    private static Matrix getUnitMatrix(int length){
        Matrix resultMatrix = new Matrix(length);

        for (int i = 0; i < length; i++) {
            resultMatrix.matrix[i][i] = 1;
        }
        return resultMatrix;
    }

    void show(){
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {
    public static long calculate(int position){
        if(position < 1 || position > 50){
            throw new RuntimeException("Position is not valid.");
        }
        if(position <= 2){
            return 1;
        }
        long nextResult;
        long currentResult = 1;
        long lastResult = 1;
        for (int i=2;i<position;i++){
            nextResult = currentResult + lastResult;
            lastResult = currentResult;
            currentResult = nextResult;
        }
        return currentResult;
    }

    public static long calculateByMatrix(int position){
        if(position <= 2){
            return 1;
        }

        Matrix originMatrix = new Matrix(2);
        Matrix TransferMatrix = new Matrix(2);

//     f1 f2
//      0 0
        originMatrix.matrix[0][0] = 1;
        originMatrix.matrix[0][1] = 1;

//      0 1
//      1 1
        TransferMatrix.matrix[0][1] = 1;
        TransferMatrix.matrix[1][0] = 1;
        TransferMatrix.matrix[1][1] = 1;

        Matrix resultMatrix = originMatrix.crossProduct(Matrix.pow(TransferMatrix,position-2));

        return resultMatrix.matrix[0][1];
    }
}

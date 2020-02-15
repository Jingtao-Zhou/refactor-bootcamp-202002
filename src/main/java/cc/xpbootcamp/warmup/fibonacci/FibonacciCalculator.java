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
}

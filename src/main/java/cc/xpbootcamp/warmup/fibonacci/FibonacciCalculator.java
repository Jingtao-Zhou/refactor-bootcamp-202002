package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {
    public static int calculate(int position){
        if(position <= 2){
            return 1;
        }
        int nextResult;
        int currentResult = 1;
        int lastResult = 1;
        for (int i=2;i<position;i++){
            nextResult = currentResult + lastResult;
            lastResult = currentResult;
            currentResult = nextResult;
        }
        return currentResult;
    }
}

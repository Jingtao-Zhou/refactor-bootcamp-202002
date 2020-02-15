package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciCalculatorTest {

    @Test
    void should_get_1_when_calculate_given_position_is_1() {
        //given
        int position = 1;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(1L,calculateResult);
    }

    @Test
    void should_get_1_when_calculate_given_position_is_2() {
        //given
        int position = 2;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(1L,calculateResult);
    }

    @Test
    void should_get_2_when_calculate_given_position_is_3() {
        //given
        int position = 3;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(2L,calculateResult);
    }

    @Test
    void should_get_12586269025_when_calculate_given_position_is_50() {
        //given
        int position = 50;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(12586269025L,calculateResult);
    }
}
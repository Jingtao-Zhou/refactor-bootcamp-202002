package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FibonacciCalculatorTest {

    @Test
    void should_get_1_when_calculate_given_position_is_1() {
        //given
        int position = 1;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(1L, calculateResult);
    }

    @Test
    void should_get_1_when_calculate_given_position_is_2() {
        //given
        int position = 2;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(1L, calculateResult);
    }

    @Test
    void should_get_2_when_calculate_given_position_is_3() {
        //given
        int position = 3;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(2L, calculateResult);
    }

    @Test
    void should_get_12586269025_when_calculate_given_position_is_50() {
        //given
        int position = 50;

        //when
        long calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(12586269025L, calculateResult);
    }

    @Test
    void should_get_exception_when_calculate_given_position_is_less_than_1() {
        //given
        int position = 0;

        //when
        try {
            long calculateResult = FibonacciCalculator.calculate(position);
        } catch (Exception e) {
            //then
            assertEquals("Position is not valid.", e.getMessage());
            return ;
        }
        fail();
    }

    @Test
    void should_get_exception_when_calculate_given_position_is_more_than_50() {
        //given
        int position = 51;

        //when
        try {
            long calculateResult = FibonacciCalculator.calculate(position);
        } catch (Exception e) {
            //then
            assertEquals("Position is not valid.", e.getMessage());
            return ;
        }
        fail();
    }

    @Test
    void should_get_12586269025_when_calculate_by_matrix_given_position_is_50() {
        //given
        int position = 50;

        //when
        long calculateResult = FibonacciCalculator.calculateByMatrix(position);

        //then
        assertEquals(12586269025L, calculateResult);
    }
}
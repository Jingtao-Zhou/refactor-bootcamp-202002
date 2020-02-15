package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciCalculatorTest {

    @Test
    void should_get_1_when_calculate_given_position_is_1() {
        //given
        int position = 1;

        //when
        int calculateResult = FibonacciCalculator.calculate(position);

        //then
        assertEquals(1,calculateResult);
    }
}

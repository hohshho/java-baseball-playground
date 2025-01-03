package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void testAdd() {
        // Given
        int a = 5;
        int b = 6;

        // When
        int sum = a + b;

        // Then
        assertThat(sum).isEqualTo(11);
    }

    @Test
    public void testSubtract() {
        // Given
        int a = 5;
        int b = 6;

        // When
        int sum = a - b;

        // Then
        assertThat(sum).isEqualTo(-1);
    }

    @Test
    public void testMultiply() {
        // Given
        int a = 5;
        int b = 6;

        // When
        int sum = a * b;

        // Then
        assertThat(sum).isEqualTo(30);
    }

    @Test
    public void testDivide() {
        // Given
        int a = 5;
        int b = 6;

        // When
        int sum = a / b;

        // Then
        assertThat(sum).isEqualTo(0);
    }
}

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumbersBaseballTest {

    @Test
    void getResultOneBall() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"0", "1", "2"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void getResultTwoBall() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"0", "1", "5"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void getResultThreeBall() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"9", "1", "5"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    void getResultOneStrike() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"1", "0", "0"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void getResultTwoStrike() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"1", "5", "0"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getStrike()).isEqualTo(2);
    }

    @Test
    void getResultThreeStrike() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"1", "5", "9"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getStrike()).isEqualTo(3);
    }

    @Test
    void getResultOneBallOneStrike() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"5", "0", "9"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void getResultTwoBallOneStrike() {
        // Given
        String[] answer = {"1", "5", "9"};
        String[] input = {"5", "1", "9"};
        NumbersBaseball numbersBaseball = new NumbersBaseball();

        // When
        NumbersBaseball.Result result = numbersBaseball.getResult(input, answer);

        // Then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void isStrike() {
        // Given
        NumbersBaseball numbersBaseball = new NumbersBaseball();
        String item = "1";
        String[] input = {"1", "5", "9"};
        boolean[] checked = {false, false, false};
        int index = 0;

        // When
        boolean result = numbersBaseball.isStrike(item, input, checked, index);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void isBall() {
        // Given
        NumbersBaseball numbersBaseball = new NumbersBaseball();
        String item = "1";
        String[] input = {"1", "5", "9"};
        boolean[] checked = {false, false, false};
        int index = 1;

        // When
        boolean result = numbersBaseball.isBall(item, input, checked, index);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    void isBallExceptStrike() {
        // Given
        NumbersBaseball numbersBaseball = new NumbersBaseball();
        String item = "1";
        String[] input = {"1", "5", "9"};
        boolean[] checked = {false, false, false};
        int index = 0;

        // When
        boolean result = numbersBaseball.isBall(item, input, checked, index);

        // Then
        assertThat(result).isFalse();
    }
}
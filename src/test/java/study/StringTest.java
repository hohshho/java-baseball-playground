package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split12() {
        String input = "1,2";
        assertThat(input.split(",")).contains("12");
    }

    @Test
    void splitArray() {
        String input = "1";
        String[] items = input.split(",");
        assertThat(items).containsExactly("1");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        input = input.substring(1, 4);
        assertThat(input).contains("1,2");
    }

    @DisplayName("charAt 특정 위치 문자 가져오기")
    @Test
    void charAtTest() {
        // Given
        String input = "abc";

        // When
        char result = input.charAt(0);

        // Then
        assertEquals('a', result, "가장 첫번째 문자는 a이다");
    }

    @DisplayName("chatAt 메소드 활용 시 위치 벗어나면 exception")
    @Test
    void charAtExceptionTest() {
        // Given
        String input = "abc";

        // Then
        assertThrows(StringIndexOutOfBoundsException.class, () -> input.charAt(-1), "벗어난 위치 조회 시 Exception발생");
    }

    @DisplayName("chatAt 메소드 활용 시 위치 벗어나면 exception2")
    @Test
    void charAtExceptionTest2() {
        // Given
        String input = "abc";

        // Then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                // When
                .isThrownBy(() -> {
                    input.charAt(-1);
                })
                .withMessageMatching("String index out of range: -\\d+"); // 예외 메시지 검증
    }
}

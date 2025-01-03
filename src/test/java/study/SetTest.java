package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void sizeCheck() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("set contains메소드 활용해 1,2,3값이 존재하는지 확인 - 중복 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void removeDuplicates(int num) {
        assertThat(numbers).contains(num);
    }


}

package lotto;

import lotto.domain.generator.NumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("랜덤 난수 생성기 테스트: 항상 6개, 1 ~ 45, 중복 없음")
    @Test
    public void testRandomNumberGenerator() {
        NumberGenerator generator = new RandomNumberGenerator();

        for (int i = 0; i < 50; i++) {
            List<Integer> nums = generator.generateNumbers();
            assertThat(new HashSet<>(nums)).hasSize(6); // 항상 6개, 중복 없음
            assertThat(nums).allMatch(n -> n >= 1 && n <= 45); // 1 ~ 45
        }
    }
}

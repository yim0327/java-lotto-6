package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.generator.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @DisplayName("로또 발행기 테스트: Lotto 객체 정상 반환 여부 검증")
    @Test
    public void testLottoMachine() {
        // given
        NumberGenerator generator = new NumberGenerator() {
            // 익명 메서드를 통해 고정된 값 반환.
            @Override
            public List<Integer> generateNumbers() {
                return List.of(3, 8, 13, 21, 26, 35);
            }
        };

        // when
        LottoMachine lottoMachine = new LottoMachine(generator);
        Lotto lotto = lottoMachine.issue();

        // then
        assertThat(lotto.getNumbers())
                .containsExactly(3, 8, 13, 21, 26, 35);
    }
}

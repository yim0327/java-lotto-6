package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoJudge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoJudgeTest {

    @DisplayName("로또 당첨 결과 계산 로직 테스트")
    @Test
    public void testLottoJudge() {
        // given
        LottoTickets lottoTickets = makeTestTickets();
        WinningNumbers winningNumbers = makeTestWinningNumbers();

        // when
        LottoJudge lottoJudge = new LottoJudge(lottoTickets, winningNumbers);
        Map<Rank, Integer> count = lottoJudge.judgeResult();

        // then
        assertThat(count.get(Rank.FIRST)).isEqualTo(1);
        assertThat(count.get(Rank.SECOND)).isEqualTo(1);
        assertThat(count.get(Rank.MISS)).isEqualTo(2);
    }

    private LottoTickets makeTestTickets() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(3, 8, 13, 21, 26, 35)));
        lottos.add(new Lotto(List.of(4, 9, 11, 23, 34, 45)));

        return new LottoTickets(lottos);
    }

    private WinningNumbers makeTestWinningNumbers() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;

        return new WinningNumbers(winningNum, bonusNum);
    }
}

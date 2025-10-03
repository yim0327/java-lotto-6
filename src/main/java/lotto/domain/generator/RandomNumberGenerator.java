package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoRules;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumbers() {
        return List.copyOf(Randoms.pickUniqueNumbersInRange(LottoRules.MIN, LottoRules.MAX, LottoRules.COUNT));
    }
}

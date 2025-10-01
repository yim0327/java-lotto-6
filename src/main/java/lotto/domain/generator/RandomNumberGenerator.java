package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> generateNumbers() {
        return List.copyOf(Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT));
    }
}

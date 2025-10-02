package lotto.domain;

import lotto.Lotto;
import lotto.domain.generator.NumberGenerator;

public class LottoMachine {
    private NumberGenerator generator;

    public LottoMachine(NumberGenerator generator) {
        this.generator = generator;
    }

    public Lotto issue() {
        return new Lotto(generator.generateNumbers());
    }
}

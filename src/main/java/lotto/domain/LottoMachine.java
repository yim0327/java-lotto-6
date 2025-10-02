package lotto.domain;

import lotto.Lotto;
import lotto.domain.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private NumberGenerator generator;
    private List<Lotto> lottos;

    public LottoMachine(NumberGenerator generator) {
        this.generator = generator;
        this.lottos = new ArrayList<>();
    }

    public LottoTickets issue(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generator.generateNumbers());
            lottos.add(lotto);
        }

        return new LottoTickets(lottos);
    }
}

package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class LottoTickets {
    private List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getEachLotto(int idx) {
        return lottos.get(idx);
    }
}

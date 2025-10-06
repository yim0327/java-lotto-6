package lotto.service;


import lotto.domain.*;

import java.util.Map;

public class LottoGame {
    private final LottoMachine lottoMachine;

    public LottoGame(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets purchaseLotto(Money money) {
        return lottoMachine.issue(money.purchaseCount());
    }

    public Map<Rank, Integer> judgeLotto(LottoTickets tickets, WinningNumbers criteria) {
        return new LottoJudge(tickets, criteria).judgeResult();
    }

    public Profit calculateProfit(Map<Rank, Integer> result, Money money) {
        return Profit.of(result, money.getAmount());
    }

}

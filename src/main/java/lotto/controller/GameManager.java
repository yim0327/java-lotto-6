package lotto.controller;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.service.LottoMachine;
import lotto.view.InputView;

public class GameManager {
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public GameManager(InputView inputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.lottoMachine = lottoMachine;
    }

    public void playGame() {
        // purchaseLotto();
    }

    private LottoTickets purchaseLotto() {
        int price = inputView.inputPrice();
        return lottoMachine.issue(new Money(price).purchaseCount());
    }

}

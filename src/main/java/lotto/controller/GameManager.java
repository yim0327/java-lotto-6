package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoJudge;
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
        Money money = inputMoney();
        LottoTickets tickets = purchaseLotto(money.getAmount());
        WinningNumbers criteria = winningNumbers();
        LottoJudge judge = new LottoJudge(tickets, criteria);
        Profit profit = calculateProfit(judge, money);

        printResult(judge, profit);
    }

    private Money inputMoney() {
        return new Money(inputView.inputPrice());
    }

    private LottoTickets purchaseLotto(int price) {
        return lottoMachine.issue(new Money(price).purchaseCount());
    }

    private WinningNumbers winningNumbers() {
        return new WinningNumbers(inputView.inputWinningNum(), inputView.inputBonusNum());
    }

    private Profit calculateProfit(LottoJudge judge, Money money) {
        return Profit.of(judge.judgeResult(), money.purchaseCount() * 1000);
    }

    private void printResult(LottoJudge judge, Profit profit) {
        // OutputView.printResult(judge.judgeResult());
        // OutputView.printProfit(profit.rate());
    }
}

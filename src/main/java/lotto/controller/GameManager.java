package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGame lottoGame;

    public GameManager(InputView inputView, OutputView outputView, LottoGame lottoGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGame = lottoGame;
    }

    public void playGame() {
        Money money = inputMoney();
        LottoTickets tickets = lottoGame.purchaseLotto(money);
        printTickets(tickets);

        WinningNumbers criteria = winningNumbers();
        Map<Rank, Integer> result = lottoGame.judgeLotto(tickets, criteria);
        Profit profit = lottoGame.calculateProfit(result, money);

        printResult(result, profit);
    }

    private Money inputMoney() {
        return new Money(inputView.inputPrice());
    }

    private void printTickets(LottoTickets tickets) {
        outputView.printTickets(tickets);
    }

    private WinningNumbers winningNumbers() {
        return new WinningNumbers(inputView.inputWinningNum(), inputView.inputBonusNum());
    }

    private void printResult(Map<Rank, Integer> result, Profit profit) {
        outputView.printResult(result);
        outputView.printProfit(profit.rate());
    }
}

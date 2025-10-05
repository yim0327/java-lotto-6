package lotto;

import lotto.controller.GameManager;
import lotto.service.LottoGame;
import lotto.service.LottoMachine;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator generator = new RandomNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);
        LottoGame lottoGame = new LottoGame(lottoMachine);
        GameManager manager = new GameManager(inputView, outputView, lottoGame);

        manager.playGame();
    }
}

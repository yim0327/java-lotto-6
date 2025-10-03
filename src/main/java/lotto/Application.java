package lotto;

import lotto.controller.GameManager;
import lotto.service.LottoMachine;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        NumberGenerator generator = new RandomNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);
        GameManager manager = new GameManager(inputView, lottoMachine);

        manager.playGame();
    }
}

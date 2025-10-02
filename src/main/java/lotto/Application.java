package lotto;

import lotto.controller.GameManager;
import lotto.service.LottoMachine;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameManager buyer = new GameManager();
        NumberGenerator generator = new RandomNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);

        buyer.buyLotto(InputView.inputPrice(), lottoMachine);
    }
}

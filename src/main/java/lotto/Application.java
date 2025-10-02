package lotto;

import lotto.domain.Buyer;
import lotto.domain.LottoMachine;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        NumberGenerator generator = new RandomNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(generator);

        buyer.buyLotto(InputView.inputPrice(), lottoMachine);
    }
}

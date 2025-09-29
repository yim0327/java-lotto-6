package lotto.domain;

import lotto.view.InputView;

public class Buyer {

    public void buyLotto() {
        int price = InputView.inputPrice();

        if (price%1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

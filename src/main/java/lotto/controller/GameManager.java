package lotto.controller;

import lotto.service.LottoMachine;

public class GameManager {

    public void buyLotto(int price, LottoMachine lottoMachine) {
        validate(price);
        int count = price/1000;
        lottoMachine.issue(count);
    }

    private void validate(int price) {
        if (price%1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로만 가능합니다.");
        }
    }
}

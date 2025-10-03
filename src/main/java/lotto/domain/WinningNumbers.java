package lotto.domain;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoRules.MIN || bonusNumber > LottoRules.MAX) {
            throw new IllegalArgumentException("보너스 번호는 "+LottoRules.MIN+"부터 "
                    +LottoRules.MAX+" 사이의 숫자여야 합니다.");
        }
    }
}

package lotto.domain;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberUnique(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.countMatch(winningNumbers);
        boolean bonusMatch = lotto.containsNumber(bonusNumber);
        return Rank.result(matchCount, bonusMatch);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoRules.MIN || bonusNumber > LottoRules.MAX) {
            throw new IllegalArgumentException("보너스 번호는 "+LottoRules.MIN+"부터 "
                    +LottoRules.MAX+" 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberUnique(int bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}

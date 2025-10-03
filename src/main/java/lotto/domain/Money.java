package lotto.domain;

public class Money {
    private final int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int purchaseCount() {
        return amount / 1000;
    }

    private void validate(int amount) {
        if (amount%1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1000원 단위로만 가능합니다.");
        }
    }
}

package lotto.domain;

public class Money {
    private final int amount;
    public static final int PRICE = 1000;

    public Money(int amount) {
        validatePrice(amount);
        this.amount = amount;
    }

    public int purchaseCount() {
        return amount / PRICE;
    }

    public int getAmount() {
        return amount;
    }

    private void validatePrice(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
        if (amount%PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 "+PRICE+"원 단위로만 가능합니다.");
        }
    }
}

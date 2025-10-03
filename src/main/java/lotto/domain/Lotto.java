package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoRules.MIN || number > LottoRules.MAX) {
                throw new IllegalArgumentException("로또 번호는 "+LottoRules.MIN+"부터 "
                        +LottoRules.MAX+" 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoRules.COUNT) {
            throw new IllegalArgumentException("로또 번호는 "+LottoRules.COUNT+"개의 숫자여야 합니다.");
        }
    }
}

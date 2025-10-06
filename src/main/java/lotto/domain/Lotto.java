package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateUnique(numbers);
        this.numbers = numbers.stream().sorted().toList();;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countMatch(Lotto other) {
        return (int) numbers.stream().filter(other::containsNumber).count();
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

    private void validateUnique(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}

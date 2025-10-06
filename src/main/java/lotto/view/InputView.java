package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int inputPrice() {
        while (true) {
            try {
                System.out.println("\n구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateNotBlank(input);
                validateIsNumeric(input);
                return Integer.parseInt(input.trim());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

    public Lotto inputWinningNum() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateNotBlank(input);
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)          // 앞뒤 공백 제거
                        .peek(InputView::validateIsNumeric) // 각 토큰은 숫자여야 함
                        .map(Integer::parseInt)     // 문자열 → 숫자
                        .collect(Collectors.toList());
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

    public int inputBonusNum() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                validateNotBlank(input);
                validateIsNumeric(input);
                return Integer.parseInt(input.trim());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }

    private void validateNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열이거나 공백일 수 없습니다.");
        }
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }
}

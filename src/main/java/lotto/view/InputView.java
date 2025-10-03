package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public List<Integer> inputResultNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Arrays.stream(input.split(","))
                .map(String::trim)          // 앞뒤 공백 제거
                .map(Integer::parseInt)     // 문자열 → 숫자
                .collect(Collectors.toList());

    }

    public int inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}

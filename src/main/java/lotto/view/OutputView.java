package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Rank;

import java.util.Map;

public class OutputView {

    public void printTickets(LottoTickets tickets) {
        System.out.println("\n"+tickets.getLottoCount()+"개를 구매했습니다.");
        for (int i = 0; i < tickets.getLottoCount(); i++) {
            System.out.println(tickets.getEachLotto(i).toString());
        }
    }

    public void printResult(Map<Rank, Integer> judgeResult) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - "+judgeResult.get(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50,000원) - "+judgeResult.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+judgeResult.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+judgeResult.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+judgeResult.get(Rank.FIRST)+"개");
    }

    public void printProfit(double profitRate) {
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
}

package lotto.domain;

import java.util.Map;

public class Profit {
    private final double rate;

    private Profit(double rate) {
        this.rate = rate;
    }

    // 정적 팩토리 메서드
    public static Profit of(Map<Rank, Integer> counts, int totalCost) {
        long totalPrize = getTotalPrize(counts);
        double rate = ((double) totalPrize / totalCost) * 100;
        double rounded = Math.round(rate * 10) / 10.0;
        return new Profit(rounded);
    }

    private static long getTotalPrize(Map<Rank, Integer> counts) {
        long totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : counts.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        return totalPrize;
    }

    public double rate() {
        return rate;
    }
}

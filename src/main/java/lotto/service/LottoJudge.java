package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoJudge {
    private final LottoTickets lottoTickets;
    private final WinningNumbers winningNumbers;

    public LottoJudge(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public Map<Rank, Integer> judgeResult() {
        Map<Rank, Integer> counts = makeEnumMap();

        for (int i = 0; i < lottoTickets.getLottoCount(); i++) {
            Rank rank = winningNumbers.match(lottoTickets.getEachLotto(i));
            counts.merge(rank, 1, Integer::sum); // 없으면 새로 추가, 있으면 +1 갱신
        }
        return counts;
    }

    private Map<Rank, Integer> makeEnumMap() {
        // EnumMap : Enum타입만을 key로 사용하는 특수한 Map
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Rank r : Rank.values()) {  // EnumMap 초기화
            map.put(r, 0);
        }

        return map;
    }

}

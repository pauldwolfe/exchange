package training.exchange.api;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SimulatedFeed {

    private final Instant start;
    private final int tickCount;
    private final int intervalMillis;
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    SimulatedFeed(Instant start, int tickCount, int intervalMillis) {
        this.start = start;
        this.tickCount = tickCount;
        this.intervalMillis = intervalMillis;
    }

    List<MarketSnapshot> play() {
        return Stream.iterate(start, d -> d.minus(intervalMillis, ChronoUnit.MILLIS))
                .limit(tickCount)
                .map(this::generateMarket)
                .collect(Collectors.toList());
    }

    private MarketSnapshot generateMarket(Instant dateTime) {
        Map<String, Double> data = new HashMap<>();
        data.put("BID_1", random.nextDouble(1.2, 1.21));
        data.put("BID_0", random.nextDouble(1.19, 1.2));
        data.put("ASK_0", random.nextDouble(1.21, 1.22));
        data.put("ASK_1", random.nextDouble(1.22, 1.23));
        return new MarketSnapshot(dateTime.toEpochMilli(), Symbols.EURUSD, data);
    }
}

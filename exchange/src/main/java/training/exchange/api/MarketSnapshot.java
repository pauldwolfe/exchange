package training.exchange.api;

import java.util.Map;

public class MarketSnapshot {

    private final long timestamp;
    private final Symbol symbol;
    private final Map<String, Double> data;

    MarketSnapshot(long timestamp, Symbol symbol, Map<String, Double> data) {
        this.timestamp = timestamp;
        this.symbol = symbol;
        this.data = data;
    }

    public Map<String, Double> getData() {
        return data;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "MarketSnapshot{" +
                "timestamp=" + timestamp +
                ", symbol=" + symbol +
                ", data=" + data +
                '}';
    }
}

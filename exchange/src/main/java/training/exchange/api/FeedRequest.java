package training.exchange.api;

public class FeedRequest {

    private final Symbol symbol;

    public FeedRequest(Symbol symbol) {
        this.symbol = symbol;
    }

    Symbol getSymbol() {
        return symbol;
    }
}

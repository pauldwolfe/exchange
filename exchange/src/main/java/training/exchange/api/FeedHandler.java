package training.exchange.api;

public interface FeedHandler {

    void handle(MarketSnapshot snapshot);
}

package training.exchange.api;

import java.time.Instant;
import java.util.*;

public class Exchange {

    private static final int TICK_COUNT = 1000;
    private static final int INTERVAL_MILLIS = 100;
    private final SimulatedFeed feed = new SimulatedFeed(Instant.now(), TICK_COUNT, INTERVAL_MILLIS);
    private final Set<RequestAndHandler> handlers = new HashSet<>();

    public void start() {
        for (MarketSnapshot marketSnapshot : feed.play()) {
            for (RequestAndHandler handler : handlers) {
                if (handler.getRequest().getSymbol().equals(marketSnapshot.getSymbol())) {
                    handler.getHandler().handle(marketSnapshot);
                }
            }
        }
    }

    public void subscribe(FeedRequest request, FeedHandler handler) {
        handlers.add(new RequestAndHandler(request, handler));
    }

    private class RequestAndHandler {
        private final FeedRequest request;
        private final FeedHandler handler;

        RequestAndHandler(FeedRequest request, FeedHandler handler) {
            this.request = request;
            this.handler = handler;
        }

        FeedRequest getRequest() {
            return request;
        }

        FeedHandler getHandler() {
            return handler;
        }
    }
}

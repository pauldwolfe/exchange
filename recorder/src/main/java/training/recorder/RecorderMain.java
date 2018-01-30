package training.recorder;

import training.exchange.api.*;

public class RecorderMain {

    public static void main(String[] args){
        Exchange exchange = new Exchange();

        // Add your request and recorder here!
        exchange.subscribe(new FeedRequest(Symbols.EURUSD), new FeedHandler() {
            public void handle(MarketSnapshot snapshot) {
                System.out.println(snapshot);
            }
        });
        exchange.start();
    }
}

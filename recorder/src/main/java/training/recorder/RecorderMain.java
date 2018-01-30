package training.recorder;

import training.exchange.api.*;

public class RecorderMain {

    public static void main(String[] args){
        Exchange exchange = new Exchange();

        // Add your request and recorder here!
        exchange.subscribe(null, null);
        exchange.start();
    }
}

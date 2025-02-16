package hw13Additional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Bar {
    private final ExecutorService bartenders;
    public Bar(String... bartenderNames){
        this.bartenders = Executors.newFixedThreadPool(
                bartenderNames.length,
                new ThreadFactory() {
                    private int index = 0;
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r, bartenderNames[index++]);
                        return t;
                    }
                }
        );
    }
    public void acceptOrder(Client client){
        bartenders.submit(() -> {
            String bartenderName = Thread.currentThread().getName();
            client.run();
            completeOrder(bartenderName, client);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            serveOrder(bartenderName, client);
        });
        
    }
    public void completeOrder(String bartenderName, Client client){
        System.out.println(bartenderName + " is completing an order: " + client.getDrink());
    }
    public void serveOrder(String bartenderName, Client client){
        System.out.println(bartenderName + " serves an order: " + client.getDrink());
    }
    public void close() {
        bartenders.shutdown();
    }
}

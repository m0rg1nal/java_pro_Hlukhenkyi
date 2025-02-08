package hw12;

public class MyThread extends Thread{
    DataHandler dataHandler = new DataHandler();

    public MyThread(String name, DataHandler dataHandler) {
        super(name);
        this.dataHandler = dataHandler;
    }

    @Override
    public void run() {
        dataHandler.getOutput();
    }
}

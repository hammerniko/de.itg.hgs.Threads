package B_ThreadErzeugenMitInterface;

public class MyThread implements Runnable {

    String name;
    Thread t;

    public MyThread(String name) {
        this.name = name;
        t = new Thread(this);
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public void start() {
        if (t.isAlive()) {
            t.start();
        }
    }

}

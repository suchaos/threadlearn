/**
 * ThreadTest1
 *
 * @author suchao
 * @date 2019/2/20
 */
public class ThreadTest1 {
    public int number = 0;

    public synchronized void increase() {
        while (number != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(number);
        notifyAll();
    }

    public synchronized void descrese() {
        while (number == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(number);
        notifyAll();
    }

    public static void main(String[] args) {
        ThreadTest1 test = new ThreadTest1();
        Thread threadIns = new IncreaseThread(test);
        Thread threadIns2 = new IncreaseThread(test);
        Thread threadDes = new DecreaseThread(test);
        Thread threadDes2 = new DecreaseThread(test);

        threadIns.start();
        threadIns2.start();
        threadDes.start();
        threadDes2.start();
    }
}

class IncreaseThread extends Thread {
    private ThreadTest1 test;

    public IncreaseThread(ThreadTest1 test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            test.increase();
        }
    }
}

class DecreaseThread extends Thread {
    private ThreadTest1 test;

    public DecreaseThread(ThreadTest1 test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            test.descrese();
        }
    }
}


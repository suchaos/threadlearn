/**
 * ThreadTest2
 *
 * @author suchao
 * @date 2019/2/20
 */
public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new HelloThread();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }

}

class HelloThread implements Runnable {

    int number;

    @Override
    public void run() {
        number = 0;

        while (true) {
            System.out.println("number: " + number++);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (number == 15) {
                break;
            }
        }


    }
}

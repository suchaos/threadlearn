/**
 * ThreadTest3
 *
 * 请问 world 会在 hello 之后输出吗
 *
 * @author suchao
 * @date 2019/2/20
 */
public class ThreadTest3 {
    public static void main(String[] args) {
        C c = new C();

        Thread threadHello = new T1(c);

        // c = new C();
        Thread threadWorld = new T2(c);

        threadHello.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread world start");
        threadWorld.start();

    }
}

class C {
    public synchronized void hello() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    public synchronized void world() {
        System.out.println("world");
    }
}

class T1 extends Thread {
    private C c;

    public T1(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.hello();
    }
}

class T2 extends Thread {
    private C c;

    public T2(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        c.world();
    }
}

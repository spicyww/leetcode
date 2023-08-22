import com.sun.jdi.ThreadReference;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // start方法用于启动一个分支线程，在JVM中开辟一个新的栈空间
        // 启动成功的线程会自动调用run方法，并且run方法在分支栈的地步
        myThread.start();
        //创建线程名字
        myThread.setName("1");
        //获取线程名字
        String name = myThread.getName();

        //获取当前线程（在main方法中的线程就是主线程）
        Thread current = Thread.currentThread();
        System.out.println(current.getName());

        // 创建一个可运行的对象
        // 把可运行的对象封装成一个线程对象
        Thread t = new Thread(new MyRunnable());
        t.start();

        // 线程sleep方法
        // 静态方法，让当前线程进入阻塞状态，放弃占用cpu时间片
        // 
        try {
            t.sleep(1000 * 5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        Thread t_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程3：" + i);
                }
            }
        });
        t_2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程:" + i);
        }
    }
}

class MyThread extends Thread{
    // 编写程序，这段程序运行在分支线程中（分支栈）
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("分支线程：" + i);
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("分支线程2：" + i);
        }
    }
}


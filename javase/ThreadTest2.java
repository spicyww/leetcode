import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

public class ThreadTest2 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Thread t1 = new Thread(new Producer(list));
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("shenchanzhe");
        t2.setName("xiaofeifzhe");

        t1.start();
        t2.start();

    }
}


class Producer implements Runnable{
    private List<Object> list;
    public Producer(List<Object> list){
        this.list = list;
    }

    @Override
    public void run() {
        // 持续生产
        while (true){
            synchronized (list){
                if(list.size() > 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "----->");
                list.notifyAll();
            }
        }

    }
}

class Consumer implements Runnable{
    private List<Object> list;
    public Consumer(List<Object> list){
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){
                if(list.size() == 0){
                    try {
                        list.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "----->");
                list.notifyAll();
            }
        }

    }
}
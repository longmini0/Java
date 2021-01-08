class TaskThread extends Thread {
    public void run() {
        System.out.print("Thread '" + getName() + "' from TaskThread started\n");

        for(int i = 0; i < 5; i ++) {
            System.out.println(getName() + " " + i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}

class TaskRunnable implements Runnable {
    public void run() {
        System.out.print("Thread '" + Thread.currentThread().getName() + "' from TaskRunnable started\n");

        for(int i = 0; i < 5; i ++) {
            System.out.println("Thread '" + Thread.currentThread().getName() + "' " + i);
        }
        System.out.println("TaskRunnable done");

    }
}

public class MinKyeonghoA6_Q2 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("TaskThread kicked off");
        TaskThread thread0 = new TaskThread();
        TaskThread thread1 = new TaskThread();
        thread0.start();
        thread1.start();

        thread0.join();
        thread1.join();

        System.out.println("TaskThread done\n\n");


        System.out.println("TaskRunnable kicked off");
        TaskRunnable thread2 = new TaskRunnable();
        Thread runnable = new Thread(thread2);
        runnable.start();

        System.out.println("Main kicked off");
        System.out.println("Thread '" + Thread.currentThread().getName() + "' from main started");
        for(int i = 0; i < 5; i ++) {
            Thread.yield();

            System.out.println("Thread '" + Thread.currentThread().getName() + "' " + i);
        }
        System.out.println("Main done");

    }
}

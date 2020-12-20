package experiment10.exp1.ThreadsDemos;

public class ThreadsPrintNumbers {
    public static void main(String[] args) {
        MyThread4 thread4 = new MyThread4();
        MyThread5 thread5 = new MyThread5();

        thread4.start();
        System.out.println("observe sequence");
        thread5.start();
        System.out.println("end!");//语句end
        /*调试过程中发现,当执行到语句end时,控制台未必有输出thread4和thread5线程所输出的处理结果.
        * 而且end!的输出时机也不固定,三个线程并行执行*/

    }

}

//ThreadClass1
class MyThread4 extends Thread {
    public void run() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("i=" + i);
        }
    }
}

class MyThread5 extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("    i=" + i);
        }
    }

}
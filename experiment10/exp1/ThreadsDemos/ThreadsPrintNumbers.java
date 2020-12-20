package experiment10.exp1.ThreadsDemos;

public class ThreadsPrintNumbers {
    public static void main(String[] args) {
        MyThread4 thread4 = new MyThread4();
        MyThread5 thread5 = new MyThread5();

        thread4.start();
        System.out.println("observe sequence");
        thread5.start();
        System.out.println("end!");//���end
        /*���Թ����з���,��ִ�е����endʱ,����̨δ�������thread4��thread5�߳�������Ĵ�����.
        * ����end!�����ʱ��Ҳ���̶�,�����̲߳���ִ��*/

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
package experiment10.exp1.ThreadsDemos;

public class DemoThread2 {
    public static void main(String[] args) {
//�����Զ����̶߳���
        MyThread2 mt = new MyThread2(" �µ��̣߳�");
//�������߳�
        mt.start();
//����������ִ��forѭ��
        for (int i = 0; i < 5000; i++) {
            System.out.println("main�߳�:" + i);
        }
    }
}

class MyThread2 extends Thread {
    //����ָ���߳����ƵĹ��췽��
    public MyThread2(String name) {
//���ø����String�����Ĺ��췽����ָ���̵߳�����
        super(name);
    }

    /*
     * ��дrun��������ɸ��߳�ִ�е��߼�
     */
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(getName() + "����ִ�У�" + i);
        }
    }
}


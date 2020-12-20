package experiment10.exp1.ThreadsDemos;

public class DemoThread2 {
    public static void main(String[] args) {
//创建自定义线程对象
        MyThread2 mt = new MyThread2(" 新的线程！");
//开启新线程
        mt.start();
//在主方法中执行for循环
        for (int i = 0; i < 5000; i++) {
            System.out.println("main线程:" + i);
        }
    }
}

class MyThread2 extends Thread {
    //定义指定线程名称的构造方法
    public MyThread2(String name) {
//调用父类的String参数的构造方法，指定线程的名称
        super(name);
    }

    /*
     * 重写run方法，完成该线程执行的逻辑
     */
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(getName() + "正在执行：" + i);
        }
    }
}


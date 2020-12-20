package experiment10.studyMultiDebug;

/**
 * @Author xuchaoxin
 * @Date 12/19/2020 2:24 PM
 * @Version 1.0
 */
import java.math.BigInteger;

public class MathProblemSolver {

    //开启两个线程
    public static void main(String arg[]){
        //第一个线程计算 100!
        FactorialCalculatingThread thread1 = new FactorialCalculatingThread(10088);
        //第二个线程计算 100000!
        FactorialCalculatingThread thread2 = new FactorialCalculatingThread(100000);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //线程Jion，以使主线程在“线程1”和“线程2”都返回结果之前不会进一步执行
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BigInteger result = thread1.getResult().add(thread2.getResult());
        System.out.println("将两个线程的计算结果相加等于：" + result);
    }

    //用于阶乘计算的线程类
    private static class FactorialCalculatingThread extends Thread {
        /*连个数值成员变量封装在线程类中.*/
        private BigInteger result = BigInteger.ONE;//初始化为1
            /* public static final BigInteger ONE = valueOf(1);*/
        private long num;

        /**
         * 构造方法:
         * @param num 传入需要被计算阶乘的整数factorial
         */
        public FactorialCalculatingThread(long num) {
            this.num = num;
        }

        /*调用计算方法,并将结果打印出来*/
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 开始阶乘的计算：" + num);
            factorialCalc(num);
            System.out.println(Thread.currentThread().getName() + "执行完成");
        }

        /**
         * 条件断点-只挂起符合条件的线程
         *
         * 假设我正在解决该程序中的错误，并且我只需要在“Thread 2”开始运行时就暂停执行。这表明我需要在FactorialCalculatingThread的run()方法的第一行上添加一个断点。
         * 因为我们开启的两个线程使用的是同一段代码，所以我们会遇到一个问题-使用该段代码的所有线程遇到断点都将被挂起,包括应用程序的“Thread 1”和“Thread 2”。
         * 我不希望两个线程都暂停。该怎么做？
         *
         * 我们可以使用条件断点功能.
         *添加断点后，右键单击它，选中“suspend”并选择“Thread”。
         * 然后我们添加  条件currentThread().getName().equals("Thread 2")，
         * 此条件确保调试器仅在当前线程的名称为“Thread 2”时才暂停当前线程：
         * @param num
         */
        //数的阶乘计算方法(采用纯大数类的方法运算)
        public void factorialCalc(long num) {
            BigInteger f = new BigInteger("1");//实例化一个大数对象,传入1到构造器
            for (int i = 2; i <= num; i++)
                f = f.multiply(BigInteger.valueOf(i));
                /*public BigInteger multiply(BigInteger val)*/
            result = f;
        }

        public BigInteger getResult() { return result; }
    }
}

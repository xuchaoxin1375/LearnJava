package experiment10.studyMultiDebug;

/**
 * @Author xuchaoxin
 * @Date 12/19/2020 2:24 PM
 * @Version 1.0
 */
import java.math.BigInteger;

public class MathProblemSolver {

    //���������߳�
    public static void main(String arg[]){
        //��һ���̼߳��� 100!
        FactorialCalculatingThread thread1 = new FactorialCalculatingThread(10088);
        //�ڶ����̼߳��� 100000!
        FactorialCalculatingThread thread2 = new FactorialCalculatingThread(100000);

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //�߳�Jion����ʹ���߳��ڡ��߳�1���͡��߳�2�������ؽ��֮ǰ�����һ��ִ��
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BigInteger result = thread1.getResult().add(thread2.getResult());
        System.out.println("�������̵߳ļ�������ӵ��ڣ�" + result);
    }

    //���ڽ׳˼�����߳���
    private static class FactorialCalculatingThread extends Thread {
        /*������ֵ��Ա������װ���߳�����.*/
        private BigInteger result = BigInteger.ONE;//��ʼ��Ϊ1
            /* public static final BigInteger ONE = valueOf(1);*/
        private long num;

        /**
         * ���췽��:
         * @param num ������Ҫ������׳˵�����factorial
         */
        public FactorialCalculatingThread(long num) {
            this.num = num;
        }

        /*���ü��㷽��,���������ӡ����*/
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ��ʼ�׳˵ļ��㣺" + num);
            factorialCalc(num);
            System.out.println(Thread.currentThread().getName() + "ִ�����");
        }

        /**
         * �����ϵ�-ֻ��������������߳�
         *
         * ���������ڽ���ó����еĴ��󣬲�����ֻ��Ҫ�ڡ�Thread 2����ʼ����ʱ����ִͣ�С����������Ҫ��FactorialCalculatingThread��run()�����ĵ�һ�������һ���ϵ㡣
         * ��Ϊ���ǿ����������߳�ʹ�õ���ͬһ�δ��룬�������ǻ�����һ������-ʹ�øöδ���������߳������ϵ㶼��������,����Ӧ�ó���ġ�Thread 1���͡�Thread 2����
         * �Ҳ�ϣ�������̶߳���ͣ������ô����
         *
         * ���ǿ���ʹ�������ϵ㹦��.
         *��Ӷϵ���Ҽ���������ѡ�С�suspend����ѡ��Thread����
         * Ȼ���������  ����currentThread().getName().equals("Thread 2")��
         * ������ȷ�����������ڵ�ǰ�̵߳�����Ϊ��Thread 2��ʱ����ͣ��ǰ�̣߳�
         * @param num
         */
        //���Ľ׳˼��㷽��(���ô�������ķ�������)
        public void factorialCalc(long num) {
            BigInteger f = new BigInteger("1");//ʵ����һ����������,����1��������
            for (int i = 2; i <= num; i++)
                f = f.multiply(BigInteger.valueOf(i));
                /*public BigInteger multiply(BigInteger val)*/
            result = f;
        }

        public BigInteger getResult() { return result; }
    }
}

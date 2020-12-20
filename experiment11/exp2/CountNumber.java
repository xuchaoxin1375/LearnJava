package experiment11.exp2;

/*输入一个100000位的数字，请计算这个数中各位数出现的次数。如输入1223，则各位数出现的次数为1：1次；2：2次；3：1次。*/
public class CountNumber {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        // System.out.println(Math.random());
        //存储生成的100000个随机数
        int[] numbers=new int[100000];
        for (int i = 0; i < 100000; i++) {
            //buffer.append((int) (Math.random() * 10));
            numbers[i]=(int) (Math.random() * 10);
        }
        //统计数组(十个数码)
        int[] intNumber = new int[10];
        int numberSignal;
        for (int i =0;i<100000;i++) {
//           numberSignal =(int) number;
            //numberSignal=Integer.parseInt(number);
            intNumber[numbers[i]]++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + intNumber[i] + "次");
        }
    }
}

package experiment11.exp2;

/*����һ��100000λ�����֣������������и�λ�����ֵĴ�����������1223�����λ�����ֵĴ���Ϊ1��1�Σ�2��2�Σ�3��1�Ρ�*/
public class CountNumber {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        // System.out.println(Math.random());
        //�洢���ɵ�100000�������
        int[] numbers=new int[100000];
        for (int i = 0; i < 100000; i++) {
            //buffer.append((int) (Math.random() * 10));
            numbers[i]=(int) (Math.random() * 10);
        }
        //ͳ������(ʮ������)
        int[] intNumber = new int[10];
        int numberSignal;
        for (int i =0;i<100000;i++) {
//           numberSignal =(int) number;
            //numberSignal=Integer.parseInt(number);
            intNumber[numbers[i]]++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + intNumber[i] + "��");
        }
    }
}

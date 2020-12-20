package experiment1;

/*���ַ����ڸı������ģ��ʱ��������Բ���*/
public class HanoiTower2 {
    public static int count = 0;

    public static void main(String[] args) {
        char[] current = {'A', 'A', 'A', 'A'};//����Բ�̵�ǰ��������λ��(���Ǹ���������),�տ�ʼ��ʱ��,����Բ�̶���A����,Բ����ĿΪ����ά��.����,�̴�С��������.
        int n = current.length;//Բ����Ŀ.
        char A = 'A', B = 'B', C = 'C';//�������ӵ�����

        hanoi(current, n, A, B, C);
        System.out.println(String.format("�ܹ��ƶ�����Ϊ%d��", count));
    }

    //���ķ���:hanoi:
    public static void hanoi(char[] current/*��������.*/, int n,/*�˵���Ŀ*/
                             char A, char B, char C) {
        //��������,�ƶ�Բ����һ����ͨ��current[i]=C����current[n-1]=C����ϵ;
        if (n == 1) {//�ݹ����
            int i = pickTopDisk(current, A); //����x�˶���Բ�̱��
            current[i] = C;//��i��Բ�������ĸ���ΪC��(��ʾ��i�����Ƶ�C�Ÿ���)
            count++;
            System.out.println("move " + count + " disk" + (i + 1) + ":" + A + "->" + C);//ע��,�����A,C���Ǳ���
            return;
        }

        hanoi(current, n - 1, A, C, B);//��֧�ݹ�1
        current[n - 1] = C;//current[n-1]������������ĸ˺�,�˴�Ҫ�����ƶ���C����,����Ϊ��current[n-1]�ĸ�ֵ�޸�.
        count++;
        System.out.println("move " + count + "disk " + n + ":" + A + "��" + C);
        hanoi(current, n - 1, B, A, C);//��֧�ݹ�2
    }

    public static int pickTopDisk(char[] current, char x) {
        int i = 0;
        /*//����x(��Ȼ����һ������������,x��ȡֵ��Χ(A/B/C)��  ����Բ��(�������������ȱ�xƥ�䵽(С�̺�һ��������(��������������������ǰ) ���i(���ڼ���Բ��:i��Բ��.);����i��ȡֵ��ΧΪ[0,1,2,...,n].;������Խ��ǰһ���ܹ��ҵ�X�˵�*/
        while (current[i] != x)

            i++;
        return i;
    }
}


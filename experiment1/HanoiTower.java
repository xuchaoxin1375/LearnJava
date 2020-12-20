package experiment1;

/*
hanoiTower��
  �������ˣ�A��B��C����n��Բ�̣����1��2������n��Բ�̰���С�����ţ�
  ��A���ƶ���C�ˣ�
  Ҫ���ƶ��в��ܰѴ��̷���С���ϣ�ֻ��С�̷��ڴ����ϡ��ƶ��Ĵ���Ҫ�����١�

*/
  /*
    HanoiTowerTower�Ĺؼ���������ʹ��A�����ϵ�n��Բ��,ͨ��һϵ���ƶ���(��Ϊf(n-1)��,f(n)��ʾ����ʹ������̸��ֳ�������Ҫ���ƶ�������),����ײ��n��Բ�̸���ˮ��;
         hanoi(n - 1, origin, destination, assist);//������������Ĳ�����hanoi����.
    ����,��Ҫ�ٰ�Բ��n�Ƶ�C����(���Ҵ�ʱ��C���ӻ���ʱ�յ�״̬��������n�̷���(n���������,ֻ�ܷ���������)(����֮����ʱ��Բ��n������Ϊ�ǹ̻���Cס����,û�б�Ҫ����������(�����ģ��С��һ��)),
        move(origin, destination);
    ��ʱB�����ϻ�����n-1��Բ��(������n-1���̻������������B������,��ʱ����Ҫ��B�����ϵ�n-1��Բ��,��ͨ��f(n-1)���ƶ�,����n-1��Բ�̶��ƶ���C������(���Է���,��һĿ�ĺ������n��Բ��ʱ���������Ǽ���һ����,
        hanoi(n - 1, assist, origin, destination);
    �����һ������,C���������е�Բ����;


    ���������ʵ��Ϊ�ݹ�:(�˴���assist����destination�����ƶ�����������ԵĽ�ɫ;)
        hanoi(n - 1, origin, destination, assist);
            move(origin, destination);
            hanoi(n - 1, assist, origin, destination);

    */
public class HanoiTower {

    // /*
    // *  n ���ӵ���Ŀ
    // *  origin Դ��
    // *  assist ������
    // * destination Ŀ����
    // */
    public int i;

    //n+1����ģ��Ҫ��Ϊ������ִ��,��Ҫִ������n����ģ�Ĳ���
    //һ���ݹ麯����(��Ч)��д��Ҫ������Ԥ�ȶԸú����������Ĺ��ܺͲ���(����)������),�Ͼ�,�ڱ�д��������Ĺ�����,���Ҫȥ��������.
    public void hanoi(int n/*���ӵ���Ŀ*/, char origin, char assist, char destination) {//�ݹ����(������:location_1)
        if (n == 1) {//�ݹ����(��Ҫ����)
            printMovement(origin, destination,n);//ִ��֮��ʼ"��Ĺ���",����else
        }
        else//���Ĳ���
        {
            /* �ݹ������,��������n-1��ͬһ��ֵ */
            hanoi(n - 1, origin, destination, assist);/*����ڲ�(Խ��Խ��,nԽС,����Ĺ��̱ض��Ƚ�������,�ٽ�������ڲ�,���Է������������assist������destination���������˶Ե�;
            ��һ���ֵ�n��С����ʱ��,�Ϳ��Ե��õ�����ȵ�move����,������ʼ"��"�Ĺ���;)*/
            printMovement(origin, destination,n);//��Ĺ����е���,�����origin��destination ��������location_1��һ�µ�
            hanoi(n - 1, assist, origin, destination);
        }//endElse
    }//endHanoi

    // move()����;Print the route of the movement
    private void printMovement(char origin, char destination, int n) {
        //states[i]=origin;
        System.out.println("move"+ ++i +":"+" " +"disk "+ n+":"
                +origin + "->" + destination);

    }

    public static void main(String[] args) {
        HanoiTower objHanoi = new HanoiTower();//newһ��HanoiTower����,����Ĭ�Ϲ��췽��
        objHanoi.hanoi(4, 'A', 'B', 'C');//����hanoihanoi����
    }
}

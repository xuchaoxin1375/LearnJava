package experiment3.exp2;
/*�����ϣ��������ϵ�������Ϊ�����һ����ϳɷ֣����Ը��ø���ķ�����
������Animal��Bird��Horse��
��Animal��ֱ���ϵ�Bird���Horse���С�
Animal���з���beat()�����System.out.println("��������...")����
��breath()�����System.out.println("������...")��
Bird�����з���fly()�����System.out.println("����������ڵķ���...")��
Horse���з���run()�����System.out.println("��½���ϵĿ��ٱ���...")��
�ֱ����Bird����ķ���breath()��fly()��
�Լ�Horse����ķ���breath()��run()*/
public class Demo {
    public static void main(String []args)
    {
        Animal bird = new Bird();
        Animal horse=new Horse();
        bird.beat();
        bird.breath();
        ((Bird)bird).fly();
        horse.beat();
        horse.breath();
        ((Horse)horse).run();
    }

}

package study.genericity;

class MyGenericMethod {
    /*���Ͳ�����MVP������
    * ��ͨ���ж��巺�ͷ���:(�ڷ�������ǰָ�����Ͳ���)(�ڷ������еķ��ͷ����򲻱��ص�˵�����Ͳ���)*/
    public <MVP> void show(MVP mvp) {

        System.out.println(mvp.getClass());//��ȡ���������������,����ӡ
    }

    public <MVP> MVP show2(MVP mvp) {
        return mvp;
    }

}

public class GenericMethodDemo {

    public static void main(String[]args) {
// ��������
        MyGenericMethod mm = new MyGenericMethod();/*������ʵ���������ʱ����Բ���Ϊ��ָ�����Ͳ�����ʲô,��ô����javaĬ��ָ��Ϊobject;
        ��һ����Ҫָ��һ�־�������(����������������������,���ݶ����༯��;�����Զ�̬�ش洢�����ͬ����Ķ���(è/��...)*/
// ��ʾ��������ʾ
        mm.show("aaa");
        mm.show(123);
        mm.show(12.45);
    }

}
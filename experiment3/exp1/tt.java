/*
* ����ҵ���и���Ա������������Ҫ���н�����
* ����һ���н��������װһϵ�е�  Ա��������
* ����һ��Э����(Mediator)�ӿ��������ͬ�£�Colleague������ͨ�š�
* ����Э���߶���(ConcreteMediator)ͨ��Э����ͬ�¶���ʵ��Э����Ϊ����ά�����ĸ���ͬ�µ�ͨ�š�
*   ÿһ��Ա����֪�������н��߶��� ÿһ��Ա������������������ͬ��ͨ�ŵ�ʱ����������Э����ͨ�š�
*
* ����ṹ���£�
�ӿ�interface :Mediator�з�����
* notice(String content)��
* ͬ����Colleague��
* �г��󷽷�work(),
*
* ����Э����ConcreteMediator���з���notice(String message)������˾����ʱ��֪ͨԱ��A��employeeA��Ŭ��д���룬
* ���ͻ����ˣ�֪ͨԱ��B��employeeB���㱨������
* Ա��A��Ա��B�̳�ͬ����Colleague,��ʵ�ֵ�work()�ֱ���д����ͻ㱨������(A,B�����ǲ�ͬ�ĸ�λ���͹���)
* ���ýӿںͶ�̬ʵ�������������̡�
*
*/
package experiment3.exp1;

public class tt {
    public static void main(String[]args){
        /*�ӿڵĶ�̬:*/
        Colleague employeeA=new EmployeeA();
        Colleague employeeB = new EmployeeB();
        ConcreteMediator concreteMediator1=new ConcreteMediator();
        concreteMediator1.notice("��˾����");
        concreteMediator1.notice("�ͻ�����");
    }
}

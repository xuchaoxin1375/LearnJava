package experiment3.exp1;

import java.util.Objects;

public class ConcreteMediator implements Mediator {
/*���ڲ�����������������,����ֱ���ڱ�����newһ��Ա��,�߼����ƺ����Ǻܺ�*/
    @Override
    public void notice(String content) {
        if (Objects.equals(content, "��˾����")) {
            System.out.println("��˾����");
            Colleague employeeA = new EmployeeA();
            employeeA.work();
        } else if (Objects.equals(content, "�ͻ�����")) {
            System.out.println("�ͻ�����");
            Colleague employeeB = new EmployeeB();
            employeeB.work();
        }

    }
}

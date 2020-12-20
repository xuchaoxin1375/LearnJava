package experiment3.exp1;

import java.util.Objects;

public class ConcreteMediator implements Mediator {
/*由于参数个数受题意限制,考虑直接在本类中new一个员工,逻辑上似乎不是很好*/
    @Override
    public void notice(String content) {
        if (Objects.equals(content, "上司来了")) {
            System.out.println("上司来了");
            Colleague employeeA = new EmployeeA();
            employeeA.work();
        } else if (Objects.equals(content, "客户来了")) {
            System.out.println("客户来了");
            Colleague employeeB = new EmployeeB();
            employeeB.work();
        }

    }
}

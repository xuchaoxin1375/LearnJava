/*
* 在企业中有各种员工，工作中需要进行交互。
* 现用一个中介对象来封装一系列的  员工交互。
* 定义一个协调者(Mediator)接口用于与各同事（Colleague）对象通信。
* 具体协调者对象(ConcreteMediator)通过协调各同事对象实现协作行为，并维护它的各个同事的通信。
*   每一个员工都知道它的中介者对象。 每一个员工对象在需与其他的同事通信的时候，先与他的协调者通信。
*
* 具体结构如下：
接口interface :Mediator有方法：
* notice(String content)，
* 同事类Colleague，
* 有抽象方法work(),
*
* 具体协调者ConcreteMediator，有方法notice(String message)，当上司来了时，通知员工A（employeeA）努力写代码，
* 当客户来了，通知员工B（employeeB）汇报工作。
* 员工A和员工B继承同事类Colleague,其实现的work()分别是写代码和汇报工作。(A,B可能是不同的岗位类型工种)
* 请用接口和多态实现上述交互过程。
*
*/
package experiment3.exp1;

public class tt {
    public static void main(String[]args){
        /*接口的多态:*/
        Colleague employeeA=new EmployeeA();
        Colleague employeeB = new EmployeeB();
        ConcreteMediator concreteMediator1=new ConcreteMediator();
        concreteMediator1.notice("上司来了");
        concreteMediator1.notice("客户来了");
    }
}

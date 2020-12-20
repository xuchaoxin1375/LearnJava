package experiment3.exp2;
/*类的组合，父类整合到子类作为子类的一个组合成分，可以复用父类的方法。
现有类Animal、Bird、Horse，
将Animal类分别组合到Bird类和Horse类中。
Animal类有方法beat()，输出System.out.println("心脏跳动...")，方
法breath()，输出System.out.println("呼吸中...")，
Bird类中有方法fly()，输出System.out.println("在天空中自在的飞翔...")，
Horse类有方法run()，输出System.out.println("在陆地上的快速奔跑...")。
分别调用Bird对象的方法breath()和fly()，
以及Horse对象的方法breath()和run()*/
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

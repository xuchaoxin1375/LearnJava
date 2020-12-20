package study.oop.example;

class HandlerBye extends Handlerr {
    public HandlerBye(Game game) {
        super(game);/*super()在不同的子类(继承自不同父类)的时候,所代表的的方法也不同,此处是
        oop.example.Handlerr @Contract(pure = true)
public Handlerr(Game game) 即当前类的父类Handlerr类的构造方法.*/
        /*当然,super一般不用写,系统会自加上,淡入如果构造器有参数的时候,那么就需要传参个super()了*/
    }
/*super()方法:(直接父类对象的引用。可以通过super.*来
访问和调用父类中被子类覆盖（重写）的方法或属性)*/
    @Override
    public boolean isBye() {
        return true;
    }

    @Override
    public void doCmd(String cmd) {
        /*空*/
    }

}

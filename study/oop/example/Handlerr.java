package study.oop.example;

abstract class Handlerr {
    protected Game game;

    /*在Handler类中创建一个Game对象的引用(管理者而已),用来记住*/
    public Handlerr(Game game) {
        this.game = game;
    }
    public boolean isBye() {
        return false;
    }
/*必须重写的*/
    public abstract void doCmd(String cmd) ;
}

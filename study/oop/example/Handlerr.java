package study.oop.example;

abstract class Handlerr {
    protected Game game;

    /*��Handler���д���һ��Game���������(�����߶���),������ס*/
    public Handlerr(Game game) {
        this.game = game;
    }
    public boolean isBye() {
        return false;
    }
/*������д��*/
    public abstract void doCmd(String cmd) ;
}

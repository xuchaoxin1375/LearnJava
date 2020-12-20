package study.oop.example;


public class HandlerHelp extends Handlerr {
    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        System.out.println("迷路了吗？可以输入：go/bye/help 如：\t go east");
    }


}


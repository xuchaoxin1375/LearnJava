package study.oop.example;


public class HandlerHelp extends Handlerr {
    public HandlerHelp(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String cmd) {
        System.out.println("��·���𣿿������룺go/bye/help �磺\t go east");
    }


}


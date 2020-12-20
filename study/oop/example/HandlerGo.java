package study.oop.example;
public class HandlerGo extends Handlerr {
    public HandlerGo(Game game) {
        super(game);
    }
    @Override
    public void doCmd(String cmd) {
        game.goRoom(cmd);
    }


}

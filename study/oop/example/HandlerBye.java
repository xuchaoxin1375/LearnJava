package study.oop.example;

class HandlerBye extends Handlerr {
    public HandlerBye(Game game) {
        super(game);/*super()�ڲ�ͬ������(�̳��Բ�ͬ����)��ʱ��,������ĵķ���Ҳ��ͬ,�˴���
        oop.example.Handlerr @Contract(pure = true)
public Handlerr(Game game) ����ǰ��ĸ���Handlerr��Ĺ��췽��.*/
        /*��Ȼ,superһ�㲻��д,ϵͳ���Լ���,��������������в�����ʱ��,��ô����Ҫ���θ�super()��*/
    }
/*super()����:(ֱ�Ӹ����������á�����ͨ��super.*��
���ʺ͵��ø����б����า�ǣ���д���ķ���������)*/
    @Override
    public boolean isBye() {
        return true;
    }

    @Override
    public void doCmd(String cmd) {
        /*��*/
    }

}

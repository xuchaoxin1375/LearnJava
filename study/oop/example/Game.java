package study.oop.example;
/*һ�����뵥ԪӦ�ø���һ���ۺϵ�����Ҳ����˵��һ��������Ա������� һ���߼���Ԫ����һ������Ӧ��ʵ��һ���߼���������һ����Ӧ�ô���һ�����͵�ʵ�塣�ۺ� ���۱����Ҫ�������ã����һ������������ֻ����һ��������ȷ�����飬��ô�ͺ��п����� ���ⲻͬ�������Ļ�����ʹ�á���ѭ������۵�һ������ĺô��ǣ�������ĳ���ֵĴ�����Ҫ �ı�ʱ����ĳ�����뵥Ԫ�кܿ��ܻ��ҵ�������Ҫ�ı����ش���Ρ�
�ӳ�����ʶ�����ܺ����ݣ��Դ���ʵ�ֿ�ܣ������ֹ��������ݵķ�ʽ���أ��������ںܴ�̶���ʵ�ֿ���չ�ԡ�*/
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    /*��Ա����һ��Room������,һ��HashMap����,�洢����ӳ��*/
    private Room currentRoom;
    private HashMap<String, Handlerr> handlers = new HashMap<>();
/*Game��������Ĺ�����constructor*/
    public Game() {
        /*�����õ���this�ǵ�ǰ���Game���������(����main(args)ʱʵ������һ����Ϸgame����.*/
       // System.out.println(this.getClass().getName());//�鿴һ��this��ָ������ɶ����(Game)
        //�ù������� �����ַ����Ͷ�Ӧ�Ĺ�����(Handler����������)����ӳ���ϵ����handlers������
        /*�ӳ�����ʶ�����ܺ����ݣ��Դ���ʵ�ֿ�ܣ�
        �����ֹ��������ݵķ�ʽ���أ�(��������Ĳ���)�������ںܴ�̶���ʵ�ֿ���չ�ԡ�*/
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("go", new HandlerGo(this));
        createRooms();

    }
/*���������Լ����ó�����Ϣ*/
    public void createRooms() {
        Room outside, lobby, pub, study, bedroom;/*����Ķ��ŵ��»����ȫ�߱�������*/
        //��������
        lobby = new Room("����");
        study = new Room("�鷿");
        outside = new Room("�Ǳ���");
        pub = new Room("�ư�");
        bedroom = new Room("����");
        //��ʼ������(ͬһ������������ö������.(���ڷ�����ͨ��ķ���)
        /*Ȼ��,�����ͨ·��ҪС��,ÿ�����䶼Ӧ����ȥ�л�,������뵽һ���µط���û���ṩͨ·,�Ǿ�������������.*/
        lobby.setExit("south", outside);
        lobby.setExit("west", bedroom);

        pub.setExit("west", outside);
        study.setExit("south", lobby);
        outside.setExit("east", pub);
        outside.setExit("north", lobby);
        bedroom.setExit("east", lobby);
/*��ʼ����ǰ���ڷ���(λ��)Ϊoutside(�Ǳ�����)*/
        currentRoom = outside;
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("��ӭ��");
        System.out.println();
        System.out.println("����һ���������ĵĳǱ���Ϸ");
        System.out.println();
        System.out.println("�������Ҫ����������:help");
        System.out.println();
        System.out.println("��ô���ڿ�ʼ�ɣ�");
        System.out.println();
        //System.out.println("��������" + currentRoom + " " + currentRoom.getExitDesc());
        showPrompt();
        System.out.println();
    }

    //����Ϊ�ṩ�û�(���)������(����):
    /*������ǰӦ�������ø��������Լ����ô洢�˸���������ߵķ���-�¸�λ�÷����ֵ�Ե���Ϣ.*/
    public void goRoom(String dir) {
        Room nextRoom = currentRoom.getExit(dir);
        if (nextRoom == null) {
            System.out.println("����û����");
        } else {
            currentRoom = nextRoom;//����currentRoom.
            /*System.out.println("��������" + currentRoom + " " + currentRoom.getExitDesc());
            System.out.println();*/
            showPrompt();
        }
    }
/*showPrompt������goRoom()����,�Ա㷴�������Ľ��*/
    public void showPrompt() {
        System.out.println("����" + currentRoom);
        System.out.print("������: ");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }
/*��ʼ��Ϸ:*/
    public void play() {
        Scanner in = new Scanner(System.in);//����һ��Scanner����;
        while (true) {
            System.out.println("��������ָ��:");
            String line = in.nextLine();//������ҵĲ����ַ���
            String[] words = line.split(" ");//Ԥ��������ҵĲ���,������Ľ�����뵽һ��String ������
            Handlerr handler;//����һ����������������(���������)
            //handlers������װ���Ź�����Ķ���(handlers������������Game����)
            handler = handlers.get(words[0]);/* ִ�д����һ���������:��ѯword[0]����������ʲô����(����);
                                            ����һ�������༴Handlerr��Ķ���(������,handler�Ѿ�ָ�����˹��ܶ���(������
                                            HandlerGo/HandlerHelp/HandlerBye�е�ĳһ��*/
            /*Ϊ����߽�׳��,����һ�������ַ�������value*/
            String value = " ";
            if (words.length >= 2) {
                /*����������ĺϷ�������,�ڶ�����һ���Ƿ���*/
                value = words[1];
            }
            /*�����ͷ���ص�handler���ܴ���(��handler!=null):*/
            if (handler != null) {

                handler.doCmd(value);/*ͨ�������������ö�Ӧ�Ĺ���(��Ȼ,�����ṩ�Ĳ������еڶ����ʵ�ֻ��go dir,yeҲ����˵,value����ǿ��ҺϷ��Ļ�,Ӧ����east/west/north/south�е�ĳ��*/
            /*��Ϸ�Ƿ���ֹ�ļ��׶�:*/
                if(!currentRoom.isSave()){break;}//��ǰ�Ƿ���������ͬ.//����,���isSave()�ľ���ʵ����Room�з����仯,ֻҪ���ܻ���һ��,�Ͳ���Ӱ�쵱ǰ����;
                /*bye�����Ƚ�����,�����е���ҿ�ִ�еĲ������ܵĹ��ܶ����ж���handlerr��������̳й���isBye()����,ֻ����,
                ����ͨ��HandlerBye���ܶ������isBye()�����жϽ���ǲŷ���true,Ĭ������¼̳й����Ķ���return false�Ĳ���
                ���صص��ж�һ���Ƿ���ֹ��Ϸ.(ͨ�����handler�Ƿ񷢳���ֹ���ź�(return true)*/
                if (handler.isBye()) {
                    break;
                }
            }

        }
        in.close();//������Console����������
    }

    public static void main(String[] args) {
        Game game=new Game();
        game.printWelcome();
        game.play();
        System.out.println("��л���Ĺ��١��ټ���");
    }
}

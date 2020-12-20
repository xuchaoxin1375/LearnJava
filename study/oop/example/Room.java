package study.oop.example;

import java.util.HashMap;

class Room {
    private String description;
    boolean isOk=true;
    /*����һ������*/
    private HashMap<String, Room> exits = new HashMap<String, Room>();//String�Ͷ��󱣴淽����ַ���,Room�Ͷ���Ϊ����
//constructor:�������Ǹ�ʲô����:
    public Room(String description) {
        this.description = description;
    }
//��дtoString�Ա��ӡ����(��ָ������(�ֶ�))
    public String toString() {
        return description;
    }

    //����(�÷���ָ�����ڷ���ͨ���ķ���)(����ʵ���ǽ�dir��roomӳ��Է�������exits������
    public void setExit(String dir, Room room) {
        exits.put(dir, room);
    }
//��ȡ���ڵ�������Ϣ:(�������б���ļ�(������)��ӡ����
    public String getExitDesc() {
        StringBuffer sb = new StringBuffer();//StringBuffer�����е����ݿ��Է���䶯,������С
        int cnt=0;
        for (String s : exits.keySet()) {//��������exits�б���ļ�ֵ.
            sb.append(s);//�����ؽ�����(�����Ǳ�ʾ������ַ���)��ӵ�StringBuffer������.
            sb.append(" ");//׷��һ���ո�������,
            cnt++;
        }//�����ʹﵽ��ʾ���,��ǰ����Щ���������
        //ͳһ������Щ�ַ���
        if(cnt==0){
            System.out.print("û���������������,");
            System.out.print("������������!!\n ��Ϸ����!");
            isOk=false;
        }
        return sb.toString();//�����ַ���
    }
//��ȡ��ǰ����ִ��go direction����ʱ���ᵽ���Ǹ��ط�(����)(��һ������Ҳ���ṩ��game�Ľӿ�
    public Room getExit(String direction) {
        return exits.get(direction);
    }
public boolean isSave(){return  isOk;}

}


package study.map;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        //����map����
        HashMap<String, String> map = new HashMap<>();

//���Ԫ�ص�����
        map.put("ͬѧ��", "ѧ������ϯ");
        map.put("ͬѧ��", "ѧ�������鳤");
        map.put("ͬѧ��", "ѧ������������");
        System.out.println(map);

//ɾ�� remove
        System.out.println("�Ƴ�����key��ӳ��"+map.remove("ͬѧ��")+"\n�鿴ɾ�����:"+map);

//��ͬѧ�ס�����ְ��
        //System.out.println("map.get(ͬѧ��)="+map.get("ͬѧ��"));
        System.out.println("map.get(\"ͬѧ��\")="+map.get("ͬѧ��"));
    }
}

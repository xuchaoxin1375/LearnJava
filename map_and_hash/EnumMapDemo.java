package map_and_hash;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

/*�����Ϊkey�Ķ�����enum���ͣ���ô��������ʹ��Java���Ͽ��ṩ��һ��EnumMap�������ڲ���һ���ǳ����յ�����洢value�����Ҹ���enum���͵�keyֱ�Ӷ�λ���ڲ������������������Ҫ����hashCode()������Ч����ߣ�����û�ж���Ŀռ��˷ѡ�
* ���Map��key��enum���ͣ��Ƽ�ʹ��EnumMap���ȱ�֤�ٶȣ�Ҳ���˷ѿռ䡣
ʹ��EnumMap��ʱ�򣬸�����������̵�ԭ��Ӧ����Map�ӿڡ�*/
public class EnumMapDemo {
    public static void main(String[] args) {
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        /*ʹ��EnumMap��ʱ������������Map�ӿ�����������
        ��ˣ�ʵ���ϰ�HashMap��EnumMap�������ڿͻ��˿���û���κ�����*/
        map.put(DayOfWeek.MONDAY, "����һ");
        map.put(DayOfWeek.TUESDAY, "���ڶ�");
        map.put(DayOfWeek.WEDNESDAY, "������");
        map.put(DayOfWeek.THURSDAY, "������");
        map.put(DayOfWeek.FRIDAY, "������");
        map.put(DayOfWeek.SATURDAY, "������");
        map.put(DayOfWeek.SUNDAY, "������");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}

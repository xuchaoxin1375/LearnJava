package study.map;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        //创建map对象
        HashMap<String, String> map = new HashMap<>();

//添加元素到集合
        map.put("同学甲", "学生会主席");
        map.put("同学乙", "学生会秘书长");
        map.put("同学丙", "学生会体育部长");
        System.out.println(map);

//删除 remove
        System.out.println("移除如下key的映射"+map.remove("同学乙")+"\n查看删除结果:"+map);

//查同学甲、丙的职务
        //System.out.println("map.get(同学甲)="+map.get("同学甲"));
        System.out.println("map.get(\"同学丙\")="+map.get("同学丙"));
    }
}
